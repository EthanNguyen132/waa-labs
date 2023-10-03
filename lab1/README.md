# Lab1 Spring Boot Web App with Maven

- Observe @SpringBootApplication
- Create a Book domain model which attributes: Id(int), title(string), isbn(string), etc
- Create a RestController which simple GetMapping to return a collection of books
- practice lombok with different annotations
- set up Liveload
- set up http client or rest client as you want, we may use it in the future class


## Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK)
- Apache Maven


## Build the Application

To build the Spring Boot application and create a JAR file, run the following Maven command in the project directory:
```
mvn clean package
```

## Run the Application

To run the Spring Boot application, use the following command:
    
```
java -jar target/lab1-1.0.0.jar
```

To run the Spring Boot application with mvn plugin (mvn package not required)
```
mvn spring-boot:run
```

## To test the book collection API
```
curl http://localhost:8080/api/v1/books -v
```