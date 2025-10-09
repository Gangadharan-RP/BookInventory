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

import com.example.bookInventory.entity.Reviewer;
import com.example.bookInventory.service.ReviewerService;

@RestController
@RequestMapping("/api/reviewer")
public class ReviewerController {
	
	@Autowired
	private ReviewerService reviewerService;
	
	
	@GetMapping("/{reviewerId}")
	public ResponseEntity<Reviewer> getReviewerById(@PathVariable Integer reviewerId){
		return ResponseEntity.ok(reviewerService.getReviewerById(reviewerId));
	}
	
	@PostMapping("/post")
	public ResponseEntity<Reviewer> addReviewer(@RequestBody Reviewer reviewer){
		return ResponseEntity.ok(reviewerService.addReviewer(reviewer));
	}
	
	@PutMapping("/update/name/{reviewerId}")
	public ResponseEntity<Reviewer> updateNameById(@PathVariable Integer reviewerId, @RequestBody String name){
		return ResponseEntity.ok(reviewerService.updateReviewerNameById(reviewerId, name));
	}
	
	@PutMapping("/update/employedBy/{reviewerId}")
	public ResponseEntity<Reviewer> updateEmployementById(@PathVariable Integer reviewerId, @RequestBody String employedBy){
		return ResponseEntity.ok(reviewerService.updateReviewerEmployementById(reviewerId, employedBy));
	}
}
