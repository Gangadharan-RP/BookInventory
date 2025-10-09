package com.example.bookInventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.UserDet;
import com.example.bookInventory.repository.UserDetRepository;
import com.example.bookInventory.service.UserDetService;

@Service
public class UserDetServiceImpl implements UserDetService {
	
	@Autowired
	private UserDetRepository userDetRepository;

	@Override
	public UserDet addUser(UserDet userDet) {
		// TODO Auto-generated method stub
		if(userDetRepository.existsByUserId(userDet.getUserId())) {
			throw new RuntimeException("User Already Exists");
		}
		return userDetRepository.save(userDet);
	}

	@Override
	public UserDet getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userDetRepository.findByUserId(userId);
	}

	@Override
	public UserDet updatePhoneNumber(Integer userId, String phoneNumber) {
		// TODO Auto-generated method stub
		UserDet newUser = getUserById(userId);
		newUser.setPhoneNumber(phoneNumber);
		return userDetRepository.save(newUser);
	}

	@Override
	public UserDet updateFirstName(Integer userId, String firstName) {
		// TODO Auto-generated method stub
		UserDet newUser = getUserById(userId);
		newUser.setFirstName(firstName);
		return userDetRepository.save(newUser);
	}

	@Override
	public UserDet updateLastName(Integer userId, String lastName) {
		// TODO Auto-generated method stub
		UserDet newUser = getUserById(userId);
		newUser.setLastName(lastName);
		return userDetRepository.save(newUser);
	}

}
