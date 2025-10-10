package com.example.bookInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookInventory.entity.BookReview;

public interface BookReviewRepository extends JpaRepository<BookReview, String> {

	BookReview getByIsbn(String isbn);

}
