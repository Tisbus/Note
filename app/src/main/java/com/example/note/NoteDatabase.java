package com.example.note;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {

    private static final String DB_NAME = "notes2.db";
    private static final Object LOCK = new Object();

    private static NoteDatabase database;

    public static NoteDatabase getInstance(Context context){
        synchronized (LOCK){
            if(database == null){
                database = Room.databaseBuilder(context, NoteDatabase.class, DB_NAME)
                        .build();
            }
        }

        return database;
    }

    public abstract NoteDao noteDao();

}
