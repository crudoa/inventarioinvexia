# 📦 Inventory Management System API

Secure inventory management REST API built with Java 17 and Spring Boot. Features JWT authentication, role-based access control, full CRUD for products, categories, clients, providers, sales and purchases, and inventory movement tracking. Layered architecture, containerized with Docker Compose.

---

## 🚀 Tech Stack

- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- Maven
- Docker
- Docker Compose

---

## ✨ Features

- JWT-based authentication
- Role-based access control
- Full CRUD for:
  - Products
  - Categories
  - Clients
  - Providers
  - Sales
  - Purchases
- Inventory movement tracking
- Modular and layered architecture
- Dockerized environment

---

## 🧠 Architecture

Layered architecture:

Controller → Service → Repository → Database

Security flow:

JWT Filter → Security Config → Auth Controller

---

## 🔐 Authentication Flow

1. User logs in via `/auth/login`
2. JWT token is generated
3. Token must be included in headers:

```
Authorization: Bearer <token>
```

---

## 🐳 Run with Docker

```bash
docker-compose up --build
```

---

## ⚙️ Run Locally

```bash
./mvnw spring-boot:run
```

---

## 🔮 Future Improvements

- Swagger/OpenAPI documentation
- DTO layer separation
- Global exception handling
- Flyway database migrations
- CI/CD pipeline
- Cloud deployment (AWS / GCP)

---

## 👨‍💻 crudoa

Backend Developer focused on secure APIs and scalable backend architecture.
