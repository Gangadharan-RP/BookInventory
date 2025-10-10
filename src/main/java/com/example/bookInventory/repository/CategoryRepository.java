package com.example.bookInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookInventory.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category getByCatId(Integer catId);

}
