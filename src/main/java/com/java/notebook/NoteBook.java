package com.java.notebook;

import java.util.ArrayList;
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

    public Note findFirstMatch(String textToSearchFor){
        Iterator<Note> it = notes.iterator();
        while (it.hasNext()){
            Note note = it.next();
            if(note.getNoteText().contains(textToSearchFor)){
                return note;
            }
        }
        return null;
    }

    public List<Note> findAllMatches(String textToSearchFor){
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

    public boolean deleteAllNotes() {
        if(notes.isEmpty()) {
            return true;
        } else {
            notes.clear();
            return notes.isEmpty();
        }
    }
}
