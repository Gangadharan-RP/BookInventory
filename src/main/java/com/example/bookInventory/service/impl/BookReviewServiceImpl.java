package com.example.bookInventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.BookReview;
import com.example.bookInventory.repository.BookReviewRepository;
import com.example.bookInventory.service.BookReviewService;

@Service
public class BookReviewServiceImpl implements BookReviewService{
	
	@Autowired
	private BookReviewRepository bookReviewRepository;
	
	@Override
	public List<BookReview> getAllBookReview(){
		return bookReviewRepository.findAll();
	}

	@Override
	public BookReview getBookReviewByIsbn(String isbn) {
		// TODO Auto-generated method stub
		BookReview bookReview = bookReviewRepository.getByIsbn(isbn);
		if(bookReview == null)
			throw new RuntimeException();
		return bookReview;
	}

	@Override
	public BookReview addBookReview(BookReview bookReview) {
		// TODO Auto-generated method stub
		return bookReviewRepository.save(bookReview);
	}

	@Override
	public BookReview updateRatingByIsbn(String isbn, Integer rating) {
		// TODO Auto-generated method stub
		BookReview bookReview = getBookReviewByIsbn(isbn);
		bookReview.setRating(rating);
		return bookReviewRepository.save(bookReview);
	}

	@Override
	public BookReview updateCommentByIsbn(String isbn, String comment) {
		// TODO Auto-generated method stub
		BookReview bookReview = getBookReviewByIsbn(isbn);
		bookReview.setComment(comment);
		return bookReviewRepository.save(bookReview);
	}

}
