# 🎓 Student Management System

A beginner-friendly **Student Management System** built using **Java, Spring Boot, Spring Data JPA, MySQL, and Thymeleaf**.

This project demonstrates how to build a complete CRUD-based web application using Spring Boot. It allows users to add, view, edit, and delete student records through a simple web interface.

The main purpose of this project is to understand the basic architecture and workflow of a Spring Boot application and learn how different layers such as **Entity, Repository, Service, and Controller** work together.

---

## 📌 Project Overview

The Student Management System is a web-based application designed to manage student information.

The application stores information such as:

* Student ID
* Student Name
* Email
* Phone Number
* Course
* Semester

Users can perform the following operations:

* ➕ Add a new student
* 👀 View all students
* ✏️ Edit student information
* 🗑️ Delete a student

The application uses **MySQL** as the database and **Spring Data JPA** to communicate with the database.

---

# 🚀 Features

## 1. Add Student

Users can add a new student by entering:

* Name
* Email
* Phone
* Course
* Semester

After submitting the form, the student information is stored in the MySQL database.

---

## 2. View Students

The application displays all registered students in a table.

The table contains:

| Field    | Description            |
| -------- | ---------------------- |
| ID       | Unique student ID      |
| Name     | Student's name         |
| Email    | Student's email        |
| Phone    | Student's phone number |
| Course   | Student's course       |
| Semester | Current semester       |

---

## 3. Edit Student

Users can edit the information of an existing student.

The application retrieves the selected student using their ID and displays the existing information in the form.

After making changes, the updated information is saved to the database.

---

## 4. Delete Student

Users can delete a student from the system.

The application identifies the student using their ID and removes the corresponding record from the database.

---

# 🛠️ Technologies Used

## Java

Java is used as the main programming language for developing the application.

The project uses Java to create:

* Entity classes
* Repository interfaces
* Service classes
* Controller classes

---

## Spring Boot

Spring Boot is used to create and run the web application.

It simplifies Spring application development by providing:

* Auto-configuration
* Embedded server
* Dependency management
* Easy application setup

---

## Spring Web

Spring Web is used to create web controllers and handle HTTP requests.

For example:

```text
GET  /students
GET  /students/new
POST /students/save
GET  /students/edit/{id}
GET  /students/delete/{id}
```

---

## Spring Data JPA

Spring Data JPA is used to communicate with the database.

Instead of writing SQL queries for basic operations manually, Spring Data JPA provides ready-made methods such as:

```java
save()
findAll()
findById()
deleteById()
```

---

## Hibernate

Hibernate is the JPA implementation used by Spring Boot.

It helps map Java objects to database tables.

For example:

```text
Java Class
    ↓
Student
    ↓
Database Table
```

---

## MySQL

MySQL is used as the relational database.

The application stores student information inside the MySQL database.

Database:

```text
student_management
```

---

## Thymeleaf

Thymeleaf is used as the server-side template engine.

It allows Java data to be displayed dynamically inside HTML pages.

For example:

```html
<tr th:each="student : ${students}">
```

This loops through the list of students received from the controller.

---

## Maven

Maven is used for:

* Dependency management
* Project building
* Running the Spring Boot application

The project contains:

```text
pom.xml
```

which defines the project's dependencies and configuration.

---

# 🏗️ Project Architecture

This project follows a layered architecture:

```text
                    USER / BROWSER
                          │
                          ▼
                    CONTROLLER
                          │
                          ▼
                       SERVICE
                          │
                          ▼
                     REPOSITORY
                          │
                          ▼
                        JPA
                          │
                          ▼
                       MYSQL
```

The application is divided into different layers so that each layer has a specific responsibility.

---

# 📂 Project Structure

The project structure looks like this:

```text
student-management
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.studentmanagement
│   │   │       │
│   │   │       ├── controller
│   │   │       │   └── StudentController.java
│   │   │       │
│   │   │       ├── entity
│   │   │       │   └── Student.java
│   │   │       │
│   │   │       ├── repository
│   │   │       │   └── StudentRepository.java
│   │   │       │
│   │   │       ├── service
│   │   │       │   └── StudentService.java
│   │   │       │
│   │   │       └── StudentmanagementApplication.java
│   │   │
│   │   └── resources
│   │       │
│   │       ├── templates
│   │       │   ├── students.html
│   │       │   └── student-form.html
│   │       │
│   │       └── application.properties
│   │
│   └── test
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

# 🧩 Understanding Each Layer

## 1. Entity

File:

```text
Student.java
```

The Entity represents the data that will be stored in the database.

Example:

```java
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String course;
    private int semester;
}
```

The `@Entity` annotation tells JPA that this Java class should be mapped to a database table.

The fields of the class represent the columns of the table.

Conceptually:

```text
Student.java
       ↓
