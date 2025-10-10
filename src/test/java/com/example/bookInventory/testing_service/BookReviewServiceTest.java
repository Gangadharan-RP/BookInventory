package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.BookReview;
import com.example.bookInventory.service.BookReviewService;

public class BookReviewServiceTest {
	BookReviewService bookReviewService = mock(BookReviewService.class);
	
	@Test
	void testAddBookReview() {
		BookReview bookReview = new BookReview("1234", 1, 8, "Good Book");
		when(bookReviewService.addBookReview(bookReview)).thenReturn(bookReview);
		
		BookReview result = bookReviewService.addBookReview(bookReview);
		assertEquals(8, result.getRating());
	}
	
	@Test
	void testUpdateRatingByIsbn() {
		BookReview bookReview = new BookReview("1234", 1, 8, "Good Book");
		when(bookReviewService.updateRatingByIsbn("1234", 8)).thenReturn(bookReview);
		
		BookReview result = bookReviewService.updateRatingByIsbn("1234", 8);
		assertEquals(8, result.getRating());
	}
}
