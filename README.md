# Spring Boot CRUD Application with Category and Product Management

## Overview
This project is a Spring Boot application designed to manage Categories and Products with CRUD operations. It demonstrates the use of REST APIs, JPA, Hibernate, and annotation-based configurations. The application includes a one-to-many relationship between Categories and Products and implements server-side pagination.

---

## Relationship
- **Category-Product Relationship:**
  - A category can have multiple products (One-to-Many).
  - Example:
    ```json
    {
        "cid": 1,
        "cname": "Electronics",
        "products": [
            {
                "pid": 1,
                "pname": "TV",
                "price": 1233.0,
                "quantity": 122
            },
            {
                "pid": 2,
                "pname": "Laptop",
                "price": 1500.0,
                "quantity": 50
            }
        ]
    }
    ```

---

## Requirements
- **Spring Boot**
- **REST Controller**
- **RDB Configuration** (e.g., MySQL, PostgreSQL)
- **Annotation-based configuration** (No XML)
- **JPA & Hibernate**

---

## Features

### Category CRUD Operations
1. **GET all categories**
   - **Endpoint:** `GET http://localhost:8080/api/categories?page={pageNumber}`

2. **Create a new category**
   - **Endpoint:** `POST http://localhost:8080/api/categories`
   - **Request Body Example:**
     ```json
     {
         "name": "Electronics",
         "description": "Category for electronic products"
     }
     ```

3. **GET category by ID**
   - **Endpoint:** `GET http://localhost:8080/api/categories/{cid}`

4. **Update category by ID**
   - **Endpoint:** `PUT http://localhost:8080/api/categories/{cid}`
   - **Request Body Example:**
     ```json
     {
         "name": "Home Appliances",
         "description": "Updated category description"
     }
     ```

5. **Delete category by ID**
   - **Endpoint:** `DELETE http://localhost:8080/api/categories/{cid}`

---

### Product CRUD Operations
1. **GET all products**
   - **Endpoint:** `GET http://localhost:8080/api/products?page={pageNumber}`

2. **Create a new product**
   - **Endpoint:** `POST http://localhost:8080/api/products`
   - **Request Body Example:**
     ```json
     {
         "name": "Smartphone",
         "price": 699.99,
         "quantity": 50,
         "cid": 1
     }
     ```

3. **GET product by ID**
   - **Endpoint:** `GET http://localhost:8080/api/products/{pid}`

4. **Update product by ID**
   - **Endpoint:** `PUT http://localhost:8080/api/products/{pid}`
   - **Request Body Example:**
     ```json
     {
         "name": "Laptop",
         "price": 999.99,
         "quantity": 20,
         "cid": 2
     }
     ```

5. **Delete product by ID**
   - **Endpoint:** `DELETE http://localhost:8080/api/products/{pid}`

---

## Pagination
- **Server-side pagination** is implemented for both categories and products to efficiently handle large datasets.

---

## How to Run
1. Clone the repository from GitHub/GitLab.
2. Configure the database in the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
