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

import com.example.bookInventory.entity.BookReview;
import com.example.bookInventory.service.BookReviewService;

@RestController
@RequestMapping("/api/bookreview")
public class BookReviewController {

	@Autowired
	private BookReviewService bookReviewService;
	
	@GetMapping()
	public ResponseEntity<List<BookReview>> getAllBookReview(){
		return ResponseEntity.ok(bookReviewService.getAllBookReview());
	}
	
	@GetMapping("/{isbn}")
	public ResponseEntity<BookReview> getBookReviewByIsbn(@PathVariable String isbn){
		return ResponseEntity.ok(bookReviewService.getBookReviewByIsbn(isbn));
	}
	
	@PostMapping("/post")
	public ResponseEntity<Map<String, String>> addBookReview(@RequestBody BookReview bookReview){
		Map<String, String> response = new LinkedHashMap<>();
		try {
				bookReviewService.getBookReviewByIsbn(bookReview.getIsbn());
				response.put("code", "ADDFAILS");
				response.put("message", "Book Review already exists");
				return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
			}
		
		catch(RuntimeException e) {
		}
		
		bookReviewService.addBookReview(bookReview);
		response.put("code", "POSTSUCCESS");
		response.put("message", "Book Review added successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/update/rating/{isbn}")
	public ResponseEntity<BookReview> updateRatingByIsbn(@PathVariable String isbn, @RequestBody BookReview bookReview){
		return ResponseEntity.ok(bookReviewService.updateRatingByIsbn(isbn, bookReview.getRating()));
	}
	
	@PutMapping("/update/comment/{isbn}")
	public ResponseEntity<BookReview> updateCommentByIsbn(@PathVariable String isbn, @RequestBody BookReview bookReview){
		return ResponseEntity.ok(bookReviewService.updateCommentByIsbn(isbn, bookReview.getComment()));
	}
}
