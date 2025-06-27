import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInput {
  private NoteOperations noteOperations;
  private Scanner scanner = new Scanner(System.in);
  private static int userChoice;

  public UserInput() {
    this.noteOperations = new NoteOperationsOnFile();
  }

  private void printOptions() {
    System.out.println("Press '1' to Create a new note");
    System.out.println("Press '2' to View an existing note");
    System.out.println("Press '3' to Delete a note");
    System.out.println("Press '4' to View all notes");
    System.out.println("Press '0' to Exit");
    System.out.print("Please select an option: ");

    userChoice = scanner.nextInt();
    scanner.nextLine();
  }

  public void getUserInput() {

    printOptions();

    if (userChoice == 0) {
      System.out.println("Exiting the application. Goodbye!");
      System.exit(0);
    } else if (userChoice == 1) {
      System.out.println("You chose to create a new note.");
      createNote();
    } else if (userChoice == 2) {
      System.out.println("You chose to view note.");
      viewNote();
    } else if (userChoice == 3) {
      System.out.println("You chose to delete a note.");
      deleteNote();
    } else if (userChoice == 4) {
      System.out.println("You chose to view all notes.");
      printListOfNotes();
    } else {
      System.out.println("Invalid choice. Please try again.");
    }
  }

  private void printListOfNotes() {
    System.out.println("List of all notes:");
    List<Notes> status = noteOperations.getAllNotes();
    if (status.isEmpty()) {
      System.out.println("No notes found.");
      return;
    }
    for (Notes note : status) {
      System.out
          .println("\nID: " + note.getId() + "\nTitle: " + note.getTitle() + "\nContent: " + note.getContent());
    }
  }

  private void viewNote() {
    System.out.print("Enter the ID of the note: ");
    String id = scanner.nextLine();
    String status = noteOperations.viewNote(id);
    System.out.println(status);
  }

  private void deleteNote() {
    System.out.print("Enter the ID of the note: ");
    String id = scanner.nextLine();
    String status = noteOperations.deleteNote(id);
    System.out.println(status);

  }

  private void createNote() {
    System.out.print("Enter the ID of the note: ");
    String id = scanner.nextLine();
    System.out.print("Enter the title of the note: ");
    String title = scanner.nextLine();
    System.out.print("Enter the content of the note: ");
    String content = scanner.nextLine();

    Notes note = new Notes.Builder()
        .setId(id)
        .setTitle(title)
        .setContent(content)
        .setDateCreated(LocalDate.now().toString())
        .setDateModified(LocalDate.now().toString())
        .build();

    String status = noteOperations.saveNote(note);
    System.out.println(status);
  }

}
