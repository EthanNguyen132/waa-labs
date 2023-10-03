# Lab2: Create a Spring Boot Project to practice the following annotations

- @Controller - since we're practice @Controller, you need to include thymeleaf template engine, just define a page like in the class, return the page name. There's no need to understand the syntax to display model attributes, etc. We're going to build RESTful application in the future.
- @RequestMapping
- @GetMapping
- @RequestParam
- @PathVariable

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

To run the Spring Boot application as executable jar file, use the following command:

```
java -jar target/lab2-1.0.0.jar
```

To run the Spring Boot application with mvn plugin (mvn package not required)
```
mvn spring-boot:run
```



## To test the book collection API
```
curl http://localhost:8080/product -v
curl http://localhost:8080/getProduct?productId=2 -v
curl http://localhost:8080/product/3 -v
```