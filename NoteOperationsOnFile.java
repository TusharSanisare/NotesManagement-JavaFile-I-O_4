
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NoteOperationsOnFile implements NoteOperations {

  private static final String FILE_DIR = "NOTES_DIR/";

  @Override
  public String saveNote(Notes note) {
    File file = new File(FILE_DIR + note.getId() + ".txt");
    if (file.exists()) {
      return "WARNING: Note ID already exists: " + note.getId();
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_DIR + note.getId() + ".txt"))) {
      writer.write("[" + note.getTitle() + "]\n");
      writer.write(note.getContent() + "\n");
      writer.write("Created Date: " + note.getDateCreated() + " Last Update: " + note.getDateModified());

    } catch (IOException e) {
      return "ERROR: Error creating/writing file: " + e.getMessage();
    }

    return "Note saved successfully: " + note.getId();
  }

  @Override
  public void updateNote(Notes note) {
    // not yet implemented yrrr... Es liye DBMS ka invention hua tha
  }

  @Override
  public String deleteNote(String noteId) {
    File file = new File(FILE_DIR + noteId + ".txt");
    if (!file.exists()) {
      return "ERROR: Note with ID " + noteId + " does not exist.";
    }
    if (file.delete()) {
      return "Note with ID " + noteId + " deleted successfully.";
    } else {
      return "ERROR: Failed to delete note with ID " + noteId + ".";
    }

  }

  @Override
  public Notes getNoteById(int noteId) {
    return null;
  }

  @Override
  public List<Notes> getAllNotes() {
    File dir = new File(FILE_DIR);
    if (!dir.exists() || !dir.isDirectory()) {
      return List.of();
    }
    File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));
    if (files == null || files.length == 0) {
      return List.of(); // Return an empty list if no files found
    }
    List<Notes> notesList = new java.util.ArrayList<>();
    for (File file : files) {
      String noteId = file.getName().replace(".txt", "");
      String title = "";
      String content = "";
      String dateCreated = "";
      String dateModified = "";
      try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        title = reader.readLine();
        content = reader.readLine();
        dateCreated = "Unknown";
        dateModified = "Unknown";

      } catch (IOException e) {
        System.err.println("ERROR: Error reading file " + file.getName() + ": " + e.getMessage());
        continue; // Skip this file if there's an error
      }
      Notes note = new Notes.Builder()
          .setId(noteId)
          .setTitle(title)
          .setContent(content)
          .setDateCreated(dateCreated)
          .setDateModified(dateModified)
          .build();
      notesList.add(note);
    }
    return notesList;

  }

  @Override
  public String viewNote(String noteId) {
    File file = new File(FILE_DIR + noteId + ".txt");
    if (!file.exists())
      return "ERROR: Note with ID " + noteId + " does not exist.";

    StringBuilder content = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append("\n");
      }
    } catch (IOException e) {
      return "ERROR: Error reading file: " + e.getMessage();
    }
    return "Note Content (" + noteId + "):\n" + content.toString();
  }

}
