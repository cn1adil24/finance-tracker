# AI Agent Instructions for finance-tracker

## Current stack
- Backend: Java 25, Spring Boot 3.5, Gradle
- Persistence: Spring Data JPA + PostgreSQL
- Validation: Bean Validation
- API docs: springdoc OpenAPI
- Observability: Spring Boot Actuator

## Build and run
- Backend: cd backend && ./gradlew bootRun
- Tests: cd backend && ./gradlew test
- Docker database: cd docker && docker compose up -d

## Project structure
- backend/src/main/java/com/vcoding/financetracker/api
- backend/src/main/java/com/vcoding/financetracker/common
- backend/src/main/java/com/vcoding/financetracker/transaction

## Conventions
- Keep feature-based packages
- Keep DTOs separate from entities
- Use BigDecimal for money
- Use custom exceptions and a global exception handler
- Do not change the Docker lifecycle scripts unless the task explicitly requires it

## How to use this repository
- Before making changes, verify the actual project language/framework once source files are added.
- Do not assume a specific stack or build system; ask for clarification if the codebase grows.

## Current guidance for AI coding agents
- Treat this repository as an incomplete or starter project.
- If asked to implement features, first request the intended application structure and language.
- If the user adds source code, update this file with:
  - the main framework or runtime
  - build/test commands
  - folder layout and key entry points
