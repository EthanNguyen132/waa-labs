## Lab7: Create a Spring Boot Web Project with following features

1. Create a UserController which can register a new User with email, password, roles

2. Create a BookController which has CRUD operations

3. Add Spring security features below:

   3.1 All authenticated users can get books

   3.2. Only Admin can update, delete, create a new Book

   3.3. all users(unauthenticated, authenticated) can register new user
## Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK)
- Apache Maven
- MySQL installation with schema named "lab4"

## Build the Application

To build the Spring Boot application and create a JAR file, run the following Maven command in the project directory:
```
mvn clean package
```

## Run the Application

To run the Spring Boot application as executable jar file, use the following command:

```
java -jar target/lab7-1.0.0.jar
```

To run the Spring Boot application with mvn plugin (mvn package not required)
```
mvn spring-boot:run
```

## Verify the tables created in "lab5" schema

