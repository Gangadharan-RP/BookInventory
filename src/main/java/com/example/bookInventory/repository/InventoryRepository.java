package com.example.bookInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookInventory.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

	Inventory getByInventoryId(Integer inventoryId);

}
