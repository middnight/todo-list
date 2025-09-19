# Spring Boot Todo REST (Hindi)

Simple Todo REST backend using Spring Boot, Spring Data JPA and H2 database.
No UI included — only REST endpoints.

## Run locally
mvn clean package
mvn spring-boot:run
or
java -jar target/todo-list-0.0.1-SNAPSHOT.jar

Base URL: http://localhost:8081

## API Endpoints
POST   /tasks 
GET    /tasks/{id}
PUT    /tasks/{id}
DELETE  /tasks/{id}
