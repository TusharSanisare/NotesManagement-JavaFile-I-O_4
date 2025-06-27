
import java.util.List;

public class NoteService {
  private NoteOperations noteOperations;

  public NoteService(NoteOperations noteOperations) {
    this.noteOperations = noteOperations;
  }

  public void saveNote(Notes note) {
    noteOperations.saveNote(note);
  }

  public void updateNote(Notes note) {
    noteOperations.updateNote(note);
  }

  public void deleteNote(String noteId) {
    noteOperations.deleteNote(noteId);
  }

  public Notes getNoteById(int noteId) {
    return noteOperations.getNoteById(noteId);
  }

  public List<Notes> getAllNotes() {
    return noteOperations.getAllNotes();
  }

}
