package com.example.employ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employ.model.Note;
import com.example.employ.service.Services;

@RestController
public class Controller {
	@Autowired
	Services services;
	
	@RequestMapping(value = "/notes")
	public ResponseEntity<Object> getNote(){
		return new ResponseEntity<>(services.getNotes(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/notes/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object>
	 updateNote(@PathVariable("id") String id, @RequestBody Note note) {
		
		services.updateNote(id, note);
	      return new ResponseEntity<>("Notet is updated successsfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/notes/{id}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> delete(@PathVariable("id") String id) {
	      services.deleteNote(id);
	      return new ResponseEntity<>("Note is deleted successsfully", HttpStatus.OK);
	   }
	   @RequestMapping(value = "/notes", method = RequestMethod.POST)
	   public ResponseEntity<Object> createNote(@RequestBody Note note) {
	      services.createNote(note);
	      return new ResponseEntity<>("Note is created successfully", HttpStatus.CREATED);
	   }
}
