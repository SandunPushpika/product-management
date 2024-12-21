# Product Managemnet Backend Task for Rooster Property Group Inc.

## Introduction

This is a simple Spring Boot application that uses H2 as an in-memory database. The project demonstrates basic validation and global exception handling with an endpoint to insert a record.

## Technology Stack

- **Spring Boot**: Version 3.4.1
- **H2 Database**: In-memory relational database used for data storage.
- **Maven**: Build automation tool.
- **Java**: Programming language.

## Setup Instructions

### Prerequisites

- Java 17 or higher
- Maven
- IDE (e.g., IntelliJ IDEA, Eclipse, VS Code)

### Steps

1. Clone the repository:
    ```bash
    git clone https://github.com/SandunPushpika/product-management.git
    cd productmanagement
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

4. The application will start and be accessible at [http://localhost:8080](http://localhost:8080).

## Running the Application

Once the application is up and running, you can interact with it using the following API endpoint:

- **POST** `/api/products` – Add a new product to the database.

### Example cURL Commands

- To add a new product:
    ```bash
    curl --location 'http://localhost:8080/api/products' \
  --header 'Content-Type: application/json' \
  --data '{
      "name":"book",
      "price": 55.98
  }'
    ```

  **Request Body**
    ```json
    {
      "name":"string",
      "price": 1.0
    }
    ```
  **Sample Success Response**
  ```json
    {
        "message": "Product added!",
        "httpStatus": 201,
        "data": {
            "id": 1,
            "name": "book",
            "price": 55.98,
            "createdAt": "2024-12-21T15:00:44.276929821"
        }
    }
    ```
  **Sample Error Response**
  ```json
    {
        "message": "Name cannot be empty!",
        "httpStatus": 400,
        "data": null
    }
    ```

## Thank you
