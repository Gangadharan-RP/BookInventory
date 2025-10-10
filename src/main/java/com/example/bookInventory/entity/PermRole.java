package com.example.bookInventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="permrole")
public class PermRole {
	@Id
	@Column(name="roleNumber")
	private Integer roleNumber;
	
	@Column(name="permRole", length=30)
	private String permRole;

	public PermRole() {
		super();
	}

	public PermRole(Integer roleNumber, String permRole) {
		super();
		this.roleNumber = roleNumber;
		this.permRole = permRole;
	}

	public Integer getRoleNumber() {
		return roleNumber;
	}

	public void setRoleNumber(Integer roleNumber) {
		this.roleNumber = roleNumber;
	}

	public String getPermRole() {
		return permRole;
	}

	public void setPermRole(String permRole) {
		this.permRole = permRole;
	}

	@Override
	public String toString() {
		return "PermRole [roleNumber=" + roleNumber + ", permRole=" + permRole + "]";
	}
	
	
}
