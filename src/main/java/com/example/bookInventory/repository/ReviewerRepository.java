package com.example.bookInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookInventory.entity.Reviewer;

public interface ReviewerRepository extends JpaRepository<Reviewer, Integer> {

	Reviewer getByReviewerId(Integer reviewerId);

}
