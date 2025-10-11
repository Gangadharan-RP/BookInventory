package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.UserDetail;
import com.example.bookInventory.service.UserDetailService;

public class UserDetailServiceTest {
	UserDetailService userDetailService = mock(UserDetailService.class);
	
	@Test
	void testAddUser() {
		UserDetail userDetail = new UserDetail(1,"Karthi", "Arul", "989898", "arulKarthi", "arulMass", 15);
		when(userDetailService.addUser(userDetail)).thenReturn(userDetail);
		
		UserDetail result = userDetailService.addUser(userDetail);
		assertEquals("arulKarthi", result.getUserName());
	}
	
	@Test
	void testGetUserById() {
		UserDetail userDetail = new UserDetail(1,"Karthi", "Arul", "989898", "arulKarthi", "arulMass", 15);
		when(userDetailService.getUserById(1)).thenReturn(userDetail);
		
		UserDetail result = userDetailService.getUserById(1);
		assertEquals("Arul", result.getFirstName());
	}
	
	@Test
	void testUpdateLastName() {
		UserDetail userDetail = new UserDetail(1,"Karthikeyan", "Arul", "989898", "arulKarthi", "arulMass", 15);
		when(userDetailService.updateLastName(1, "Karthikeyan")).thenReturn(userDetail);
		
		UserDetail result = userDetailService.updateLastName(1, "Karthikeyan");
		assertEquals("Karthikeyan", result.getLastName());
	}
}
