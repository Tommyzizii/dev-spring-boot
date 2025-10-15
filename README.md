# Spring And Spring Boot Self-Learning Repository

Welcome! This repository is dedicated to **learning and practicing Spring Boot 3 and Spring Framework 6** through hands-on examples and real-time projects.  
The goal is to understand **modern Spring Boot development** using Java configuration, annotations, and best practices, without relying on XML.

---

## 📚 Topics Covered

### Core Spring Boot & Framework Concepts
- **Spring Boot 3 Core** – Auto-configuration, starters, embedded servers  
- **Spring Boot 3 Annotations** – `@Controller`, `@Service`, `@Repository`, `@RestController`, `@Entity`, etc.  
- **Java Configuration** – All Java-based configuration, no XML  
- **Spring Boot 3 & Spring MVC** – Controllers, request mappings, view resolution  
- **Hibernate / JPA CRUD** – Entity modeling, repositories, database operations  
- **Spring Boot 3 Security** – Authentication, authorization, password encryption  
- **REST APIs** – Building and consuming RESTful services  
- **Maven** – Project build and dependency management  

---

## 🛠 Real-Time Projects

This repository will include projects that demonstrate **full CRUD operations, security, and REST APIs**:

1. **Spring Boot 3 REST API**  
   - Full database CRUD  
   - Real-time example project  

2. **Spring Boot 3 REST API Security**  
   - Password encryption in the database  
   - Secure API endpoints  

3. **Spring Boot 3 with JPA / Spring Data JPA**  
   - Full database CRUD  
   - Practical use of repositories and JPA annotations  

4. **Spring Boot 3 with Spring Data REST**  
   - Full database CRUD  
   - Expose REST endpoints automatically from JPA repositories  

5. **Spring Boot 3 with Spring MVC & Thymeleaf**  
   - Full database CRUD  
   - Dynamic HTML pages rendered with Thymeleaf  

6. **Spring Boot 3 Spring MVC Security**  
   - Full database CRUD  
   - User authentication with password encryption  

---

## 💡 Learning Notes

- Focus on Java-based configuration over XML.
- Use Thymeleaf for dynamic HTML views.
- Use Spring Data JPA for database interactions.
- Use Spring Security for authentication/authorization and password encryption.
- Explore REST APIs with Postman or curl.
- Practice building full real-time CRUD applications.

---

## 🛣️ Course Pathway
- Frontend → Angular  
- Backend → Java SpringBoot  
- Full-stack exploration → Combine both worlds

---

## 💻 How To Run

### 🚀 Using Maven Wrapper (no need to install Maven globally)
If your project includes the Maven Wrapper (`mvnw`, `mvnw.cmd`, `.mvn/`):

```bash
# Step 1: Build the project
./mvnw package

# Step 2: Run the application
./mvnw spring-boot:run
# OR
java -jar target/<your-app-name>.jar
```

### 🚀 Using Installed Maven
If you already have Maven installed on your system:

```bash
# Step 1: Build the project
mvn package

# Step 2: Run the application
mvn spring-boot:run
# OR
java -jar target/<your-app-name>.jar
```

         
---

## ⚠️ Disclaimer

This repository is for educational purposes only. Code may be experimental and is meant for learning and practice, not production use.


