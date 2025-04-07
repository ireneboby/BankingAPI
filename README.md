# BankingAPI

A simple RESTful API built with Spring Boot to simulate basic banking operations like account creation and fund transfers.

## Features

- Create user accounts with an initial balance
- Transfer funds between accounts
- Retrieve transaction history
- View all accounts
- Clean 3-layer architecture: Controller → Service → Repository

## Tech Stack

- Java 21
- Spring Boot 3.4.4
- Spring Web

## User Guide

### Prerequisites

Java 21 installed

### Clone the repo

`git clone https://github.com/ireneboby/BankingAPI.git`

### Navigate to the project directory

`cd BankingAPI`

### Run the app

`./gradlew bootRun`  
The app will start on `http://localhost:8080`

### Use Swagger to test API endpoints
Open in browser: `http://localhost:8080/swagger-ui.html`

## API Endpoints

All endpoints return:
- 201 Created or 200 OK on success
- 400 Bad Request with an error message for invalid input (e.g. null fields, negative balance, insufficient funds)

### Accounts

#### Create a new account  
`POST /api/accounts`   
Request Body: ```json { "firstName": "Luna", "lastName": "Lovegood", "initialBalance": 1000.00 }```

#### List All Accounts
`GET /api/accounts`  
Returns a list of all account summaries.

### Transactions

#### Transfer Funds
`POST /api/transactions/transfer`  
Transfers funds between accounts.  
Request Body: ```json {"senderId": 1, "receiverId": 2, "transferAmount": 250.00}```

### Transaction History
`GET /api/transactions/account/{accountId}`   
Returns a list of transactions where the account was a sender or receiver.

## Assumptions

- Account IDs are generated automatically using an in-memory counter
- Account Balances are handled using `BigDecimal` for currency precision
- No memory persistence yet — data is lost on app restart (in-memory only)
- No authentication or authorization is implemented
- Negative balances are not allowed
- Transaction history is not filtered (returns full history)
- Swagger is used as the only form of documentation
- Only basic validation is performed (e.g. null checks, amount > 0)
- Account names are not validated for uniqueness or formatting
- Currency is not supported (i.e. all amounts are assumed to be in a single currency like USD)