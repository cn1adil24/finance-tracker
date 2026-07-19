# finance-tracker

## Run backend with PostgreSQL

The backend runs PostgreSQL in Docker. Container startup/shutdown is handled by a
wrapper script rather than by Gradle alone — see **Why a script?** below for the
reasoning.

### Requirements

- Docker installed and running
- Docker Compose available as `docker compose`

### Start backend

macOS / Linux:

```bash
cd backend
./run-dev.sh
```

Windows (PowerShell — recommended):

```powershell
cd backend
.\run-dev.ps1
```

Windows (Command Prompt — see caveat below):

```cmd
cd backend
run-dev.bat
```

### Stop backend and database

Press `Ctrl+C` in the terminal running the script. The script stops the Postgres
container for you once `bootRun` exits.

- **PowerShell / bash**: cleanup runs automatically, no action needed.
- **`.bat`**: when prompted `Terminate batch job (Y/N)?`, press **N** so the
  cleanup command still runs. Pressing Y skips it — use the PowerShell script if
  you want this to be automatic.

If Postgres is still running for any reason, stop it manually:

```bash
cd docker
docker compose down
```

### Why a script + a `DockerLifecycle` class?

Originally `bootRun` depended on `dockerComposeUp` and was `finalizedBy`
`dockerComposeDown`, with the idea that Gradle would tear the container down
automatically when you stopped the app. In practice this doesn't work reliably:

- **`finalizedBy` doesn't run on `Ctrl+C`.** It only fires when a task finishes
  as part of Gradle's normal task lifecycle. `Ctrl+C` aborts the build itself,
  so `dockerComposeDown` is never reached.
- **The Gradle Daemon intercepts the signal.** By default, `bootRun` executes
  in a background Daemon process, in a different process group from your
  terminal. `Ctrl+C` only reaches the terminal-facing `gradlew` client, which
  then asks the Daemon to cancel the build — and the Daemon responds by
  forcibly killing the forked app process rather than letting it shut down
  gracefully. `--no-daemon` fixes signal *delivery* but not this.
- **Even with `--no-daemon`, it's a race.** The app's JVM and Gradle's process
  both receive `Ctrl+C` at roughly the same time. The JVM starts its graceful
  shutdown (running `@PreDestroy`, which stops the container), but Gradle
  doesn't wait for that — it kills the forked process almost immediately,
  usually cutting the shutdown off mid-way.

**The fix has two parts:**

1. **`run-dev.sh` / `run-dev.ps1` / `run-dev.bat`** wrap `gradlew bootRun` in a
   parent process that Gradle doesn't control. Cleanup (`docker compose down`)
   runs in that parent process once `gradlew` exits — however it exits —
   sidestepping Gradle's own process-killing behavior entirely.
2. **`DockerLifecycle`** (`@PreDestroy` in
   `backend/src/main/java/com/vcoding/financetracker/config/DockerLifecycle.java`)
   stops the container from inside the JVM's own shutdown hook. This is kept as
   a second layer of defense for shutdowns that *don't* go through the
   Gradle-vs-Ctrl+C race — e.g. stopping the app from an IDE's "Stop" button,
   or `kill <pid>` sending `SIGTERM` directly to the JVM.

Note: The script only wraps *shutdown*; startup is still handled by Gradle's `dependsOn("dockerComposeUp")`, since that part works reliably and doesn't have the `Ctrl+C` race described above.

In short: the script guarantees cleanup regardless of how Gradle behaves; the
`@PreDestroy` hook is a backup for when the app is stopped some other way.
