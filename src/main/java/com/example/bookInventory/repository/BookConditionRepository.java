package com.example.bookInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookInventory.entity.BookCondition;

public interface BookConditionRepository extends JpaRepository<BookCondition, Integer>{

	BookCondition getByRanks(Integer ranks);

}
