package com.example.employ.product;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.employ.service.Services;
import com.example.employ.model.Note;

@Service
public class Product implements Services{
	private static Map<String, Note> noteRepo = new HashMap<>();
	static {
		Note n = new Note();
		n.setId("1");
		n.setEname("John");
		n.setDOB("12-03-1995");
		noteRepo.put(n.getId(), n);
		
		Note m = new Note();
		m.setId("2");
		m.setEname("Jafer");
		m.setDOB("11-04-1996");
		noteRepo.put(m.getId(), m);
	}
	@Override
	public void createNote(Note note) {
		noteRepo.put(note.getId(), note);
	}
	@Override
	public void updateNote(String id, Note note) {
		noteRepo.remove(id);
		note.setId(id);
		noteRepo.put(id, note);
	}
	
	@Override
	public void deleteNote(String id) {
		noteRepo.remove(id);
	}
	
	@Override
	public Collection<Note> getNotes(){
		return noteRepo.values();
	}
}
