package com.example.bookInventory.service;

import com.example.bookInventory.entity.Reviewer;

public interface ReviewerService {
	Reviewer addReviewer(Reviewer reviewer);
	Reviewer getReviewerById(Integer reviewerId);
	Reviewer updateReviewerNameById(Integer reviewerId, String name);
	Reviewer updateReviewerEmployementById(Integer reviewerId, String employedBy);
	
}
