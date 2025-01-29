# library-manager

## Overview
The **Library Manager** is a Java application that allows users to manage their personal book library. It enables users to add, edit, delete, search, and view books, along with tracking reading statistics. The project implements object-oriented principles and follows good software practices like exception handling, collections, and interfaces.

---

## Features
1. **Add Book**: Users can add a new book to the library by providing the title, author, genre, and reading status (read or unread).
2. **Edit Book**: Users can edit the details of an existing book by specifying the title and providing the new details.
3. **Delete Book**: Users can delete a book from the library by providing its title.
4. **Search Books**: Books can be searched by title, author, or genre.
5. **View Reading Stats**: Provides statistics on the number of read and unread books in the library.
6. **Display All Books**: Users can see a list of all the books in the library.

---

## Architecture

### Classes and Components
1. **`Media`** (Abstract Class): Represents the common properties of all media (books in this case), such as title and author.
2. **`Book`** (Class): Extends `Media` and represents a book, including properties like genre and reading status.
3. **`LibraryManager`** (Class): Manages a collection of books, provides methods for adding, editing, deleting, searching books, and viewing statistics.
4. **`Searchable`** (Interface): Defines the methods for searching books by title, author, or genre.
5. **`Main`** (Class): The entry point for the application, handles user input and interaction.
6. **Exceptions**:
    - `BookNotFoundException`: Thrown when a book cannot be found.
    - `DuplicateBookException`: Thrown when a book with the same title already exists.
    - `InvalidInputException`: Thrown when an invalid input is entered (e.g., author contains non-alphabet characters).
    - `InvalidYesNoInputException`: Thrown when the user inputs a value other than "yes" or "no".


## Git History


## How the Application Works

### 1. **Adding a Book**
When you choose the "Add Book" option from the menu, the application prompts you for the title, author, genre, and reading status of the book. The book is then added to the library collection.

### 2. **Editing a Book**
To edit a book, select the "Edit Book" option, provide the title of the book to edit, and enter the updated details. If the book exists, it will be updated with the new information.

### 3. **Deleting a Book**
Choose the "Delete Book" option and provide the title of the book to be deleted. If the book is found, it is removed from the collection.

### 4. **Searching for a Book**
You can search for a book by title, author, or genre by selecting the corresponding option from the menu. The results will be displayed if any books match the search criteria.

### 5. **Viewing Reading Stats**
The "Show Reading Stats" option displays how many books have been read and how many are unread.

### 6. **Displaying All Books**
The "Display All Books" option shows a list of all books in the library, displaying their title, author, genre, and reading status.

---

## Error Handling
The application handles various exceptions:
- If a user tries to add a duplicate book, a `DuplicateBookException` is thrown.
- If a user tries to delete or edit a book that does not exist, a `BookNotFoundException` is thrown.
- If a user enters invalid input (e.g., non-alphabetic characters for the author's name or an invalid yes/no answer), `InvalidInputException` or `InvalidYesNoInputException` is thrown.

Library Manager (Updated Version)
Features
The Personal Library Manager now includes an improved user interface with a sub-menu for searching books by title, author, or genre. This new feature enhances the flexibility of the application and makes it easier for users to search books by different attributes.
Updated Menu Structure
The updated menu now includes a sub-menu for search operations, which allows the user to perform more specific search queries for books.
The main menu now looks like this:
Personal Library Manager
1. Add Book
2. Edit Book
3. Delete Book
4. Search
5. Show Reading Stats
6. Display All Books
7. Exit
   When the user selects the Search option (4), they are presented with a sub-menu to choose the search criteria:
   Search Menu:
1. Search by Title
2. Search by Author
3. Search by Genre
4. Back to Main Menu
   This allows the user to search books using any of the following options:
* Search by Title
* Search by Author
* Search by Genre

Key Changes in the Code
* Search Menu: A sub-menu was added to allow users to search by title, author, or genre.

New Menu:
Personal Library Manager
1. Add Book
2. Edit Book
3. Delete Book
4. Search
5. Show Reading Stats
6. Display All Books
7. Exit
   Enter your choice:

Search Menu:
1. Search by Title
2. Search by Author
3. Search by Genre
4. Back to Main Menu
   Enter your choice: 