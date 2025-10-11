package com.example.bookInventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userDetails")
public class UserDetail {
	@Id
	@Column(name = "userID")
	private Integer userId;
	
	@Column(name = "lastName", length = 30)
	private String lastName;
	
	@Column(name = "firstName", length = 20)
	private String firstName;
	
	@Column(name = "phoneNumber", length = 14)
	private String phoneNumber;
	
	@Column(name = "userName", length = 30)
	private String userName;
	
	@Column(name = "password", length = 30)
	private String password;
	
	@Column(name = "roleNumber")
	private Integer roleNumber;

	public UserDetail() {
		super();
	}

	public UserDetail(Integer userId, String lastName, String firstName, String phoneNumber, String userName,
			String password, Integer roleNumber) {
		super();
		this.userId = userId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.roleNumber = roleNumber;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleNumber() {
		return roleNumber;
	}

	public void setRoleNumber(Integer roleNumber) {
		this.roleNumber = roleNumber;
	}

	@Override
	public String toString() {
		return "UserDet [userId=" + userId + ", lastName=" + lastName + ", firstName=" + firstName + ", phoneNumber="
				+ phoneNumber + ", userName=" + userName + ", password=" + password + ", roleNumber=" + roleNumber
				+ "]";
	}
	
	
}
