package com.example.bookInventory.service;

import com.example.bookInventory.entity.BookReview;

public interface BookReviewService {
	BookReview getBookReviewByIsbn(String isbn);
	BookReview addBookReview(BookReview bookReview);
	BookReview updateRatingByIsbn(String isbn, Integer rating);
	BookReview updateCommentByIsbn(String isbn, String comment);
}
