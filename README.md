# Java File I/O – Notes App

## Overview

This project is a text-based notes management application developed in Java for Task 4 of the assignment. It allows users to create, view, delete, and list notes, stored as text files in a NOTES_DIR/ folder. The app uses FileReader and FileWriter with BufferedReader and BufferedWriter for efficient file I/O, meeting the task's requirements. It is designed to run in VS Code via Terminal and keeps compiled .class files in a bin/ folder to maintain a clean project directory.
Features

Create Note: Saves a note with a unique ID, title, content, and timestamps (created/modified dates) to NOTES_DIR/<id>.txt.
View Note: Reads and displays a note's content by ID.
Delete Note: Removes a note file by ID.
List All Notes: Displays all notes (ID, title, content), though date parsing is incomplete.
Exit: Closes the application.
File Organization: Notes are stored in NOTES_DIR/, and .class files are compiled to bin/ to avoid clutter.

### Project Structure

```
notes-app/
├── NOTES_DIR/                # Stores note .txt files (e.g., 123.txt)
├── bin/                      # Stores compiled .class files
├── Main.java                 # Entry point, starts the app
├── UserInput.java            # Console interface and menu
├── NoteOperations.java       # Interface for note operations
├── NoteOperationsOnFile.java # File I/O implementation
├── Notes.java                # Note object with Builder pattern
├── NoteService.java          # Service layer (partially used)
└── README.md                 # This file
```

### How It Works

Main.java: Initializes the app and runs UserInput in a loop.
UserInput.java: Provides a menu (1: Create, 2: View, 3: Delete, 4: List, 0: Exit) using Scanner.
NoteOperations.java: Defines the interface for note operations (save, update, delete, view, list).
NoteOperationsOnFile.java: Implements file I/O using FileReader/BufferedReader for reading and FileWriter/BufferedWriter for writing notes.
Notes.java: Represents a note with ID, title, content, and dates, built using a Builder pattern.
NoteService.java: Service layer for note operations (not fully utilized).

Each note is saved as a .txt file in NOTES_DIR/ with the format:
[Title]
Content
Created Date: YYYY-MM-DD Last Update: YYYY-MM-DD

## Setup and Running

Prerequisites: Java (JDK 8+), VS Code, Terminal.
Clone the Repository:git clone [<your-repo-url>](https://github.com/TusharSanisare/NotesManagement-JavaFile-I-O_4)
cd NotesManagement-JavaFile-I-O_4

### Create Directories:

Create src/ and move all .java files into it.
The app creates NOTES_DIR/ automatically for notes.
Create bin/ for .class files (or let javac create it).

```
Compile:javac -d bin src/*.java
Run:java -cp bin Main
```

## Usage:

Select options 1–4 to manage notes or 0 to exit.
Create: Enter ID, title, content; saves to NOTES_DIR/<id>.txt.
View/Delete: Enter note ID.
List: Shows all notes (ID, title, content).

did
File I/O: Uses FileReader/BufferedReader for reading and FileWriter/BufferedWriter for writing, as required.
Text-Based: Console-based interface, runs in VS Code/Terminal.
Extras: Includes delete and list-all-notes features, plus a modular OOP design with an interface and Builder pattern.
Note: The updateNote method is unimplemented (not required by the task). The getAllNotes method has incomplete date parsing.

Known Issues
List Notes: getAllNotes() in NoteOperationsOnFile.java doesn’t parse the date line, showing “Unknown” for dates.
Input Handling: scanner.nextInt() in UserInput may cause issues with non-numeric input.
NoteService: Not fully utilized, as UserInput directly uses NoteOperationsOnFile.

Improvements for Future
Fix getAllNotes() to parse the date line correctly.
Use scanner.nextLine() for menu input to handle invalid inputs better.
Implement updateNote for full CRUD functionality.
Add a cleanup option for .class files in bin/.
