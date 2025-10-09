package com.example.bookInventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviewer")
public class Reviewer {
	
	@Id
	@Column(name = "reviewerId")
	private Integer reviewerId;

	@Column(name = "name", length = 20)
	private String name;
	
	@Column(name = "employedBy", length = 30)
	private String employedBy;

	public Reviewer() {
		super();
	}

	public Reviewer(Integer reviewerId, String name, String employedBy) {
		super();
		this.reviewerId = reviewerId;
		this.name = name;
		this.employedBy = employedBy;
	}

	public Integer getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(Integer reviewerId) {
		this.reviewerId = reviewerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployedBy() {
		return employedBy;
	}

	public void setEmployedBy(String employedBy) {
		this.employedBy = employedBy;
	}

	@Override
	public String toString() {
		return "Reviewer [reviewerId=" + reviewerId + ", name=" + name + ", employedBy=" + employedBy + "]";
	}


	
	
}
