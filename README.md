# BankingAPI

A simple RESTful API built with Spring Boot to simulate basic banking operations like account creation and (coming soon) fund transfers.

## Features

- Create user accounts with an initial balance
- (To do) Transfer funds between accounts
- (To do) Retrieve transaction history
- Clean 3-layer architecture: Controller → Service → Repository

## Assumptions

- Account IDs are generated automatically (in-memory counter)
- Balances are handled using BigDecimal for precision
- No memory peristence yet - this is a prototype, not production-ready

## Tech Stack

- Java 21
- Spring Boot 3.4.4
- Spring Web

## User Guide

### Prerequisites

- Java 21 installed

### Clone the repo and cd into the project directory

`git clone https://github.com/ireneboby/BankingAPI.git`
`cd BankingAPI`

### Run the app

`./gradlew bootRun`
The app will start on `http://localhost:8080`

### Use Swagger to test API endpoints
`http://localhost:8080/swagger-ui.html`

### Playground 
curl -X POST http://localhost:8080/api/accounts \
-H "Content-Type: application/json" \
-d '{
  "firstName": "Ava",
  "lastName": "Lovegood",
  "initialBalance": 1000.00
}'