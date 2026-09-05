# Library Management System (Java)

A simple console-based Library Management System built in core Java. It's designed
as a small, self-contained project to demonstrate Java fundamentals: OOP
(classes, encapsulation), collections (`ArrayList`), and a basic DSA concept
(binary search) alongside everyday CRUD-style operations.

## Features
- Add a new book
- Remove a book by ID
- Search books by title (partial match)
- Issue / return a book
- Display all books, sorted by title
- Look up a book by ID using a manually implemented binary search

## Project Structure
```
LibraryManagementSystem/
├── README.md
└── src/
    ├── Book.java      # Model class (fields, getters/setters, encapsulation)
    ├── Library.java   # Business logic (add/remove/search/sort/binary search)
    └── Main.java      # Console menu / entry point
```

## Concepts Demonstrated
- **OOP**: encapsulation (private fields with getters/setters), separation of
  concerns between `Book` (data), `Library` (logic), and `Main` (UI/menu).
- **Collections**: `ArrayList<Book>`, `Comparator`, `Collections.sort`.
- **DSA**: manual binary search implementation (`Library.searchById`).
- **Basic I/O**: `Scanner` for console input, input validation for numbers.

3. Follow the on-screen menu to add, search, issue, or return books.
## How to Run
```Make sure you have a JDK installed (Java 8 or later).
From the project root:
bash
   cd src
   javac *.java
   java Main
```
## Possible Extensions
- Persist data to a file or a database instead of in-memory storage.
- Add a `Member`/`User` class to track who has borrowed which book.
- Add due dates and fine calculation for late returns.
- Wrap the logic in a basic GUI (JavaFX or Swing) instead of the console menu.
