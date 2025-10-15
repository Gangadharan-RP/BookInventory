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

import com.example.bookInventory.entity.Reviewer;
import com.example.bookInventory.service.ReviewerService;

@RestController
@RequestMapping("/api/reviewer")
public class ReviewerController {
	
	@Autowired
	private ReviewerService reviewerService;
	
	@GetMapping()
	public ResponseEntity<List<Reviewer>> getAllReviewer(){
		return ResponseEntity.ok(reviewerService.getAllReviewer());
	}
	
	@GetMapping("/{reviewerId}")
	public ResponseEntity<Reviewer> getReviewerById(@PathVariable Integer reviewerId){
		return ResponseEntity.ok(reviewerService.getReviewerById(reviewerId));
	}
	
	@PostMapping("/post")
	public ResponseEntity<Map<String,String>> addReviewer(@RequestBody Reviewer reviewer){
		Map<String, String> response = new LinkedHashMap<>();
		try {
				reviewerService.getReviewerById(reviewer.getReviewerId());
				response.put("code", "ADDFAILS");
				response.put("message", "Reviewer already exists");
				return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
			}
		
		catch(RuntimeException e) {
		}
		
		reviewerService.addReviewer(reviewer);
		response.put("code", "POSTSUCCESS");
		response.put("message", "Reviewer added successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/update/name/{reviewerId}")
	public ResponseEntity<Reviewer> updateNameById(@PathVariable Integer reviewerId, @RequestBody Reviewer reviewer){
		return ResponseEntity.ok(reviewerService.updateReviewerNameById(reviewerId, reviewer.getName()));
	}
	
	@PutMapping("/update/employedBy/{reviewerId}")
	public ResponseEntity<Reviewer> updateEmployementById(@PathVariable Integer reviewerId, @RequestBody Reviewer reviewer){
		return ResponseEntity.ok(reviewerService.updateReviewerEmployementById(reviewerId, reviewer.getEmployedBy()));
	}
}
