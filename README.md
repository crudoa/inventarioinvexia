# 📦 Inventory Management API

Backend system for inventory management built with Java and Spring Boot.

This project includes JWT authentication, RESTful endpoints, Docker containerization, and production-ready configuration.

---

## 🚀 Tech Stack

- Java 17+
- Spring Boot
- Spring Security
- JWT Authentication
- Maven
- Docker
- Docker Compose

---

## ✨ Features

- User authentication with JWT
- Role-based authorization
- RESTful API structure
- Inventory CRUD operations
- Dockerized deployment
- Modular backend architecture

---

## 🧠 Architecture

- Layered architecture (Controller → Service → Repository)
- JWT-based stateless authentication
- Environment-based configuration
- Containerized using Docker

---

## 📁 Project Structure

```
src/
 ├── controller/
 ├── service/
 ├── repository/
 ├── model/
 └── config/
```

---

## ⚙️ Running Locally

### 1️⃣ Clone repository

```bash
git clone https://github.com/crudoa/inventarioinvexia.git
cd inventarioinvexia
```

### 2️⃣ Run with Maven

```bash
./mvnw spring-boot:run
```

---

## 🐳 Running with Docker

Build and start containers:

```bash
docker-compose up --build
```

---

## 🔐 Authentication

Authentication is handled via JWT tokens.

After login, include the token in the header:

```
Authorization: Bearer <your_token>
```

---

## 🔮 Future Improvements

- API documentation with Swagger
- Database migration tool (Flyway)
- CI/CD pipeline
- Cloud deployment (AWS / GCP)
- Monitoring & logging

---

## 👨‍💻 crudoa

Backend Developer focused on scalable APIs and secure authentication systems.
