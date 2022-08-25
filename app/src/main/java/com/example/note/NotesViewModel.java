package com.example.note;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {

    private static NoteDatabase database;
    private LiveData<List<Note>> note;

    public NotesViewModel(Application application) {
        super(application);
        database = NoteDatabase.getInstance(getApplication());
        note = database.noteDao().getAllNotes();
    }

    public LiveData<List<Note>> getNote() {
        return note;
    }

    void insertNote(Note note) {
        new InsertTask().execute(note);
    }

    void deleteNote(Note note) {
        new DeleteTask().execute(note);
    }
    void deleteAllNote (Note note){
        new DeleteAllTask().execute(note);
    }

    private static class InsertTask extends AsyncTask<Note, Void, Void>{
        @Override
        protected Void doInBackground(Note... notes) {
            if(notes != null && notes.length > 0){
                database.noteDao().insertNote(notes[0]);
            }
            return null;
        }
    }
    private static class DeleteTask extends AsyncTask<Note, Void, Void>{
        @Override
        protected Void doInBackground(Note... notes) {
            if(notes != null && notes.length > 0){
                database.noteDao().deleteNote(notes[0]);
            }
            return null;
        }
    }
    private static class DeleteAllTask extends AsyncTask<Note, Void, Void>{
        @Override
        protected Void doInBackground(Note... notes) {
            if(notes != null && notes.length > 0){
                database.noteDao().deleteAllNotes();
            }
            return null;
        }
    }

}

