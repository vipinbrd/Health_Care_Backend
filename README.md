# 🏥 Healthcare Backend (Spring Boot + MySQL)

This is a backend system for a healthcare application built using **Spring Boot**, **Spring Data JPA**, **MySQL**, and **JWT Authentication**. It provides secure APIs for user registration/login, patient management, doctor management, and patient-doctor mapping.

---

## ✅ Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Spring Security (JWT)
- Lombok
- Postman for testing

---

## 🧾 Features

- ✅ User Registration & Login with JWT
- ✅ Authenticated CRUD for Patients and Doctors
- ✅ Patient-Doctor Assignment and Mapping APIs
- ✅ Secure endpoints using JWT
- ✅ MySQL-based persistent storage

---

## 🗂️ Project Structure


---

## 🔐 Authentication Endpoints

| Method | Endpoint             | Description            |
|--------|----------------------|------------------------|
| POST   | `/api/auth/register` | Register a new user    |
| POST   | `/api/auth/login`    | Log in and get JWT     |

> 📌 These are the only public endpoints. All others require a valid JWT token.

---

## 🧑‍⚕️ Patient APIs (Authenticated)

| Method | Endpoint             | Description              |
|--------|----------------------|--------------------------|
| POST   | `/api/patients`      | Create a new patient     |
| GET    | `/api/patients`      | Get all patients by user |
| GET    | `/api/patients/{id}` | Get patient by ID        |
| PUT    | `/api/patients/{id}` | Update patient           |
| DELETE | `/api/patients/{id}` | Delete patient           |

---

## 🧑‍⚕️ Doctor APIs (Authenticated)

| Method | Endpoint             | Description        |
|--------|----------------------|--------------------|
| POST   | `/api/doctors`       | Create new doctor  |
| GET    | `/api/doctors`       | Get all doctors    |
| GET    | `/api/doctors/{id}`  | Get doctor by ID   |
| PUT    | `/api/doctors/{id}`  | Update doctor      |
| DELETE | `/api/doctors/{id}`  | Delete doctor      |

---

## 🔗 Patient-Doctor Mapping APIs (Authenticated)

| Method | Endpoint                     | Description                        |
|--------|------------------------------|------------------------------------|
| POST   | `/api/mappings`              | Assign doctor to patient           |
| GET    | `/api/mappings`              | Get all mappings                   |
| GET    | `/api/mappings/{patientId}`  | Get mappings for a patient         |
| DELETE | `/api/mappings/{mappingId}`  | Remove a doctor-patient mapping    |

---

## ⚙️ Setup Instructions


Configure MySQL

Create a database healthcare_db

Add your DB credentials to application.properties:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/healthcare_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
