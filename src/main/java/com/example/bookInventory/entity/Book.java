package com.example.bookInventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@Column(name = "isbn", length = 13)
	private String isbn;
	
	@Column(name = "title", length = 70)
	private String title;
	
	@Column(name = "description", length = 100)
	private String description;
	
	@Column(name = "category")
	private Integer category;
	
	@Column(name = "edition", length = 30)
	private String edition;
	
	@Column(name = "publisherId")
	private Integer publisherId;
}
