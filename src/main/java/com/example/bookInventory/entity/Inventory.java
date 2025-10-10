package com.example.bookInventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory {
	
	@Id
	@Column(name="inventoryId")
	private Integer inventoryId;
	
	@Column(name="isbn", length=13)
	private String isbn;
	
	@Column(name="rank")
	private Integer rank;
	
	@Column(name="purchased")
	private Integer purchased;

	public Inventory() {
		super();
	}

	public Inventory(Integer inventoryId, String isbn, Integer rank, Integer purchased) {
		super();
		this.inventoryId = inventoryId;
		this.isbn = isbn;
		this.rank = rank;
		this.purchased = purchased;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getPurchased() {
		return purchased;
	}

	public void setPurchased(Integer purchased) {
		this.purchased = purchased;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", isbn=" + isbn + ", rank=" + rank + ", purchased="
				+ purchased + "]";
	}
	
	
}
