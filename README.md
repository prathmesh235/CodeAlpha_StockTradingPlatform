# CodeAlpha Stock Trading Platform

A console-based **Stock Trading Platform** developed in Java as part of the **CodeAlpha Java Programming Internship — Task 2**.

The project simulates a basic stock market environment where users can view market data, buy and sell stocks, manage their portfolio, view transaction history, and save portfolio information to a file.

According to the CodeAlpha task instructions, Task 2 requires market data display, buy/sell operations, portfolio tracking, OOP for stocks/users/transactions, and optionally File I/O or a database. This project implements all of these core requirements.

---

## 📌 Project Information

**Project Name:** Stock Trading Platform
**Internship:** CodeAlpha Java Programming Internship
**Task:** Task 2 — Stock Trading Platform
**Language:** Java
**Application Type:** Console-Based Application
**Developer:** Prathmesh

---

## 🚀 Features

### 📈 Market Data

* Display available stocks
* Display company names
* Display current stock prices
* Simulate market price changes

### 💰 Stock Trading

* Buy stocks
* Sell stocks
* Check available balance
* Validate stock symbols
* Validate stock quantities
* Prevent purchases when balance is insufficient
* Prevent selling more shares than owned

### 📊 Portfolio Management

* View owned stocks
* View quantity of each stock
* Calculate current portfolio value
* Track portfolio after buying and selling

### 🧾 Transaction History

* Record BUY transactions
* Record SELL transactions
* Store stock symbol
* Store quantity
* Store transaction price
* Store total transaction amount
* Store transaction date and time

### 👤 User Account

* Create a trading account
* Set initial cash balance
* View username
* View current cash balance

### 💾 File Handling

* Save account information
* Save cash balance
* Save portfolio holdings
* Save transaction history
* Store data in `portfolio_data.txt`

---

## 🛠️ Technologies Used

* Java
* Object-Oriented Programming
* Java Collections Framework
* `HashMap`
* `ArrayList`
* File I/O
* Exception Handling
* Java Date and Time API
* Console Input/Output

---

## 🧱 OOP Concepts Used

### 1. Encapsulation

Private variables are used inside classes with public getter and setter methods.

Example:

```java
private String symbol;
private double price;
```

---

### 2. Classes and Objects

The project uses separate classes for different responsibilities:

* `Stock`
* `User`
* `Portfolio`
* `Transaction`
* `FileManager`
* `Main`

---

### 3. Composition

A `User` object contains:

* A `Portfolio`
* A list of `Transaction` objects

---

### 4. Collections

`HashMap` is used for:

* Market stocks
* Portfolio holdings

`ArrayList` is used for:

* Transaction history

---

## 📂 Project Structure

```text
CodeAlpha_StockTradingPlatform/
│
├── Code/
│   ├── FileManager.java
│   ├── Main.java
│   ├── Portfolio.java
│   ├── Stock.java
│   ├── Transaction.java
│   └── User.java
│
├── README.md
│
└── portfolio_data.txt
```

> `portfolio_data.txt` is generated automatically after selecting the **Save Portfolio Data** option.

---

## 📄 Java Classes

### `Main.java`

The main entry point of the application.

Responsibilities:

* Start the application
* Create the market
* Create users
* Display the menu
* Handle user input
* Handle buy/sell operations
* Update stock prices

---

### `Stock.java`

Represents a stock in the market.

Stores:

* Stock symbol
* Company name
* Stock price

---

### `User.java`

Represents a trading platform user.

Stores:

* Username
* Cash balance
* Portfolio
* Transaction history

Provides:

* Buy stock
* Sell stock
* Display account information
* Display transaction history

---

### `Portfolio.java`

Manages the user's stock holdings.

Provides:

* Add stocks
* Remove stocks
* Check owned quantity
* Calculate portfolio value
* Display portfolio

---

### `Transaction.java`

Represents a stock transaction.

Stores:

* Transaction type
* Stock symbol
* Quantity
* Price
* Total amount
* Date and time

---

### `FileManager.java`

Handles file storage.

The application saves portfolio information to:

```text
portfolio_data.txt
```

---

# 📋 Available Stocks

The application contains sample stocks such as:

| Symbol | Company                   |
| ------ | ------------------------- |
| TCS    | Tata Consultancy Services |
| INFY   | Infosys                   |
| RELI   | Reliance Industries       |
| HDFC   | HDFC Bank                 |
| ICICI  | ICICI Bank                |
| WIPRO  | Wipro                     |
| ITC    | ITC Limited               |
| SBIN   | State Bank of India       |

The prices are **sample/simulated values** and are not real-time stock-market prices.

---

# 🎮 Application Menu

After starting the application, the following menu is displayed:

