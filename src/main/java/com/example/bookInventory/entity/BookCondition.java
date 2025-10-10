package com.example.bookInventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bookcondition")
public class BookCondition {
	@Id
	@Column(name="ranks")
	private Integer ranks;
	
	@Column(name="description", length=50)
	private String description;
	
	@Column(name="fullDesc", length=255)
	private String fullDesc;
	
	@Column(name="price")
	private Double price;

	public BookCondition() {
		super();
	}

	public BookCondition(Integer ranks, String description, String fullDesc, Double price) {
		super();
		this.ranks = ranks;
		this.description = description;
		this.fullDesc = fullDesc;
		this.price = price;
	}

	public Integer getRanks() {
		return ranks;
	}

	public void setRanks(Integer ranks) {
		this.ranks = ranks;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFullDesc() {
		return fullDesc;
	}

	public void setFullDesc(String fullDesc) {
		this.fullDesc = fullDesc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookCondition [ranks=" + ranks + ", description=" + description + ", fullDesc=" + fullDesc + ", price="
				+ price + "]";
	}
	
}
