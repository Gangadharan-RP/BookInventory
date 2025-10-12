package com.example.bookInventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.UserDetail;
import com.example.bookInventory.repository.UserDetailRepository;
import com.example.bookInventory.service.UserDetailService;

@Service
public class UserDetailServiceImpl implements UserDetailService {
	
	@Autowired
	private UserDetailRepository userDetailRepository;
	
	@Override
	public List<UserDetail> getAllUser(){
		return userDetailRepository.findAll();
	}

	@Override
	public UserDetail addUser(UserDetail userDetail) {
		// TODO Auto-generated method stub
		return userDetailRepository.save(userDetail);
	}

	@Override
	public UserDetail getUserById(Integer userId) {
		// TODO Auto-generated method stub
		UserDetail userDetail = userDetailRepository.findByUserId(userId);
		if(userDetail==null)
			throw new RuntimeException();
		return userDetail;
	}

	@Override
	public UserDetail updatePhoneNumber(Integer userId, String phoneNumber) {
		// TODO Auto-generated method stub
		UserDetail newUser = getUserById(userId);
		newUser.setPhoneNumber(phoneNumber);
		return userDetailRepository.save(newUser);
	}

	@Override
	public UserDetail updateFirstName(Integer userId, String firstName) {
		// TODO Auto-generated method stub
		UserDetail newUser = getUserById(userId);
		newUser.setFirstName(firstName);
		return userDetailRepository.save(newUser);
	}

	@Override
	public UserDetail updateLastName(Integer userId, String lastName) {
		// TODO Auto-generated method stub
		UserDetail newUser = getUserById(userId);
		newUser.setLastName(lastName);
		return userDetailRepository.save(newUser);
	}

}
