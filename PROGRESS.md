# Spring Boot + React.js Learning

## Project: Personal Finance Tracker

### Progress Tracker

---

# ✅ Phase 1 — Spring Boot & REST API Foundations

### Project Setup

* [x] Create Spring Boot project
* [x] Understand Gradle project structure
* [x] Learn Spring Boot auto-configuration
* [x] Run first Spring Boot application

### REST Fundamentals

* [x] Create REST controllers
* [x] Learn HTTP request/response lifecycle
* [x] Implement health endpoint
* [x] Understand REST principles

### Layered Architecture

* [x] Create Service layer
* [x] Separate Controller from business logic
* [x] Package by feature

### DTOs

* [x] Create request DTOs
* [x] Create response DTOs
* [x] Keep DTOs separate from internal models

### Exception Handling

* [x] Custom exceptions
* [x] GlobalExceptionHandler
* [x] Proper HTTP status codes

### CRUD (In-Memory)

* [x] Create transaction
* [x] Get all transactions
* [x] Get transaction by ID
* [x] Update transaction
* [x] Delete transaction
* [x] In-memory storage using HashMap

---

# ✅ Phase 2 — Persistence with PostgreSQL & JPA

### Docker

* [x] Docker Compose
* [x] PostgreSQL container
* [x] Persistent Docker volume
* [x] Environment variables

### Database Connection

* [x] Spring DataSource configuration
* [x] PostgreSQL JDBC driver
* [x] Hibernate configuration
* [x] JPA auto schema generation

### Entity Design

* [x] TransactionEntity
* [x] @Entity
* [x] @Table
* [x] @Id
* [x] @GeneratedValue
* [x] @Column
* [x] @Enumerated(EnumType.STRING)
* [x] BigDecimal for money
* [x] LocalDateTime mapping

### Repository Layer

* [x] JpaRepository
* [x] Dependency Injection
* [x] CRUD through repository

### Mapper Layer

* [x] TransactionMapper
* [x] DTO → Entity
* [x] Entity → DTO
* [x] Update existing entity from DTO

### Service Refactor

* [x] Remove HashMap storage
* [x] Use Repository
* [x] Constructor injection
* [x] DTO mapping via mapper

### CRUD (Database)

* [x] Create transaction
* [x] Get all transactions
* [x] Get transaction by ID
* [x] Update transaction
* [x] Delete transaction

### Architecture

* [x] Layered architecture
* [x] Feature-based package structure
* [x] Controller → Service → Repository
* [x] Entity separation from DTOs

---

# 🚧 Phase 3 — Production-Ready REST APIs

### Validation

* [x] Bean Validation
* [x] @Valid
* [x] @NotNull
* [x] @NotBlank
* [x] @Positive
* [x] Custom validation messages
* [x] Validation exception handling

### Code Quality / Tooling

* [ ] Add Lombok dependency
* [ ] Refactor entities with @Getter/@Setter
* [ ] Refactor DTOs with @Getter/@Setter/@AllArgsConstructor/@Builder
* [ ] Remove manual boilerplate

### Pagination

* [ ] Pageable
* [ ] Page<T>
* [ ] Pagination metadata

### Sorting

* [ ] Sorting by fields
* [ ] Ascending / Descending

### Filtering

* [ ] Filter by type
* [ ] Filter by date range
* [ ] Filter by amount
* [ ] Combined filters

### Searching

* [ ] Search by description
* [ ] Repository query methods

### API Design

* [ ] Consistent API error responses
* [ ] Better HTTP semantics
* [ ] ResponseEntity usage
* [ ] springdoc-openapi dependency
* [ ] Swagger UI endpoint
* [ ] Annotate controllers/DTOs for OpenAPI docs

### Observability

* [ ] Spring Boot Actuator
* [ ] Replace/augment custom HealthController
* [ ] Basic metrics endpoint

---

# ⏳ Phase 4 — Testing

* [ ] JUnit 5
* [ ] Mockito
* [ ] MockMvc
* [ ] Repository tests
* [ ] Controller tests
* [ ] Service layer unit tests

---

# ⏳ Phase 5 — Database Migrations

* [ ] Flyway setup
* [ ] Baseline migration for existing schema
* [ ] Database versioning
* [ ] Replace ddl-auto with managed migrations

---

# ⏳ Phase 6 — Domain Features

* [ ] Category entity
* [ ] Transaction ↔ Category relationship
* [ ] Budgets per category
* [ ] Recurring transactions
* [ ] Monthly summaries / reports endpoint

---

# ⏳ Phase 7 — Security

* [ ] CORS configuration
* [ ] Spring Security
* [ ] Authentication
* [ ] Authorization
* [ ] JWT
* [ ] BCrypt password hashing
* [ ] User entity
* [ ] User ↔ Transaction relationship
* [ ] Roles
* [ ] Protected endpoints

---

# ⏳ Phase 8 — Advanced Persistence

* [ ] Relationships
* [ ] One-to-Many
* [ ] Many-to-One
* [ ] Lazy vs Eager loading
* [ ] @Transactional
* [ ] Dirty Checking
* [ ] Optimistic locking
* [ ] Auditing
* [ ] Soft deletes

---

# ⏳ Phase 9 — Performance

* [ ] Database indexing
* [ ] Query optimization
* [ ] N+1 problem
* [ ] Fetch joins
* [ ] Connection pooling
* [ ] Hibernate performance
* [ ] Spring Cache
* [ ] Redis introduction

---

# ⏳ Phase 10 — Integration Testing

* [ ] Testcontainers
* [ ] Full-stack integration tests
* [ ] Security-aware test scenarios

---

# ⏳ Phase 11 — React Frontend

### React

* [ ] React setup
* [ ] TypeScript
* [ ] Routing
* [ ] Component architecture

### API Integration

* [ ] Axios
* [ ] Authentication
* [ ] CRUD screens
* [ ] Forms
* [ ] Validation
* [ ] Dashboard

### UI

* [ ] Responsive design
* [ ] Charts
* [ ] Statistics
* [ ] Error handling

---

# ⏳ Phase 12 — DevOps

* [ ] Dockerize Spring Boot
* [ ] Multi-container Docker Compose
* [ ] Profiles
* [ ] Production configuration
* [ ] GitHub Actions
* [ ] CI/CD
* [ ] Cloud deployment
* [ ] HTTPS
* [ ] Logging
* [ ] Monitoring

---

# ⏳ Phase 13 — Advanced Spring

* [ ] Spring Events
* [ ] Scheduling
* [ ] Async methods
* [ ] File uploads
* [ ] Email
* [ ] Spring Cache
* [ ] Redis
* [ ] WebSockets
* [ ] Messaging overview (RabbitMQ/Kafka)

---

## Current Project Status

Current backend architecture:

Controller
→ Service
→ Mapper
→ Repository
→ Hibernate
→ PostgreSQL

Implemented features:

* Persistent PostgreSQL storage
* Full CRUD API
* DTO-based architecture
* Layered design
* Feature-based package structure
* Dockerized development database

Current next milestone:
**Phase 3 — Lombok adoption, then Pagination, Sorting, Filtering, Searching, then OpenAPI docs**