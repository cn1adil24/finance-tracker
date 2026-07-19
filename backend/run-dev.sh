#!/usr/bin/env bash
# backend/run-dev.sh

export POSTGRES_USER="admin"
export POSTGRES_PASSWORD="start234"
export POSTGRES_URL="jdbc:postgresql://localhost:5432/finance_tracker

cd "$(dirname "$0")"
trap 'docker compose -f ../docker/docker-compose.yml down' EXIT
./gradlew bootRun --no-daemon
