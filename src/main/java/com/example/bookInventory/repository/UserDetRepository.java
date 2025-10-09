package com.example.bookInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookInventory.entity.UserDet;

public interface UserDetRepository extends JpaRepository<UserDet, Integer>{

	boolean existsByUserId(Integer userId);

	UserDet findByUserId(Integer userId);

}
