                                                      Employee Management System (EMS) Documentation
**1. Project Overview and Objectives**:

The primary goal of this project was to develop a standalone Java application to manage employee records. This project focuses on moving beyond basic variables to using data structures for organization and file persistence for storage.

Objective: To implement a full CRUD (Create, Read, Update, Delete) system.
Learning Focus: Mastering the HashMap for efficient data retrieval and Java's java.io package for permanent data storage.

**2. Setup and Installation Instructions**:

To get this project running on your local machine, follow these steps:

JDK Requirement: Ensure you have JDK 11 or higher installed.

Environment: Open the project in IntelliJ IDEA or any Java-compatible IDE.

Project Structure: Ensure the src folder contains Employee.java, EmployeeManager.java, and Main.java.

Execution: Run the Main.java file.

Storage: On the first run, the system will look for employees.txt in the project root. If not found, it will be created automatically upon adding the first employee.

**3. Code Structure Explanation**:

Class,Role,Technical Highlights
Employee,Data Model,"A Plain Old Java Object (POJO) containing fields: id, name, department, and salary."
EmployeeManager,Business Logic,"Manages the HashMap<Integer, Employee>. Contains methods for adding, deleting, and searching records."
Main,User Interface,"Handles the console menu, user input via Scanner, and calls the appropriate manager methods."

### UML Class Diagram
[![UML Class Diagram](Images/UML Diagram for Employee management system.png)
](https://github.com/adityabliss25/EmployeeManagementSystem/blob/master/docs/Images/UML%20Diagram%20for%20Employee%20management%20system.png)
**4. Data Format Specification**:

The system stores data in a delimited flat-file format to ensure simplicity and readability.

File Name: employees.txt

Structure: Comma-Separated Values (CSV).

Schema: [EmployeeID],[Name],[Department],[Salary]

Example: 101,John Doe,Software,85000.0


**5. File Handling Procedures**:

This project implements Persistence through the following procedures:

Initialization (Read): When the application starts, it triggers a loadFromFile() method. It reads employees.txt line-by-line using a BufferedReader or Scanner, splits the string by commas, and populates the HashMap.

State Sync (Write): To ensure data is never lost, the system performs a "Full Write" whenever the data is modified. It iterates through the HashMap and writes the entire current state to employees.txt using a BufferedWriter or PrintWriter.

**6. Employee Management Workflows**:

The application follows a predictable workflow to ensure data integrity:

Search Workflow: User enters an ID → System checks if the ID exists as a "Key" in the HashMap → If found, the Employee object is displayed; if not, an error message is shown.

Addition Workflow: User enters details → System checks if ID is unique → Employee object is added to the Map → The updated Map is saved to the text file.

Deletion Workflow: User enters ID → System removes the entry from the Map → File is updated to reflect the removal.

**7. Explanation of Technical Requirements**:

HashMap Performance: By using an ID as the key, the system achieves O(1) time complexity for lookups, making it extremely fast regardless of how many employees are added.

Collections Framework: This project demonstrates the transition from simple Arrays to the more flexible Collections framework.

Error Handling: The system includes try-catch blocks to handle IOException during file operations, preventing the program from crashing if the file is missing or corrupted.

**7. Console Execution**:

### Console Output
![Application Screenshot](/Images/Employee Management Output Console.png)
