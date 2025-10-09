package com.example.bookInventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookInventory.entity.Author;
import com.example.bookInventory.entity.Book;
import com.example.bookInventory.service.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	@GetMapping
	public ResponseEntity<List<Author>> getAuthor(){
		return ResponseEntity.ok(authorService.getAuthors());
	}
	
	@PostMapping
	public ResponseEntity<Author> addAuthor(@RequestBody Author author){
		return ResponseEntity.ok(authorService.addAuthor(author));
	}
	
	@GetMapping("/{authorId}")
	public ResponseEntity<Author> getAuthorById(@PathVariable Long authorId){
		return ResponseEntity.ok(authorService.getAuthorById(authorId));
	}
	
	@GetMapping("/firstname/{firstName}")
	public ResponseEntity<List<Author>> getAuthorsByFirstName(@PathVariable String firstName){
		return ResponseEntity.ok(authorService.getAuthorByFirstName(firstName));
	}
	
	@GetMapping("/lastname/{lastName}")
	public ResponseEntity<List<Author>> getAuthorsByLastName(@PathVariable String lastName){
		return ResponseEntity.ok(authorService.getAuthorByLastName(lastName));
	}
	
	@PutMapping("/update/firstName/{authorId}")
	public ResponseEntity<Author> updateFirstName(@PathVariable Long authorId,@RequestBody String firstName){
		return ResponseEntity.ok(authorService.updateAuthorFirstName(authorId, firstName));
	}
	
	@PutMapping("/update/lastName/{authorId}")
	public ResponseEntity<Author> updateLastName(@PathVariable Long authorId,@RequestBody String lastName){
		return ResponseEntity.ok(authorService.updateAuthorLastName(authorId, lastName));
	}
	
	@GetMapping("/books/{authorId}")
	public ResponseEntity<List<Book>> getBookByAuthorId(@PathVariable Long authorId){
		return ResponseEntity.ok(authorService.getBookByAuthorId(authorId));
	}
	
	
}
