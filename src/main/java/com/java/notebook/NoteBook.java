package com.java.notebook;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NoteBook {
    private static NoteBook noteBookInstance;
    private static List<Note> notes;

    private NoteBook() {
        notes = new ArrayList<>();
    }

    public static NoteBook getNoteBook() {
        if(noteBookInstance == null) {
            noteBookInstance = new NoteBook();
        }
        return noteBookInstance;
    }

    public static List<Note> getAllNotes(){
        return notes;
    }

    public static boolean addNote(Note note) {
        return notes.add(note);
    }

    public static boolean addNotes(List<Note> notes){
        return notes.addAll(notes);
    }

    public static Note findNoteByText(String textToSearchFor){
        Iterator<Note> it = notes.iterator();
        while (it.hasNext()){
            Note note = it.next();
            if(note.getNoteText().contains(textToSearchFor)){
                return note;
            }
        }
        return null;
    }

    public static List<Note> findNotesByText(String textToSearchFor){
        List<Note> foundNotes = new ArrayList<>();
        Iterator<Note> it = notes.iterator();
        while (it.hasNext()){
            Note note = it.next();
            if(note.getNoteText().contains(textToSearchFor)){
                foundNotes.add(note);
            }
        }
        return foundNotes;
    }

    public static Note findNoteByDate(Date date){
        Iterator<Note> it = notes.iterator();
        while (it.hasNext()) {
            Note note = it.next();
            if (note.getNoteCreatedDate().equals(date)) {
                return note;
            }
        }
        return null;
    }

    public static List<Note> findNotesByDate(Date date){
        Iterator<Note> it = notes.iterator();
        List<Note> foundNotes = new ArrayList<>();
        while (it.hasNext()) {
            Note note = it.next();
            if (note.getNoteCreatedDate().equals(date)) {
                foundNotes.add(note);
            }
        }
        return foundNotes;
    }

    public static boolean deleteAllNotes() {
        if(notes.isEmpty()) {
            return true;
        } else {
            notes.clear();
            return notes.isEmpty();
        }
    }
}
