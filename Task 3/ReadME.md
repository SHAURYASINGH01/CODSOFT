# Student Management System

 A Java-based application for managing student records with a console interface, developed as part of CodeSoft Internship program.
 
## About The Project

This Student Management System allows educational institutions to efficiently manage student records. It provides functionality to:

```
Add new students with detailed information

Remove students from the system

Search for specific students

Display all student records

Edit existing student information

Save and load student data from files
```

## Features 
- Student Class: Represents individual students with attributes like name, roll number, grade, age, and contact information

- Data Management: Full CRUD (Create, Read, Update, Delete) operations for student records

- Data Persistence: Save and load student data from text files

- Input Validation: Comprehensive validation for all input fields

- User-Friendly Interface: Clean console-based menu system.

## Class Structure
Student Class

1. Attributes: rollNumber, name, grade, age, email, phone

2. Methods: Getters, setters, and toString() for displaying student information.


## Student-Management-Class:

- Manages an ArrayList of Student objects

  - ## Methods ##

  <ul>
    
       addStudent(): Adds a new student with validation

       removeStudent(): Removes a student by roll number

       searchStudent(): Finds students by various criteria

       displayAllStudents(): Shows all student records

       editStudent(): Modifies existing student information

       saveToFile(): Writes student data to a file

       loadFromFile(): Reads student data from a file.
</ul>

## How To Run

```
Compile the program:
javac StudentManagementSystem.java
```

```
Run the program:
java StudentManagementSystem
```

## Follow the menu options 

```
    Add Student

    Remove Student

    Search Student

    Display All Students

    Edit Student

    Save to File

    Load from File

    Exit.
```


## Sample Usage

Welcome to Student Management System!
```
--- MENU ---
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Edit Student
6. Save to File
7. Load from File
8. Exit.

```

# Requirements
- Java Development Kit (JDK) 8 or higher

- Any Java IDE or command line interface

# File Structure
```
StudentManagementSystem/
├── Student.java              # Student class definition
├── StudentManagementSystem.java  # Main application class
└── students.txt              # Data file (created after first save)
```

## Methodology Used

Input/Output: Scanner class, File I/O

Data Structures: ArrayList for storing student objects

Control Flow: if-else, switch, while loops.

Validation: Regular expressions for email validation


