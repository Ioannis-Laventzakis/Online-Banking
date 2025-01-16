# **Online Banking System**

## **Overview**
The **Online Banking System** is a comprehensive web application designed to simulate real-world banking functionalities. It allows users to manage their accounts, perform financial transactions, and view transaction histories securely. The application includes both user-facing and administrative functionalities.

## **Project Structure**
```plaintext
Online-Banking/
├── .idea/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── OnlineBanking/
│   │   │   │   ├── config/
│   │   │   │   │   ├── EncoderConfig.java
│   │   │   │   │   ├── SecurityConfig.java
│   │   │   │   ├── controller/
│   │   │   │   │   ├── AccountController.java
│   │   │   │   │   ├── UserController.java
│   │   │   │   ├── dto/
│   │   │   │   │   ├── TransferForm.java
│   │   │   │   ├── exception/
│   │   │   │   │   ├── AccountNotFoundException.java
│   │   │   │   │   ├── InsufficientFundsException.java
│   │   │   │   ├── model/
│   │   │   │   │   ├── Account.java
│   │   │   │   │   ├── User.java
│   │   │   │   ├── repository/
│   │   │   │   │   ├── AccountRepository.java
│   │   │   │   │   ├── UserRepository.java
│   │   │   │   ├── service/
│   │   │   │   │   ├── BankingService.java
│   │   │   │   │   ├── BankingServiceImpl.java
│   │   │   │   │   ├── UserServiceImpl.java
│   │   │   │   ├── unit/
│   │   │   │   │   ├── OnlineBankingSystemApplication.java
│   │   ├── resources/
│   │   │   ├── templates/
│   │   │   │   ├── accountSuccess.html
│   │   │   │   ├── deposit.html
│   │   │   │   ├── home.html
│   │   │   │   ├── login.html
│   │   │   │   ├── new-account.html
│   │   │   │   ├── openAccount.html
│   │   │   │   ├── signup.html
│   │   │   │   ├── transfer.html
│   │   │   │   ├── withdraw.html
│   │   │   ├── application.properties
├── test/
├── target/
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
```

## **Features**

### **Account Management:**
- Open, view, and close accounts.

### **Transactions:**
- Deposit, withdraw, and transfer funds securely.

### **User Authentication:**
- User registration, login, and role-based access control.

### **Admin Dashboard:**
- Manage users and view all accounts.

### **Templates:**
- Responsive HTML templates for all key features.

## **Technologies Used**
- **Backend:** Java, Spring Boot
- **Frontend:** Thymeleaf, Bootstrap 5
- **Database:** PostgreSQL
- **Build Tool:** Maven
- **Security:** Spring Security

## **Getting Started**

### **Prerequisites**
- Java 17+
- PostgreSQL
- Maven

### **Installation**

#### Clone the repository:
```bash
git clone https://github.com/Ioannis-Laventzakis/Online-Banking.git
cd Online-Banking
```
- Install PostgreSQL and create a database named online_banking.
- Update application.properties with your PostgreSQL credentials:
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/online_banking
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
```
- Run the application:
```bash
mvn spring-boot:run
```
- Open a web browser and navigate to http://localhost:8080.
### **Usage**
1. Visit http://localhost:8080 to access the application.
2. Register as a user or log in to an existing account.
3. Perform banking transactions, view account details, and manage user accounts (for admin users).

### Contributing
Contributions are welcome! Please feel free to submit a pull request.

## **License**
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
Email: Glaventzakis@gmail.com
