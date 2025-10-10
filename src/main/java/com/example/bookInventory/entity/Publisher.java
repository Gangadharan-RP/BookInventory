package com.example.bookInventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="publisher")
public class Publisher {
	@Id
	@Column(name="publisherId")
	private Integer publisherId;
	
	@Column(name="name", length=50)
	private String name;
	
	@Column(name="city", length=30)
	private String city;
	
	@Column(name="stateCode", length=2)
	private String stateCode;

	public Publisher() {
		super();
	}

	public Publisher(Integer publisherId, String name, String city, String stateCode) {
		super();
		this.publisherId = publisherId;
		this.name = name;
		this.city = city;
		this.stateCode = stateCode;
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", name=" + name + ", city=" + city + ", stateCode="
				+ stateCode + "]";
	}
	
	
}
