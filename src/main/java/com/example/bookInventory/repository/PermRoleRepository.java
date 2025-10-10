package com.example.bookInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookInventory.entity.PermRole;

public interface PermRoleRepository extends JpaRepository<PermRole, Integer>{

	PermRole getByRoleNumber(Integer roleNumber);

}
