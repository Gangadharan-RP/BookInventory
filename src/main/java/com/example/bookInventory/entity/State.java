package com.example.bookInventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "state")
public class State {
	@Id
	@Column(name = "stateCode", length = 2)
	private String stateCode;
	
	@Column(name = "stateName", length = 50)
	private String stateName;

	public State() {
		super();
	}

	public State(String stateCode, String stateName) {
		super();
		this.stateCode = stateCode;
		this.stateName = stateName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "State [stateCode=" + stateCode + ", stateName=" + stateName + "]";
	}
	
	
}