Database Table
```

---

# 🗄️ Database Representation

The Student entity contains:

```text
id
name
email
phone
course
semester
```

These are stored in the database.

A simplified representation looks like:

```text
+----+---------+------------------+------------+--------+----------+
| ID | Name    | Email            | Phone      | Course | Semester |
+----+---------+------------------+------------+--------+----------+
| 1  | Rahul   | rahul@gmail.com  | 9876543210 | BCA    | 3        |
| 2  | Ahmed   | ahmed@gmail.com  | 9876543211 | BCA    | 2        |
+----+---------+------------------+------------+--------+----------+
```

The actual table is created/updated automatically by JPA according to the application configuration.

---

# 2. Repository

File:

```text
StudentRepository.java
```

The Repository is responsible for communicating with the database through Spring Data JPA.

```java
public interface StudentRepository extends JpaRepository<Student, Long> {

}
```

By extending `JpaRepository`, we automatically get methods such as:

```java
save()
findAll()
findById()
deleteById()
```

For example:

```java
studentRepository.save(student);
```

stores a student in the database.

---

# 3. Service

File:

```text
StudentService.java
```

The Service layer contains the application's business logic.

For example:

```java
public Student saveStudent(Student student) {
    return studentRepository.save(student);
}
```

The controller does not directly communicate with the repository.

Instead:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

This makes the application easier to maintain and understand.

---

# 4. Controller

File:

```text
StudentController.java
```

The Controller handles requests coming from the browser.

For example:

```java
@GetMapping("/students")
public String getStudents(Model model) {
    model.addAttribute("students", studentService.getAllStudents());
    return "students";
}
```

When the user visits:

```text
http://localhost:8080/students
```

Spring Boot sends the request to this controller method.

The controller then:

1. Calls the service
2. Gets student data
3. Sends the data to Thymeleaf
4. Returns the `students.html` page

---

# 🌐 How the Application Works

The complete flow is:

```text
Browser
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
JPA / Hibernate
   ↓
MySQL
```

For displaying data:

```text
MySQL
   ↓
JPA / Hibernate
   ↓
Repository
   ↓
Service
   ↓
Controller
   ↓
Thymeleaf
   ↓
HTML
   ↓
Browser
```

---

# 🔄 CRUD Operations

CRUD stands for:

```text
C → Create
R → Read
U → Update
D → Delete
```

## Create

Adding a new student:

```text
Form
 ↓
Controller
 ↓
Service
 ↓
Repository
 ↓
MySQL
```

---

## Read

Displaying students:

```text
MySQL
 ↓
Repository
 ↓
Service
 ↓
Controller
 ↓
Thymeleaf
 ↓
Browser
```

---

## Update

Editing a student:

```text
Select Student
 ↓
Get Student by ID
 ↓
Display Form
 ↓
Modify Data
 ↓
Save
 ↓
Database Updated
```

---

## Delete

Deleting a student:

```text
Delete Button
 ↓
Controller
 ↓
Service
 ↓
Repository
 ↓
