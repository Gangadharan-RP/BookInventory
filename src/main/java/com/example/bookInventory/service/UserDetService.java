package com.example.bookInventory.service;

import com.example.bookInventory.entity.UserDet;

public interface UserDetService {
	UserDet addUser(UserDet userDet);
	UserDet getUserById(Integer userId);
	UserDet updatePhoneNumber(Integer userId, String phoneNumber );
	UserDet updateFirstName(Integer userId, String firstName);
	UserDet updateLastName(Integer userId, String lastName);
}
