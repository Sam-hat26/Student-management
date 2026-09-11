# 🎓 Student Management System

A full-stack web application built with **Spring Boot**, **Spring Data JPA**, **Thymeleaf**, and **MySQL** for managing student details efficiently.

---

## 📌 Project Overview

The **Student Management System** provides a web-based user interface to perform full CRUD (Create, Read, Update, Delete) operations on student records. It also exposes a RESTful API endpoint for retrieving student data in JSON format.

---

## ✨ Features

- ➕ **Add Student**: Register new students with details including Name, Gender, Email, Mobile Number, Course, Semester, and Comments.
- 📋 **View Students**: Display a clean tabular view of all registered students.
- ✏️ **Edit Student**: Update existing student information seamlessly.
- 🗑️ **Delete Student**: Remove student entries from the system.
- 🔌 **REST API Endpoint**: Fetch all student records as JSON via `/api/students`.

---

## 🛠️ Tech Stack

- **Java**: 21
- **Framework**: Spring Boot 3.2.5 (Spring MVC, Spring Data JPA, Spring Boot DevTools)
- **Template Engine**: Thymeleaf
- **Database**: MySQL Server
- **Build Tool**: Maven (Maven Wrapper included)
- **Frontend**: HTML5, CSS3

---

## 📁 Project Structure

```text
studentmanagement/
├── src/
│   ├── main/
│   │   ├── java/rex/studentmanagement/
│   │   │   ├── controller/
│   │   │   │   └── StudentController.java
│   │   │   ├── entity/
│   │   │   │   └── Student.java
│   │   │   ├── repository/
│   │   │   │   └── StudentRepository.java
│   │   │   ├── service/
│   │   │   │   ├── StudentService.java
│   │   │   │   └── impl/
│   │   │   │       └── StudentServiceImpl.java
│   │   │   └── StudentmanagementApplication.java
│   │   └── resources/
│   │       ├── static/ (CSS and images)
│   │       ├── templates/ (Thymeleaf HTML templates)
│   │       └── application.properties
├── pom.xml
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed on your local machine:
- **Java Development Kit (JDK 21)** or higher
- **MySQL Server** (running locally on port 3306)
- **Git**

---

### Database Configuration

1. Start your MySQL server.
2. Create a new database named `student_db`:
   ```sql
   CREATE DATABASE student_db;
   ```
3. Update `src/main/resources/application.properties` with your MySQL credentials if different:
   ```properties
   spring.application.name=studentmanagement
   spring.datasource.url=jdbc:mysql://localhost:3306/student_db
   spring.datasource.username=root
   spring.datasource.password=YOUR_MYSQL_PASSWORD
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

---

### Running the Application

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Sam-hat26/Student-management.git
   cd Student-management
   ```

2. **Run using Maven Wrapper**:
   - On **Windows**:
     ```cmd
     mvnw.cmd spring-boot:run
     ```
   - On **Linux / macOS**:
     ```bash
     ./mvnw spring-boot:run
     ```

3. Open your web browser and navigate to:
   ```
   http://localhost:8080/
   ```

---

## 🔗 Application Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/` | Redirects to Student Registration Form |
| `GET` | `/student/new` | Displays Student Registration Form |
| `POST` | `/students/save` | Saves new or updated student details |
| `GET` | `/student` | Displays table of all registered students |
| `GET` | `/students/edit/{id}` | Form to edit student details by ID |
| `GET` | `/students/delete/{id}` | Deletes a student record by ID |
| `GET` | `/api/students` | REST API returning JSON list of all students |

---

## 📝 License

This project is open-source and available under the [MIT License](LICENSE).
