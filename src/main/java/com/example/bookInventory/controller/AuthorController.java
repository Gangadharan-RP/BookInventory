package com.example.bookInventory.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.example.bookInventory.exception.AuthorNotFoundException;
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
	public ResponseEntity<Map<String,String>> addAuthor(@RequestBody Author author){
		Map<String, String> response = new LinkedHashMap<>();
		try {

				authorService.getAuthorById(author.getAuthorId());
				response.put("code", "ADDFAILS");
				response.put("message", "Author already exists");
				return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
			}
		
		catch(AuthorNotFoundException e) {
		}
		
		authorService.addAuthor(author);
		response.put("code", "POSTSUCCESS");
		response.put("message", "Author added successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
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
	
	@PutMapping("/update/firstname/{authorId}")
	public ResponseEntity<Author> updateFirstName(@PathVariable Long authorId,@RequestBody Author author){
		return ResponseEntity.ok(authorService.updateAuthorFirstName(authorId, author.getFirstName()));
	}
	
	@PutMapping("/update/lastname/{authorId}")
	public ResponseEntity<Author> updateLastName(@PathVariable Long authorId,@RequestBody Author author){
		return ResponseEntity.ok(authorService.updateAuthorLastName(authorId, author.getLastName()));
	}
	
	@GetMapping("/books/{authorId}")
	public ResponseEntity<List<Book>> getBookByAuthorId(@PathVariable Long authorId){
		return ResponseEntity.ok(authorService.getBookByAuthorId(authorId));
	}
	
	
}
