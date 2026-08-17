# Contact Management System

A web-based Contact Management System developed using **Spring Boot, Spring Security, Thymeleaf, and MySQL**. The application allows users to securely create and manage their contacts from a simple web interface.

The main focus of this project was to understand how authentication, authorization, database operations, and server-side rendering work together in a Spring Boot application.

## Features

* User registration and login
* Secure authentication using Spring Security
* OAuth2 login
* Role-based access control
* Add new contacts
* View contact details
* Update contact information
* Delete contacts
* Contact search
* Form validation
* MySQL database integration
* Thymeleaf-based web pages
* User logout

## Technologies Used

**Backend**

* Java
* Spring Boot
* Spring MVC
* Spring Security
* Spring Data JPA
* Hibernate
* Maven

**Frontend**

* HTML
* CSS
* Thymeleaf
* JavaScript
* Bootstrap

**Database**

* MySQL

**Authentication**

* Spring Security
* OAuth2

**Tools**

* IntelliJ IDEA
* Git
* GitHub
* MySQL Workbench
## Business Problem

Managing personal or customer contact information manually can become difficult when the number of contacts increases. Storing contact details in notebooks, spreadsheets, or different places can make it difficult to find, update, and maintain accurate information.

This project addresses these problems by providing a **centralized contact management system** where users can securely store and manage their contacts from one application.

### Problems Addressed

* **Scattered contact information:** Contact details can be stored in one centralized system instead of keeping them in multiple places.
* **Difficult contact management:** Users can easily add, view, update, and delete contact information from the application.
* **Time-consuming search:** Users can search for contacts instead of manually going through a large list.
* **Data security:** Authentication and authorization help ensure that only authorized users can access protected parts of the application.
* **Unauthorized access:** Spring Security and role-based access control restrict access to protected pages and features.
* **Manual data maintenance:** CRUD operations make it easier to keep contact information up to date.
* **Multiple login methods:** OAuth2 login provides an additional and convenient authentication option.

### Solution

The application provides a secure web-based platform where users can:

```text
User
  ↓
Secure Login / OAuth2 Login
  ↓
Contact Dashboard
  ↓
Search Contacts
  ↓
Add / View / Update / Delete
  ↓
MySQL Database
```

All contact information is stored in a MySQL database and managed through **Spring Data JPA and Hibernate**.

### Business Value

The system helps reduce the effort required to manage contact information by providing a single, secure place to store and maintain contacts. It also improves accessibility, makes searching and updating information easier, and adds security through authentication and role-based authorization.

In short, the project solves the problem of **manually managing and securing contact information by providing a centralized, authenticated, and easy-to-use contact management system**.


## How It Works

After logging in, a user can access the contact management section and perform different operations on their contacts.

```text
Login
  ↓
Authentication
  ↓
Dashboard
  ↓
Contact List
  ↓
Add / View / Edit / Delete
  ↓
MySQL Database
```

Spring Security handles authentication and protects the application pages. Based on the user's role, access to specific features can be controlled.

## Contact Management

The application supports the basic CRUD operations:

| Operation | Description              |
| --------- | ------------------------ |
| Create    | Add a new contact        |
| Read      | View saved contacts      |
| Update    | Edit contact information |
| Delete    | Remove a contact         |

A contact can contain information such as:

* Name
* Email
* Phone number
* Address
* Description

## Security

Security was an important part of the project. I used **Spring Security** to handle login and protect application routes.

The project also includes:

* Password encryption
* Authentication
* Authorization
* Role-based access
* OAuth2 login
* Logout
* Protected pages

## Project Structure

```text
src
└── main
    ├── java
    │   └── ...
    │       ├── controller
    │       ├── service
    │       ├── repository
    │       ├── entity
    │       └── config
    │
    └── resources
        ├── templates
        ├── static
        └── application.properties
```

## Database

MySQL is used to store user and contact information.

The application uses **Spring Data JPA and Hibernate** to communicate with the database.

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/contact_management
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

Use your own database credentials when running the project locally.

## Running the Project

### Requirements

* Java
* Maven
* MySQL
* Git

### Clone the repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

### Open the project

```bash
cd contact-management-system
```

### Create the database

```sql
CREATE DATABASE contact_management;
```

Update the database details in:

```text
src/main/resources/application.properties
```

### Run the application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the main Spring Boot application from your IDE.

Then open:

```text
http://localhost:8080
```

## Screenshots

### Login Page

Add your login page screenshot here.

```markdown
![Login Page](screenshots/login.png)
```

### Dashboard

```markdown
![Dashboard](screenshots/dashboard.png)
```

### Contact List

```markdown
![Contact List](screenshots/contact-list.png)
```

### Add Contact

```markdown
![Add Contact](screenshots/add-contact.png)
```

## What I Learned

While working on this project, I worked with:

* Spring Boot application structure
* MVC architecture
* Spring Security
* OAuth2 authentication
* Role-based authorization
* Spring Data JPA
* Hibernate
* MySQL
* Thymeleaf
* CRUD operations
* Form validation
* Git and GitHub

## Future Improvements

Some features I would like to add in the future:

* Contact import/export
* Profile image support
* Better search and filtering
* Email reminders
* Pagination for large contact lists
* Docker support
* Cloud deployment

## Author

**Ankita Kumari**

MCA | Java | Spring Boot | Full Stack Development

---

If you found this project useful, feel free to explore the repository.
