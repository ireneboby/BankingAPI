# BankingAPI

A simple RESTful API built with Spring Boot to simulate basic banking operations like account creation and fund transfers.

## Features

- Create user accounts with an initial balance
- Transfer funds between accounts
- Retrieve transaction history
- Clean 3-layer architecture: Controller → Service → Repository

## Assumptions

- Account IDs are generated automatically using an in-memory counter
- Account Balances are handled using `BigDecimal` for currency precision
- No memory persistence yet — this is a prototype, not production-ready
- All data is lost on app restart (in-memory only)
- No authentication or authorization is implemented
- Negative balances are not allowed
- Transaction history is not filtered (returns full history)
- Swagger is used as the only form of documentation
- Only basic validation is performed (e.g. null checks, amount > 0)
- Account names are not validated for uniqueness or formatting
- Currency is not supported (i.e. all amounts are assumed to be in a single currency like USD)

## Tech Stack

- Java 21
- Spring Boot 3.4.4
- Spring Web

## User Guide

### Prerequisites

- Java 21 installed

### Clone the repo

`git clone https://github.com/ireneboby/BankingAPI.git`

### Navigate to the project directory

`cd BankingAPI`

### Run the app

`./gradlew bootRun`
The app will start on `http://localhost:8080`

### Use Swagger to test API endpoints
Open in browser: `http://localhost:8080/swagger-ui.html`