Database
```

---

# 🖥️ Web Pages

The project currently contains two main Thymeleaf pages.

## Students Page

File:

```text
students.html
```

URL:

```text
http://localhost:8080/students
```

This page displays all students and provides buttons for:

* Add Student
* Edit
* Delete

---

## Student Form

File:

```text
student-form.html
```

URL:

```text
http://localhost:8080/students/new
```

This page contains the form for adding student information.

The same form is also used when editing an existing student.

---

# ⚙️ Database Configuration

The database configuration is stored in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_management
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Important

Replace:

```text
YOUR_MYSQL_PASSWORD
```

with your actual MySQL password.

**Do not upload your real database password to GitHub.**

---

# 🗃️ Creating the Database

Open MySQL Workbench or MySQL Command Line Client and run:

```sql
CREATE DATABASE student_management;
```

To verify:

```sql
SHOW DATABASES;
```

You should see:

```text
student_management
```

You do not need to manually create the student table because Hibernate/JPA can create it based on the Entity.

---

# 💻 Requirements

Before running the project, make sure you have:

* Java JDK 26
* Maven
* Spring Boot
* MySQL Server
* MySQL Workbench (optional)
* VS Code or another Java IDE
* Internet connection for Maven dependencies

---

# 📥 Installation

## Step 1: Clone the Repository

Clone the GitHub repository:

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

Move into the project directory:

```bash
cd student-management
```

---

# Step 2: Configure MySQL

Create the database:

```sql
CREATE DATABASE student_management;
```

Make sure MySQL Server is running.

---

# Step 3: Configure Application Properties

Open:

```text
src/main/resources/application.properties
```

Configure:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_management
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# Step 4: Run the Application

Open the terminal inside the project folder.

On Windows, run:

```bash
.\mvnw spring-boot:run
```

Alternatively, you can run the main Spring Boot application from VS Code.

If everything is configured correctly, you should see something similar to:

```text
Tomcat started on port 8080
Started StudentmanagementApplication
```

---

# 🌍 Open the Application

Open your browser and visit:

```text
http://localhost:8080/students
```

The Student Management System should now be available.

---

# 📋 Application URLs

| URL                     | Method | Purpose                  |
| ----------------------- | ------ | ------------------------ |
| `/students`             | GET    | Display all students     |
| `/students/new`         | GET    | Display add student form |
| `/students/save`        | POST   | Save student             |
| `/students/edit/{id}`   | GET    | Edit student             |
| `/students/delete/{id}` | GET    | Delete student           |

---

<<<<<<< HEAD
## 🌐 Network Graph Visualization

### Overview
The Student Management System includes an **interactive network graph visualization** that displays relationships between students, courses, and semesters in a visual format.

### Features
- **Management Hub (Center)** - Central node representing the core management system
- **Course Nodes** - Green box nodes representing different courses (BCA, BCOM, etc.)
- **Semester Nodes** - Purple diamond nodes representing different semesters
- **Student Nodes** - Orange circular nodes representing individual students
- **Interactive Physics-based Layout** - Nodes automatically arrange based on physics simulation
- **Hover Effects** - Interactive tooltips when hovering over nodes
- **Color-coded Connections** - Different edge colors for different relationship types

### Technology Stack
- **vis-network** - Interactive network visualization library via CDN
- **Thymeleaf** - Server-side data binding for dynamic graph generation
- **JavaScript** - Client-side graph rendering and physics simulation

### How It Works
The network graph dynamically generates nodes and edges based on:
1. **Root Node** - "Management Hub" as the central connection point
2. **Course Nodes** - Automatically created for each unique course in the database
3. **Semester Nodes** - Dynamically added for each semester level
4. **Student Nodes** - Each student creates a circular node
5. **Connections** - Edges link students to their respective courses and semesters

### Legend
```
🔵 Management Hub       - Central system node
🟢 Courses             - Course information nodes
🟣 Semesters           - Semester level nodes
🟠 Students            - Individual student records
```

### Accessing the Graph
Visit `http://localhost:8080/students` to see the network graph at the top of the page, followed by the student directory table below.

### Example Visualization
```
                    Management Hub
                    /      |      \
                   /       |       \
                BCA      BCOM      ...
               /   \    /   \
           Sem1  Sem2 Sem1  Sem2
           / |   / |  / |   / |
         S1 S2 S3 S4 S5 S6 S7 S8
```

Where:
- `S1, S2...` represent individual students
- Lines represent relationships between students, courses, and semesters

---

=======
>>>>>>> 86d886b0550d49870b157aaf8ba3c676f7cfa410
# 📦 Maven Dependencies

The project uses dependencies for:

* Spring Web
* Spring Data JPA
* MySQL Driver
* Thymeleaf
* Spring Boot DevTools

These dependencies are managed through:

```text
pom.xml
```

---

# 🔐 Security Note

Do not commit sensitive information such as:

```text
MySQL passwords
API keys
Secret keys
Personal credentials
```

For example, avoid uploading:

```properties
spring.datasource.password=MyRealPassword
```

to a public GitHub repository.

For a learning project, you can keep your local password in `application.properties` while adding that file to `.gitignore`, or use environment variables for a more production-friendly approach.

---

# 🧪 Testing the Application

After starting the application, test the following:

### Test 1 — Add Student

Open:

```text
http://localhost:8080/students/new
```

Enter student details and click:

```text
Save Student
```

---

### Test 2 — View Student

After saving, you should be redirected to:

