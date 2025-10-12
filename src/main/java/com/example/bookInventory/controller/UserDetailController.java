package com.example.bookInventory.controller;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	private UserDetailService userDetailService;
	
	@GetMapping()
	public ResponseEntity<List<UserDetail>> getAllUser(){
		return ResponseEntity.ok(userDetailService.getAllUser());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDetail> getUserById(@PathVariable Integer userId){
		return ResponseEntity.ok(userDetailService.getUserById(userId));
	}
	
	@PostMapping("/post")
	public ResponseEntity<Map<String,String>> addUser(@RequestBody UserDetail userDetails){
		Map<String, String> response = new LinkedHashMap<>();
		try {
				userDetailService.getUserById(userDetails.getUserId());
				response.put("code", "ADDFAILS");
				response.put("message", "User already exists");
				return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
			}
		
		catch(RuntimeException e) {
		}
		
		userDetailService.addUser(userDetails);
		response.put("code", "POSTSUCCESS");
		response.put("message", "User added successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/update/phonenumber/{userId}")
	public ResponseEntity<UserDetail> updatePhoneNumberById(@PathVariable Integer userId, @RequestBody String phonenumber){
		return ResponseEntity.ok(userDetailService.updatePhoneNumber(userId, phonenumber));
	}
	
	@PutMapping("/update/firstname/{userId}")
	public ResponseEntity<UserDetail> updateFirstNameById(@PathVariable Integer userId, @RequestBody String firstName){
		return ResponseEntity.ok(userDetailService.updateFirstName(userId, firstName));
	}
	
	@PutMapping("/update/lastname/{userId}")
	public ResponseEntity<UserDetail> updateLastNameById(@PathVariable Integer userId, @RequestBody String lastName){
		return ResponseEntity.ok(userDetailService.updateLastName(userId, lastName));
	}
	
	

}
