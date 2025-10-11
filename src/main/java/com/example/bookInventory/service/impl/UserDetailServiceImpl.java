package com.example.bookInventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.UserDetail;
import com.example.bookInventory.repository.UserDetailRepository;
import com.example.bookInventory.service.UserDetailService;

@Service
public class UserDetailServiceImpl implements UserDetailService {
	
	@Autowired
	private UserDetailRepository userDetRepository;

	@Override
	public UserDetail addUser(UserDetail userDet) {
		// TODO Auto-generated method stub
		if(userDetRepository.existsByUserId(userDet.getUserId())) {
			throw new RuntimeException("User Already Exists");
		}
		return userDetRepository.save(userDet);
	}

	@Override
	public UserDetail getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userDetRepository.findByUserId(userId);
	}

	@Override
	public UserDetail updatePhoneNumber(Integer userId, String phoneNumber) {
		// TODO Auto-generated method stub
		UserDetail newUser = getUserById(userId);
		newUser.setPhoneNumber(phoneNumber);
		return userDetRepository.save(newUser);
	}

	@Override
	public UserDetail updateFirstName(Integer userId, String firstName) {
		// TODO Auto-generated method stub
		UserDetail newUser = getUserById(userId);
		newUser.setFirstName(firstName);
		return userDetRepository.save(newUser);
	}

	@Override
	public UserDetail updateLastName(Integer userId, String lastName) {
		// TODO Auto-generated method stub
		UserDetail newUser = getUserById(userId);
		newUser.setLastName(lastName);
		return userDetRepository.save(newUser);
	}

}
