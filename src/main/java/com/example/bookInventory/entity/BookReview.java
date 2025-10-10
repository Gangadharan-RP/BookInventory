package com.example.bookInventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bookreview")
public class BookReview {
	@Id
	@Column(name="isbn", length=13)
	private String isbn;
	
	@Column(name="reviewerId")
	private Integer reviewerId;
	
	@Column(name="rating")
	private Integer rating;
	
	@Column(name="comment", length=255)
	private String comment;

	public BookReview() {
		super();
	}

	public BookReview(String isbn, Integer reviewerId, Integer rating, String comment) {
		super();
		this.isbn = isbn;
		this.reviewerId = reviewerId;
		this.rating = rating;
		this.comment = comment;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(Integer reviewerId) {
		this.reviewerId = reviewerId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "BookReview [isbn=" + isbn + ", reviewerId=" + reviewerId + ", rating=" + rating + ", comment=" + comment
				+ "]";
	}
	
	
}
