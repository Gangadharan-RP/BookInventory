package com.example.bookInventory.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookInventory.entity.UserDetail;
import com.example.bookInventory.service.UserDetailService;

@RestController
@RequestMapping("/api/userdetail")
public class UserDetailController {
	
	@Autowired
	private UserDetailService userDetService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDetail> getUserById(@PathVariable Integer userId){
		return ResponseEntity.ok(userDetService.getUserById(userId));
	}
	
	@PostMapping("/post")
	public ResponseEntity<UserDetail> addUser(@RequestBody UserDetail userDetails){
		return ResponseEntity.ok(userDetService.addUser(userDetails));
	}
	
	@PutMapping("/update/phonenumber/{userId}")
	public ResponseEntity<UserDetail> updatePhoneNumberById(@PathVariable Integer userId, @RequestBody String phonenumber){
		return ResponseEntity.ok(userDetService.updatePhoneNumber(userId, phonenumber));
	}
	
	@PutMapping("/update/firstname/{userId}")
	public ResponseEntity<UserDetail> updateFirstNameById(@PathVariable Integer userId, @RequestBody String firstName){
		return ResponseEntity.ok(userDetService.updateFirstName(userId, firstName));
	}
	
	@PutMapping("/update/lastname/{userId}")
	public ResponseEntity<UserDetail> updateLastNameById(@PathVariable Integer userId, @RequestBody String lastName){
		return ResponseEntity.ok(userDetService.updateLastName(userId, lastName));
	}
	
	

}
