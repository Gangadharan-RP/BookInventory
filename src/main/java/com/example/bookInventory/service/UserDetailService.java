package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.UserDetail;

public interface UserDetailService {
	UserDetail addUser(UserDetail userDetail);
	UserDetail getUserById(Integer userId);
	UserDetail updatePhoneNumber(Integer userId, String phoneNumber );
	UserDetail updateFirstName(Integer userId, String firstName);
	UserDetail updateLastName(Integer userId, String lastName);
	List<UserDetail> getAllUser();
}
