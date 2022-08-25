package com.example.note;

import android.provider.BaseColumns;

public class NoteContract{
    public static final class NotesEntry implements BaseColumns{
        public static final String TABLE_MAME = "notes";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESC = "description";
        public static final String COLUMN_DOW = "dow";
        public static final String COLUMN_PRIORITY = "priority";
        public static final String TYPE_TEXT = "TEXT";
        public static final String TYPE_INTEGER = "INTEGER";
        public static final String CREATE_COMMAND = "CREATE TABLE IF NOT EXISTS " + TABLE_MAME + "(" + _ID + " " + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT, " + COLUMN_TITLE + " "
                + TYPE_TEXT + " ," + COLUMN_DESC + " " + TYPE_TEXT + " ," + COLUMN_DOW + " " + TYPE_INTEGER + " ," + COLUMN_PRIORITY + " " + TYPE_INTEGER + ")";
        public static final String DROP_COMMAND = "DROP TABLE IF EXISTS " + TABLE_MAME;

    }
}
