## Lab3: Create a bookstore application which has CRUD operations.

The Book domain model which attributes: Id(int), title(string), isbn(string), price(double).

1. GET /books - return a List of books

2. GET /books/{id} - return a single book by Id

3. POST /books - add a new book

4. PUT /books/{id} - update a book by id

5. DELETE /books/{id} - delete a book by id

Since we haven't learnt persistence layer, so you can hardcoded book values in controller, we'll change it after we learnt Spring Data.

6. Add 4 types of version. You can choose each method to use 1 type of versioning, or refactor to have 4 different BookController, each 1 is 1 versioning style.

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
java -jar target/lab3-1.0.0.jar
```

To run the Spring Boot application with mvn plugin (mvn package not required)
```
mvn spring-boot:run
```


## To test the book APIs, please use Postman/curl or HttpClient with the provided template