```text
================ MAIN MENU ================

1. View Market
2. Buy Stock
3. Sell Stock
4. View Portfolio
5. Transaction History
6. Account Details
7. Update Market Prices
8. Save Portfolio Data
9. Exit

============================================
```

---

# ▶️ How to Run

## Step 1 — Open the project

Open the project in:

* VS Code
* IntelliJ IDEA
* Eclipse
* Any Java-supported IDE

---

## Step 2 — Open the Code folder

Open the terminal in the folder containing:

```text
Main.java
Stock.java
User.java
Transaction.java
Portfolio.java
FileManager.java
```

---

## Step 3 — Compile the program

In PowerShell:

```powershell
javac *.java
```

If PowerShell does not accept the wildcard, use:

```powershell
javac (Get-ChildItem *.java).FullName
```

---

## Step 4 — Run the program

```powershell
java Main
```

---

# 🧪 Sample Usage

## Create Account

```text
Create Trading Account
----------------------
Enter your username: Prathmesh
Enter initial balance: ₹100000
```

---

## View Market

Choose:

```text
1
```

The application displays the available stocks and their prices.

---

## Buy Stock

Choose:

```text
2
```

Example:

```text
Enter stock symbol to buy: TCS
Enter quantity: 5
Confirm purchase? (Y/N): Y
```

The application deducts the purchase amount from the user's cash balance and adds the shares to the portfolio.

---

## Buy Another Stock

Example:

```text
Enter stock symbol to buy: INFY
Enter quantity: 10
Confirm purchase? (Y/N): Y
```

---

## View Portfolio

Choose:

```text
4
```

The application displays:

```text
Symbol     Company              Quantity   Current Value
TCS        Tata Consultancy...  5          ₹19000.00
INFY       Infosys              10         ₹17500.00

Total Portfolio Value: ₹36500.00
```

Values may change after updating market prices.

---

## View Transactions

Choose:

```text
5
```

Example:

```text
BUY    TCS     Qty: 5
BUY    INFY    Qty: 10
```

---

## Sell Stock

Choose:

```text
3
```

Example:

```text
Enter stock symbol to sell: TCS
Enter quantity to sell: 2
Confirm sale? (Y/N): Y
```

The application adds the selling amount back to the user's cash balance.

---

## Update Market Prices

Choose:

```text
7
```

The application simulates market movement by changing stock prices.

```text
Updating market prices...
Market prices updated successfully.
```

---

## Save Portfolio Data

Choose:

```text
8
```

The application creates:

```text
portfolio_data.txt
```

and saves:

* Username
* Balance
* Portfolio holdings
* Transaction history

---

# ⚠️ Validation

The application handles several invalid situations.

### Invalid Stock

```text
Enter stock symbol to buy: ABC

Stock not found.
```

### Insufficient Balance

```text
Insufficient balance.
```

### Selling More Shares Than Owned

```text
You don't own enough shares.
```

### Invalid Quantity

```text
Enter a value greater than 0.
```

### Invalid Number

```text
Please enter a valid number.
```

---

# 💾 Data Storage

The project uses Java File I/O to save data.

Generated file:

```text
portfolio_data.txt
```

Example:

```text
==========================================
       STOCK TRADING PLATFORM DATA
==========================================

Username: Prathmesh
Balance: 63500.00

PORTFOLIO:

TCS : 3 shares
INFY : 10 shares

TRANSACTIONS:

BUY TCS ...
BUY INFY ...
SELL TCS ...
```

---

# 🔐 Important Note

This project is an **educational stock-trading simulation**.

It does not connect to a real stock exchange, brokerage account, or live market-data API.

The stock prices are sample values, and market-price changes are simulated.

---

# 🎬 Suggested Demonstration

For the project explanation demonstrate:

```text
1. Introduction
2. Project objective
3. Project structure
4. Java classes
5. OOP concepts
6. View market
7. Buy stock
8. View portfolio
9. Sell stock
10. Transaction history
11. Update market prices
12. Save data using File I/O
13. GitHub repository
```

---

# 🎯 CodeAlpha Task Requirements Covered

| Requirement                      | Implementation |
| -------------------------------- | -------------- |
| Market data display              | ✅              |
| Buy operations                   | ✅              |
| Sell operations                  | ✅              |
| Portfolio tracking               | ✅              |
| Stock management using OOP       | ✅              |
| User management using OOP        | ✅              |
| Transaction management using OOP | ✅              |
| File I/O                         | ✅              |
| Console interface                | ✅              |
| Input validation                 | ✅              |
| Transaction history              | ✅              |
| Portfolio value calculation      | ✅              |
| Simulated price updates          | ✅              |

The CodeAlpha PDF specifically lists market display, buy/sell operations, portfolio tracking, OOP, and optional File I/O/database as the core Task 2 requirements.

---

# 👨‍💻 Author

**Prathmesh**

Java Programming Internship
CodeAlpha

