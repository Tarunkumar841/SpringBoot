package com.example.employ.service;

import java.util.Collection;

import com.example.employ.model.Note;

public interface Services {
	public abstract void createNote(Note note);
	public abstract void updateNote(String id, Note note);
	public abstract void deleteNote(String id);
	//public abstract Collection<Note> getNotes;
	Collection<Note> getNotes();

}
