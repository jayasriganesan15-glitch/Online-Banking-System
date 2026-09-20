# Online-Banking-System
PROBLEM STATEMENT

• Traditional banking requires customers to visit the bank for basic services.

Manual transactions are time-consuming and may cause errors.

• Direct database access makes applications difficult to maintain.

A secure and organized online banking system is required.

The system should provide fast and reliable banking operations.
TECHNOLOGIES USED

• Java - Application development

• JDBC - Connects Java application with MySQL

• MySQL - Stores customer, account and transaction data

• Eclipse - Java development environment
FEATURES

Customer registration and login

Account management

Check account balance

Deposit money

Withdraw money

Transfer money between accounts

View transaction history

Secure database operations using JDBC
LAYERED ARCHITECTURE

PRESENTATION LAYER

SERVICE / BUSINESS LOGIC LAYER SERVICE DAO(DAΤΑ DAO (DATA ACCESS OBJECT) LAYER JDBC/ DATABASE CONNECTION LAYER

MYSQL DATABASE

Presentation → User interaction Service → Banking rules and operations DAO→ Database operations JDBC→ Java-MySQL connection
FUTURE ENHANCEMENTS

• OTP-based authentication

Two-factor authentication (2FA)

• Mobile banking application

• Email/SMS transaction notifications

• Online bill payment

UPI/payment integration

Improved encryption and password security

Admin dashboard and reports
CONCLUSION

The Online Banking System provides essential banking services digitally.

Layered architecture makes the application organized, modular and maintainable.

• JDBC provides communication between Java and MySQL. • DAO separates database operations from business logic.

The system can be expanded with advanced security and digital payment features.


