package com.example.bookInventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/{isbn}")
	public ResponseEntity<BookReview> getBookReviewByIsbn(@PathVariable String isbn){
		return ResponseEntity.ok(bookReviewService.getBookReviewByIsbn(isbn));
	}
	
	@PostMapping("/post")
	public ResponseEntity<BookReview> addBookReview(@RequestBody BookReview bookReview){
		return ResponseEntity.ok(bookReviewService.addBookReview(bookReview));
	}
	
	@PutMapping("/update/rating/{isbn}")
	public ResponseEntity<BookReview> updateRatingByIsbn(@PathVariable String isbn, @RequestBody Integer rating){
		return ResponseEntity.ok(bookReviewService.updateRatingByIsbn(isbn, rating));
	}
	
	@PutMapping("/update/comment/{isbn}")
	public ResponseEntity<BookReview> updateCommentByIsbn(@PathVariable String isbn, @RequestBody String comment){
		return ResponseEntity.ok(bookReviewService.updateCommentByIsbn(isbn, comment));
	}
}
