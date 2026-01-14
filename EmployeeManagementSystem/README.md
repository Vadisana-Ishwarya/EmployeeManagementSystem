# Employee Management System (Java)

A console-based Java application that manages employee records using
Collections (`ArrayList`, `HashMap`) and File Handling.  
It supports CRUD operations, searching, and persistent storage.

---

## 🚀 Features

- Add, View, Search, and Delete Employees
- Uses `ArrayList` to store employee objects
- Uses `HashMap` for fast lookup by Employee ID
- Saves data to file and loads automatically
- Handles invalid input using Exception Handling
- Stores join date automatically

---

## 📁 Project Structure

EmployeeManagementSystem/
│
├── README.md
│
├── src/
│ ├── Employee.java
│ └── EmployeeManagementSystem.java
│
├── data/
│ └── employees.dat


- `src/` – All Java source files  
- `data/` – Stores employee data file  
- `README.md` – Project documentation  

---

## ⚙️ Setup & Run

1. Open terminal inside `EmployeeManagementSystem` folder  
2. Compile:
   ```bash
   javac src/Employee.java src/EmployeeManagementSystem.java