```text
http://localhost:8080/students
```

The newly added student should appear in the table.

---

### Test 3 — Edit Student

Click:

```text
Edit
```

Change some information and save it.

The updated information should appear in the table.

---

### Test 4 — Delete Student

Click:

```text
Delete
```

The selected student should be removed from the database.

---

# 🧠 What I Learned From This Project

This project helped demonstrate the fundamentals of Spring Boot application development.

### Java

* Classes
* Objects
* Constructors
* Encapsulation
* Getters and setters
* Interfaces

### Spring Boot

* Spring Boot application structure
* Dependency Injection
* Controllers
* Services
* Repositories
* Annotations

### Spring MVC

* `@Controller`
* `@GetMapping`
* `@PostMapping`
* `@PathVariable`
* `Model`

### Spring Data JPA

* `@Entity`
* `@Id`
* `@GeneratedValue`
* `JpaRepository`
* CRUD operations

### Database

* MySQL
* Database creation
* Tables
* Connecting Java applications to MySQL

### Thymeleaf

* Dynamic HTML
* `th:each`
* `th:text`
* `th:field`
* `th:object`
* `th:action`

### Maven

* Dependency management
* Project building
* Running Spring Boot applications

---

# 📚 Project Learning Flow

The project was developed by following this basic process:

```text
1. Understand Project Requirements
             ↓
2. Decide What Data to Store
             ↓
3. Create Entity
             ↓
4. Create Repository
             ↓
5. Create Service
             ↓
6. Create Controller
             ↓
7. Create Thymeleaf Pages
             ↓
8. Connect MySQL
             ↓
9. Implement CRUD
             ↓
10. Run and Test Application
```

This structure can be reused in many future Spring Boot projects.

---

# 🔮 Future Improvements

The project can be extended with additional features in the future.

Possible improvements include:

* Student search
* Student filtering
* Pagination
* Form validation
* Better error handling
* Login and authentication
* User roles
* Admin dashboard
* Responsive UI
* Bootstrap integration
* REST API
* REST API documentation
* Student profile page
* Course management
* Department management
* Attendance management
* Marks management
* Database relationships
* Unit testing
* Integration testing
* Docker support

---

# 🎯 Future Project Architecture

As the project becomes more advanced, it can evolve into:

```text
                    FRONTEND
                       │
                       ▼
                  CONTROLLER
                       │
                       ▼
                    SERVICE
                       │
                       ▼
                  REPOSITORY
                       │
                       ▼
                   DATABASE
```

Additional components can later be added, such as:

```text
Security
Validation
DTOs
Exception Handling
REST APIs
Testing
Logging
```

---

# 📸 Screenshots

You can add screenshots of your application here after uploading them to your GitHub repository.

Example:

```markdown
## Screenshots

### Student List

![Student List](screenshots/student-list.png)

### Add Student

![Add Student](screenshots/add-student.png)
```

---

# 🤝 Contributing

This project was created as a learning project.

If you would like to improve it, you can:

1. Fork the repository
2. Create a new branch
3. Make your changes
4. Commit your changes
5. Create a Pull Request

Example:

```bash
git checkout -b feature/student-search
```

```bash
git add .
```

```bash
git commit -m "Add student search feature"
```

```bash
git push origin feature/student-search
```

---

# 📄 License

This project is created for educational and learning purposes.

You are free to use the source code to learn, modify it, and build your own projects.

---

# 👨‍💻 Author

**Samrudh hc**

BCA Student

---

# ⭐ Acknowledgement

This project was created as a hands-on learning project to understand how a Spring Boot application works from the database layer to the user interface.

The main goal was not only to create a working application, but also to understand the relationship between:

```text
Java
 ↓
Spring Boot
 ↓
Spring MVC
 ↓
Service Layer
 ↓
Spring Data JPA
 ↓
Hibernate
 ↓
MySQL
 ↓
Thymeleaf
 ↓
HTML
```

---

# ⭐ If You Like This Project

If this project helped you understand Spring Boot, consider giving the repository a ⭐ on GitHub.

---

## 📌 Summary

The **Student Management System** is a simple CRUD web application built with Spring Boot.

It demonstrates how a real-world application can be separated into different layers:

```text
Entity
   ↓
Repository
   ↓
Service
   ↓
Controller
   ↓
Thymeleaf
   ↓
Browser
```

This project provides a foundation for building larger Spring Boot applications in the future.
