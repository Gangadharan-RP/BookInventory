package com.example.bookInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookInventory.entity.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer>{

	boolean existsByUserId(Integer userId);

	UserDetail findByUserId(Integer userId);

}
