package com.example.note;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
@Entity(tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String desc;
    private int dow;
    private int priority;


    public Note(int id, String title, String desc, int dow, int priority) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.dow = dow;
        this.priority = priority;
    }
    @Ignore
    public Note(String title, String desc, int dow, int priority) {
        this.title = title;
        this.desc = desc;
        this.dow = dow;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDow(int dow) {
        this.dow = dow;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getDow() {
        return dow;
    }

    public int getPriority() {
        return priority;
    }

    public int getId() {
        return id;
    }

}
