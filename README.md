# Soccer Club Backend

This is the backend service for the Soccer Club application. It provides RESTful APIs for managing coaches, contact submissions, and other soccer club-related data.

## Features
- Manage coaches (CRUD operations)
- Handle contact form submissions
- Secure endpoints for admin operations

## Tech Stack
- **Java**: Backend programming language
- **Spring Boot**: Framework for building REST APIs
- **Hibernate**: ORM for database interactions
- **H2 Database**: In-memory database for development
- **Maven**: Build tool

## Prerequisites
- Java 17 or higher
- Maven 3.8+
- A database (e.g., MySQL, PostgreSQL) for production

## Getting Started

### Clone the Repository

- git clone (https://github.com/RashmiLnu/soccer-club-backend.git)
- cd soccer-club-backend

### Configure the Application
1. Create a src/main/resources/application.properties file based on application-example.properties.
2. Add your database configuration:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/soccer_club
spring.datasource.username=your-username
spring.datasource.password=your-password
```

### Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

### API Endpoints
1. Coaches
   - GET /api/coaches: Get all coaches
   - GET /api/coaches/{id}: Get a coach by ID
   - POST /api/coaches: Create a new coach
   - PUT /api/coaches/{id}: Update a coach
   - DELETE /api/coaches/{id}: Delete a coach
2. Contact
   - POST /api/contact/submit: Submit a contact form
   - GET /api/contact/admin/submissions: Get all submissions (admin)
3. Contributing
   - Fork the repository.
   - Create a feature branch: git checkout -b feature-name.
   - Commit your changes: git commit -m "Add feature".
   - Push to the branch: git push origin feature-name.
   - Open a pull request.

Let me know if you need further assistance!
