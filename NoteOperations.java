import java.util.List;

public interface NoteOperations {

  String saveNote(Notes note);

  void updateNote(Notes note);

  String deleteNote(String noteId);

  Notes getNoteById(int noteId);

  List<Notes> getAllNotes();

  String viewNote(String noteId);

}
