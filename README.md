# Spring Boot CRUD Application with Category and Product Management

## Overview
This project is a Spring Boot application designed to manage Categories and Products with CRUD operations. It demonstrates the use of REST APIs, JPA, Hibernate, and annotation-based configurations. The application includes a one-to-many relationship between Categories and Products and implements server-side pagination.

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
   - **Description:** Fetch paginated list of all categories.

2. **Create a new category**
   - **Endpoint:** `POST http://localhost:8080/api/categories`
   - **Description:** Create a new category.
   - **Request Body Example:**
     ```json
     {
         "name": "Electronics",
         "description": "Category for electronic products"
     }
     ```

3. **GET category by ID**
   - **Endpoint:** `GET http://localhost:8080/api/categories/{id}`
   - **Description:** Fetch details of a category by its ID.

4. **Update category by ID**
   - **Endpoint:** `PUT http://localhost:8080/api/categories/{id}`
   - **Description:** Update details of a specific category.
   - **Request Body Example:**
     ```json
     {
         "name": "Home Appliances",
         "description": "Updated category description"
     }
     ```

5. **Delete category by ID**
   - **Endpoint:** `DELETE http://localhost:8080/api/categories/{id}`
   - **Description:** Delete a category by its ID.

---

### Product CRUD Operations
1. **GET all products**
   - **Endpoint:** `GET http://localhost:8080/api/products?page={pageNumber}`
   - **Description:** Fetch paginated list of all products.

2. **Create a new product**
   - **Endpoint:** `POST http://localhost:8080/api/products`
   - **Description:** Create a new product.
   - **Request Body Example:**
     ```json
     {
         "name": "Smartphone",
         "price": 699.99,
         "quantity": 50,
         "categoryId": 1
     }
     ```

3. **GET product by ID**
   - **Endpoint:** `GET http://localhost:8080/api/products/{id}`
   - **Description:** Fetch details of a product by its ID. The response will include its associated category details.

4. **Update product by ID**
   - **Endpoint:** `PUT http://localhost:8080/api/products/{id}`
   - **Description:** Update details of a specific product.
   - **Request Body Example:**
     ```json
     {
         "name": "Laptop",
         "price": 999.99,
         "quantity": 20,
         "categoryId": 2
     }
     ```

5. **Delete product by ID**
   - **Endpoint:** `DELETE http://localhost:8080/api/products/{id}`
   - **Description:** Delete a product by its ID.

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
                "pid": 101,
                "pname": "Smartphone",
                "price": 699.99,
                "quantity": 50
            },
            {
                "pid": 102,
                "pname": "Laptop",
                "price": 999.99,
                "quantity": 20
            }
        ]
    }
    ```

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
   ```
3. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```
4. Access the APIs using tools like Postman or Curl.

---

## Directory Structure
- **`src/main/java`**: Contains the main application files and packages.
  - **Controller**: Handles API requests.
  - **Service**: Contains business logic.
  - **Repository**: Interfaces for database operations.
  - **Entity**: Defines the Category and Product models.
- **`src/main/resources`**: Contains configuration files like `application.properties`.

---

## Tools & Technologies
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL/PostgreSQL
- Maven
- REST API

---


