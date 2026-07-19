@echo off
REM backend\run-dev.bat
cd /d %~dp0

set "POSTGRES_USER=admin"
set "POSTGRES_PASSWORD=start234"
set "POSTGRES_URL=jdbc:postgresql://localhost:5432/finance_tracker"

call gradlew.bat bootRun --no-daemon

docker compose -f ..\docker\docker-compose.yml down
