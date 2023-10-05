## Lab4: Create a Spring Boot project to practice associations, there's no need to implement controllers, services and repositories.



1. Create a Bidirectional OneToMany association between Department and Employee using annotations.

2. Create an Unidirectional ManyToOne association between Book and Publisher using annotations

3. Create a Bidirectional ManyToMany association between Student and Course using annotations.

4. Create a Unidirectional OneToMany association between Customer and Reservation using annotations.

5. Create a Unidirectional ManyToOne association between Reservation and Book using annotations.

6. Create a Bidirectional ManyToOne association between Employee and Office using annotations.

For the attributes in each model in this Lab, you can use your creative intelligence to add as you want.
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
java -jar target/lab4-1.0.0.jar
```

To run the Spring Boot application with mvn plugin (mvn package not required)
```
mvn spring-boot:run
```

## Verify the tables created in "lab4" schema

