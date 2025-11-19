# Library-Management-System
A simple console-based Library Management System built using Core Java and Object-Oriented Programming.
This project allows users to manage books, issue and return them, and maintain basic user details.
## Features
# Book Management
Display list of all books

Check book availability

Issue book to a user

Return issued book

## User Management

Preloaded user data

Validates user ID during book issue

## Safe Operations

Prevents issuing an already issued book

Prevents returning a non-issued book

Useful error messages
## Sample Output
===== Library Menu =====
1. Show Books
2. Issue Book
3. Return Book
4. Exit
Enter choice: 1

--- Book List ---
1 - The Alchemist by Paulo Coelho [Available]
2 - 1984 by George Orwell [Available]
3 - Clean Code by Robert C. Martin [Available]

===== Library Menu =====
1. Show Books
2. Issue Book
3. Return Book
4. Exit
Enter choice: 2
Enter Book ID: 2
Enter User ID: 101
Book "1984" issued to Alice
===== Library Menu =====
1. Show Books
2. Issue Book
3. Return Book
4. Exit
Enter choice: 4
Exiting program...
