# backend/run-dev.ps1
Set-Location $PSScriptRoot

$env:POSTGRES_USER="admin"
$env:POSTGRES_PASSWORD="start234"
$env:POSTGRES_URL="jdbc:postgresql://localhost:5432/finance_tracker"

try {
    .\gradlew.bat bootRun --no-daemon
}
finally {
    docker compose -f ..\docker\docker-compose.yml down
}
