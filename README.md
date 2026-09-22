\# Spring Boot Product CRUD REST API



A backend REST API built using \*\*Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL\*\* for managing products through CRUD operations.



\## 🚀 Features



\- Create a new product

\- Get all products

\- Get a product by ID

\- Update a product

\- Delete a product

\- DTO-based request and response handling

\- Input validation using Jakarta Validation

\- Custom `ProductNotFoundException`

\- Global exception handling

\- MySQL database integration

\- JPA/Hibernate for database operations

\- Layered architecture using Controller, Service, Repository, and DTOs



\## 🛠️ Technologies Used



| Technology | Purpose |

|---|---|

| Java | Programming language |

| Spring Boot | Backend framework |

| Spring Web | REST API development |

| Spring Data JPA | Database access |

| Hibernate | ORM |

| MySQL | Relational database |

| Maven | Dependency management |

| Jakarta Validation | Request validation |

| Git \& GitHub | Version control |



\## 📁 Project Structure



```text

ProductCrud

│

├── src

│   ├── main

│   │   ├── java

│   │   │   └── com.itvedant.basics

│   │   │       ├── controllers

│   │   │       │   └── ProductController.java

│   │   │       │

│   │   │       ├── dto

│   │   │       │   ├── ProductRequestDTO.java

│   │   │       │   └── ProductResponseDTO.java

│   │   │       │

│   │   │       ├── exceptions

│   │   │       │   ├── ProductNotFoundException.java

│   │   │       │   └── GlobalExceptionHandler.java

│   │   │       │

│   │   │       ├── models

│   │   │       │   └── Product.java

│   │   │       │

│   │   │       ├── repository

│   │   │       │   └── ProductRepository.java

│   │   │       │

│   │   │       └── services

│   │   │           └── ProductService.java

│   │   │

│   │   └── resources

│   │       └── application.properties

│   │

│   └── test

│

├── .gitignore

├── pom.xml

├── mvnw

└── mvnw.cmd

```



\## 🔄 Application Architecture



```text

Client

&#x20; ↓

ProductController

&#x20; ↓

ProductService

&#x20; ↓

ProductRepository

&#x20; ↓

Hibernate / JPA

&#x20; ↓

MySQL Database

```



\### Controller



Handles HTTP requests and exposes REST API endpoints.



\### Service



Contains the business logic and converts entities into DTOs.



\### Repository



Uses Spring Data JPA to communicate with the database.



\### Entity



`Product` represents the product table in the MySQL database.



\### DTO



DTOs are used to control the data received from and returned to the client.



\### Exception Handling



Custom exceptions and a global exception handler provide meaningful error responses.



\## 📌 API Endpoints



\### 1. Create Product



```http

POST /products

```



Example request:



```json

{

&#x20; "name": "Laptop",

&#x20; "category": "Electronics",

&#x20; "price": 55000

}

```



\### 2. Get All Products



```http

GET /products

```



\### 3. Get Product By ID



```http

GET /products/{id}

```



Example:



```http

GET /products/1

```



\### 4. Update Product



```http

PUT /products/{id}

```



Example request:



```json

{

&#x20; "name": "Gaming Laptop",

&#x20; "category": "Electronics",

&#x20; "price": 75000

}

```



\### 5. Delete Product



```http

DELETE /products/{id}

```



Example:



```http

DELETE /products/1

```



\## ✅ Validation



The API validates incoming product data.



For example:



\- Product name cannot be empty

\- Category cannot be empty

\- Price is required

\- Price must be greater than 0



Example validation request:



```json

{

&#x20; "name": "",

&#x20; "category": "",

&#x20; "price": 0

}

```



The API returns an HTTP `400 Bad Request` when validation fails.



\## ⚠️ Exception Handling



The project uses a custom:



```text

ProductNotFoundException

```



and:



```text

GlobalExceptionHandler

```



If a product does not exist, the API returns an appropriate `404 Not Found` response.



\## 🗄️ Database Configuration



This project uses MySQL.



Create a database:



```sql

CREATE DATABASE productdb;

```



Configure the database connection in:



```text

src/main/resources/application.properties

```



Example:



```properties

spring.datasource.url=jdbc:mysql://localhost:3306/productdb

spring.datasource.username=root

spring.datasource.password=YOUR\_PASSWORD



spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

```



> Replace `YOUR\_PASSWORD` with your local MySQL password. Do not commit real database credentials to GitHub.



\## ▶️ How to Run



\### 1. Clone the repository



```bash

git clone https://github.com/peeyush19/springboot-product-crud.git

```



\### 2. Open the project



Open the project in an IDE such as:



\- IntelliJ IDEA

\- Eclipse

\- Spring Tool Suite



\### 3. Configure MySQL



Create the database and update the database credentials in `application.properties`.



\### 4. Run the application



Using Maven:



```bash

mvn spring-boot:run

```



Or on Windows:



```bash

mvnw.cmd spring-boot:run

```



The application will start on:



```text

http://localhost:8080

```



\## 🧪 Testing the API



You can test the REST APIs using:



\- Postman

\- Swagger UI

\- Browser for GET requests

\- Any REST API client



\## 📚 Concepts Practiced



This project helped me practice:



\- Java

\- Spring Boot

\- REST APIs

\- CRUD operations

\- HTTP methods

\- Spring Data JPA

\- Hibernate

\- MySQL

\- Entity mapping

\- DTOs

\- Constructor Injection

\- Jakarta Validation

\- Exception Handling

\- Layered Architecture

\- Maven

\- Git and GitHub



\## 👨‍💻 Author



\*\*Piyush Thakur\*\*



GitHub:  

https://github.com/peeyush19



\## 📄 License



This project is created for learning and portfolio purposes.

