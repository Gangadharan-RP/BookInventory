package com.example.bookInventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.Reviewer;
import com.example.bookInventory.repository.ReviewerRepository;
import com.example.bookInventory.service.ReviewerService;

@Service
public class ReviewerServiceImpl implements ReviewerService{
	@Autowired
	private ReviewerRepository reviewerRepository;

	@Override
	public Reviewer addReviewer(Reviewer reviewer) {
		// TODO Auto-generated method stub
		return reviewerRepository.save(reviewer);
	}

	@Override
	public Reviewer getReviewerById(Integer reviewerId) {
		// TODO Auto-generated method stub
		return reviewerRepository.getByReviewerId(reviewerId);
	}

	@Override
	public Reviewer updateReviewerNameById(Integer reviewerId, String name) {
		// TODO Auto-generated method stub
		Reviewer reviewer = getReviewerById(reviewerId);
		reviewer.setName(name);
		return reviewerRepository.save(reviewer);
	}

	@Override
	public Reviewer updateReviewerEmployementById(Integer reviewerId, String employedBy) {
		// TODO Auto-generated method stub
		Reviewer reviewer = getReviewerById(reviewerId);
		reviewer.setEmployedBy(employedBy);
		return reviewerRepository.save(reviewer);
	}
	
	
}
