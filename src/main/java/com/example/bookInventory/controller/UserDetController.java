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

import com.example.bookInventory.entity.UserDet;
import com.example.bookInventory.service.UserDetService;

@RestController
@RequestMapping("/api/userdetail")
public class UserDetController {
	
	@Autowired
	private UserDetService userDetService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDet> getUserById(@PathVariable Integer userId){
		return ResponseEntity.ok(userDetService.getUserById(userId));
	}
	
	@PostMapping("/post")
	public ResponseEntity<UserDet> addUser(@RequestBody UserDet userDetails){
		return ResponseEntity.ok(userDetService.addUser(userDetails));
	}
	
	@PutMapping("/update/phonenumber/{userId}")
	public ResponseEntity<UserDet> updatePhoneNumberById(@PathVariable Integer userId, @RequestBody String phonenumber){
		return ResponseEntity.ok(userDetService.updatePhoneNumber(userId, phonenumber));
	}
	
	@PutMapping("/update/firstname/{userId}")
	public ResponseEntity<UserDet> updateFirstNameById(@PathVariable Integer userId, @RequestBody String firstName){
		return ResponseEntity.ok(userDetService.updateFirstName(userId, firstName));
	}
	
	@PutMapping("/update/lastname/{userId}")
	public ResponseEntity<UserDet> updateLastNameById(@PathVariable Integer userId, @RequestBody String lastName){
		return ResponseEntity.ok(userDetService.updateLastName(userId, lastName));
	}
	
	

}
