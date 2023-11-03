# Onion Spring
41026 Advanced Software Development

Onion Spring is an online ordering system for restaurants and customers.

# Team Members
- 14344384 Jamie Ocumen Vallo (ovjamie)
- 14238683 Marc Gabriel (Meenard)
- 24531838 Matthew Alexander (MatthewAlexander2002)
- 14281861 Vincent Tran (Vitrecan)
- 14240384 Sarantis Konstantopedos (Spantle)

# Features
The key features and functionalities of the project and their respective contributors are as follows:

- Jamie: Orders
- Jamie: View all orders (admin)
- Marc: Logout
- Marc: Cart
- Matthew: Payment
- Matthew: Search items
- Vincent: Menu
- Vincent: Product pages
- Sarantis: Create account
- Sarantis: Login

# Repository Structure
```
src
├───main
│   ├───java
│   │   └───com
│   │       └───onionspring
│   │           ├───app
│   │           │   ├───api                # API Endpoints
│   │           │   ├───controller         # Controllers and instructions to render web pages
│   │           │   └───database           # All database related code
│   │           │       ├───repositories   # Repositories define controls to manipulate tables
│   │           │       └───tables         # Tables in the database and their columns/fields
│   │   │       └───utils                  # Various util classes
│   └───resources
│       ├───static                         # Static web files
│       │   ├───css
│       └───templates                      # Dynamic HTML files used by Controllers
└───test
    └───java
        └───com
            └───onionspring
                └───app                    # Tests
```

# How to deploy
1. Install and run [PostgreSQL](https://www.postgresql.org/download/) with the default password of `postgres`.
2. Download the latest artifact from the "Actions" tab on GitHub.
3. Extract the .jar from the .zip file into a folder.
4. Open a terminal and run `java -jar app-0.0.1-SNAPSHOT.jar`
5. Navigate to http://localhost:8080 once it boots.
