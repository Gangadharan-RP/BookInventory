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

import com.example.bookInventory.entity.Book;
import com.example.bookInventory.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		return ResponseEntity.ok(bookService.getAllBooks());
	}
	
	@GetMapping("/{isbn}")
	public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn){
		return ResponseEntity.ok(bookService.getBookByIsbn(isbn));
	}
	
	@GetMapping("/title/{title}")
	public ResponseEntity<List<Book>> getBookByTitle(@PathVariable String title){
		return ResponseEntity.ok(bookService.getBooksByTitle(title));
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Book>> getBookByCategory(@PathVariable Integer category){
		return ResponseEntity.ok(bookService.getBooksByCategory(category));
	}
	
	@GetMapping("/publisher/{publisherId}")
	public ResponseEntity<List<Book>> getBookByPublisherId(@PathVariable Integer publisherId){
		return ResponseEntity.ok(bookService.getBooksByPublisherId(publisherId));
	}
	
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		return ResponseEntity.ok(bookService.addBook(book));
	}
	
	@PutMapping("/update/title/{isbn}")
	public ResponseEntity<Book> updateTitle(@PathVariable String isbn, @RequestBody String newTitle){
		return ResponseEntity.ok(bookService.updateBookTitle(isbn, newTitle));
	}
	
	@PutMapping("/update/description/{isbn}")
	public ResponseEntity<Book> updateDescription(@PathVariable String isbn, @RequestBody String newDesc){
		return ResponseEntity.ok(bookService.updateBookDescription(isbn, newDesc));
	}
	
	@PutMapping("/update/category/{isbn}")
	public ResponseEntity<Book> updateCategory(@PathVariable String isbn, @RequestBody Integer newCategory){
		return ResponseEntity.ok(bookService.updateBookCategory(isbn,newCategory));
	}
	
	@PutMapping("/update/publisher/{isbn}")
	public ResponseEntity<Book> updatePublisher(@PathVariable String isbn, @RequestBody Integer newPublisher){
		return ResponseEntity.ok(bookService.updateBookPublisher(isbn, newPublisher));
	}
	
	
}
