# JWT Authentication with Spring Boot 3

A simple JWT (JSON Web Token) Authentication project built using Spring Boot and Spring Security.
This project demonstrates how to implement secure authentication and authorization using JWT tokens in a Spring Boot REST API.

---

## Features

* User Authentication using JWT
* Secure REST APIs with Spring Security
* Stateless Session Management
* Custom JWT Authentication Filter
* Login API for token generation
* Protected API endpoints
* Spring Boot 3 + Java 21 support

---

## Tech Stack

* Java 21
* Spring Boot 3.5
* Spring Security
* JWT (JJWT Library)
* Maven
* Lombok

---

## Project Structure

```bash
src/main/java/com/jwt/example
│
├── config
│   └── SecurityConfig.java
│
├── controllers
│   ├── AuthController.java
│   └── HomeController.java
│
├── models
│   ├── JwtRequest.java
│   ├── JwtResponse.java
│   └── User.java
│
├── security
│   ├── JwtAuthenticationEntryPoint.java
│   ├── JwtAuthenticationFilter.java
│   └── JwtHelper.java
│
├── services
│   └── UserService.java
│
└── JwtExample3Application.java
```

---

# API Endpoints

## 1. Login API

### Request

```http
POST /auth/login
```

### Request Body

```json
{
  "email": "anushka@gmail.com",
  "password": "1234"
}
```

### Response

```json
{
  "jwtToken": "your_generated_token",
  "username": "anushka@gmail.com"
}
```

---

## 2. Protected Test API

### Request

```http
GET /test
```

### Headers

```http
Authorization: Bearer your_jwt_token
```

### Response

```text
Testing message
```

---

# Security Flow

1. User sends email & password to `/auth/login`
2. Spring Security authenticates the user
3. JWT token is generated
4. Client stores token
5. Token is sent in Authorization Header
6. JWT filter validates token before accessing protected APIs

---

# Dependencies Used

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.12.6</version>
</dependency>
```

---

# Run Locally

## Clone Repository

```bash
git clone https://github.com/your-username/JwtExample3.git
```

## Navigate to Project

```bash
cd JwtExample3
```

## Run Application

```bash
mvn spring-boot:run
```

Application will start on:

```bash
http://localhost:8080
```

---

# Testing with Postman

## Step 1: Login

Send POST request to:

```bash
http://localhost:8080/auth/login
```

Copy generated JWT token.

---

## Step 2: Access Protected API

Send GET request to:

```bash
http://localhost:8080/test
```

Add header:

```http
Authorization: Bearer YOUR_TOKEN
```

---

# Important Notes

* JWT token validity is set to 5 hours.
* Session management is stateless.
* `/auth/login` is public.
* `/test` endpoint is protected.
* Secret key is currently hardcoded for learning/demo purposes.

---

# Future Improvements

* Database Integration (MySQL/PostgreSQL)
* User Registration API
* Role-Based Authorization
* Refresh Tokens
* BCrypt Password Encryption
* Docker Deployment

---

# Author

Developed by **Anushka Patel**

---
