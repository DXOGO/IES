# Lab03 - **Multi-layer web applications with Spring Boot**

### - Develop web projects with Spring Boot. Create and persist entities into a relational database using Spring Data

### - Deploy Spring Boot application in Docker

\
.

## Lab03.1 - **Accessing databases in SpringBoot**

**Java Persistence API** (JPA): The Java ORM standard for **storing**, **accessing**, and **managing Java objects in a relational database**

It is concerned with *persistence*, which loosely means any mechanism by which Java objects outlive the application process that created them.
By itself, JPA is not a tool or framework; rather, it defines a set of concepts that can be implemented by any tool or framework.

**What is Java ORM?** (ORM):

Object-relational mapping is a task–one that developers have good reason to avoid doing manually.
As part of the application architecture, the **ORM layer** is **responsible for managing the conversion of software objects to interact with the tables and columns in a relational database**. In **Java**, the **ORM layer converts Java classes and objects so that they can be stored and managed in a relational database**.

### We can use [Spring Initializr](https://start.spring.io/) to help the process of creating the (maven-supported, Spring Boot) project for your web app with all the necessary dependencies

We can run the project using ```./mvnw spring-boot:run```, make sure **Tomcat** is active (Notes on *Lab02*)

## Check [Spring Boot CRUD Application with Thymeleaf](https://www.baeldung.com/spring-boot-crud-thymeleaf) for step-by-step tutorial for Lab03.1

\
.

## **Review questions**

### 1) The “UserController” class gets an instance of “userRepository” through its constructor; how is this new repository instantiated?

The *UserRepository* is initialized because *UserController* has the @Autowired annotation, which injects an instance of *UserRepository* on the *UserController* object.
\
.

### 2) List the methods invoked in the “userRepository” object by the “UserController”. Where are these methods defined?

The methods called are *findAll()*, *save()*, *findById()* and *delete()*. These are defined on the *CrudRepository* class, which our Repository extends.
\
.

### 3) Where is the data being saved?

The data is being saved using the h2database, which we added to the project as a dependency. By default, it is an in-memory database.
\
.

### 4) Where is the rule for the “not empty” email address defined?

The "not empty" rule is defined on the *User* class, with the annotation @NotBlank when we declare the attribute.
\
.

## Lab03.2 - **Multilayer applications: exposing data with REST interface**

## **Review questions**

### A) Explain the differences between the RestController and Controller components used in different parts of this lab

The main difference between Controller component and RestController is in the way the HTTP response body is created.
Using the **@Controller** annotation we needed to define the view but using **@RestController**, the service simply returns the object data as a JSON/XML without having to add **@RequestBody** to every handler.

### B) Create a visualization of the Spring Boot layers (UML diagram or similar), displaying the key abstractions in the solution of 3.3, in particular: entities, repositories, services and REST controllers. Describe the role of the elements modeled in the diagram

Answer in ./diagrama.png
\
.

### C) Explain the annotations @Table, @Colum, @Id found in the Employee entity

### **@Table**

Specifies the primary table for the annotated entity.

If no **Table** annotation is specified for an entity class, the default values apply.

Allows you to specify the details of the table that will be used to persist the entity in the database.

So when we use `@Table(name = "employees")`, we're basically saying that the entity will be saved on the table "employees" within our MySQL database, allowing the data to persist.

### **@Column**

Is used to specify the mapped column for a persistent property or field.

If no **Column** annotation is specified, the default values apply.
 
Allows you to access a specific column from a table, permitting you to access a specified filed instead of having to access all of them.

So when we use `@Column(name = "first_name", nullable = false)`, we're accessing ONLY the column "first_name" from our "employees" table.

### **@Id**

Every entity object that is stored in the database has a primary key.

Once assigned, the primary key cannot be modified. It represents the entity object as long as it exists in the database.
 
Allows you to tag a certain field as being the object's primary key (i.e what identifies it)
So when we use `@Id @GeneratedValue(strategy = GenerationType.AUTO`, we're creating an auto-generated primary key for our Employee
\
.

### D) Explain the use of the annotation @AutoWired (in the Rest Controller class)

This annotation allows Spring to resolve and inject collaborating beans into your bean.

The annotation can be used directly on **properties**, therefore eliminating the need for getters and setters.

The _@Autowired_ annotation can be used on **setter methods** or **constructors**.

**Spring** expects _@Autowired_ dependencies to be available when the dependent bean is being constructed. If the framework cannot resolve a bean for wiring, it will throw the below-quoted exception and prevent the Spring container from launching successfully.

By default, **Spring** resolves _@Autowired_ entries by type. If more than one beans of the same type are available in the container, the framework will throw a fatal exception indicating that more than one bean is available for autowiring.
