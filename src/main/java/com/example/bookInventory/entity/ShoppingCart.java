package com.example.bookInventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "shoppingCart" )
public class ShoppingCart {
	
	@Id
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "isbn", length = 11)
	private String isbn;

	public ShoppingCart() {
		super();
	}

	public ShoppingCart(Integer userId, String isbn) {
		super();
		this.userId = userId;
		this.isbn = isbn;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "ShoppingCart [userId=" + userId + ", isbn=" + isbn + "]";
	}
	
	
}
