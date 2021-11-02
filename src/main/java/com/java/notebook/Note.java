package com.java.notebook;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Note {
    private String noteID;
    private Date noteCreatedDate;
    private String noteText;

    public Note(){
        this.noteID = UUID.randomUUID().toString();
        this.noteCreatedDate = new Date();
        this.noteText = null;
    }

    public Note(String noteText){
        this.noteID = UUID.randomUUID().toString();
        this.noteCreatedDate = new Date();
        this.noteText = noteText;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public Date getNoteCreatedDate() {
        return noteCreatedDate;
    }

    public String getNoteID() {
        return noteID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Note note = (Note) o;
        if (noteID.equals(note.noteID)) return false;
        return Objects.equals(noteCreatedDate, note.noteCreatedDate) && noteText.equals(note.noteText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteID, noteCreatedDate, noteText);
    }

    @Override
    public String toString() {
        return "\"" + noteText + "\"" +
                ", created on " + noteCreatedDate;
    }

}

