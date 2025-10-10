package com.example.bookInventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@Column(name="catId")
	private Integer catId;
	
	@Column(name="catDescription", length=24)
	private String catDescription;

	public Category() {
		super();
	}

	public Category(Integer catId, String catDescription) {
		super();
		this.catId = catId;
		this.catDescription = catDescription;
	}

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCatDescription() {
		return catDescription;
	}

	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catDescription=" + catDescription + "]";
	}
	
}
