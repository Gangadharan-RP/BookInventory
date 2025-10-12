package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.Inventory;

public interface InventoryService {
	Inventory getInventoryById(Integer inventoryId);
	Inventory addInventory(Inventory inventory);
	Inventory updatePurchasedById(Integer inventoryId, Integer purchased);
	List<Inventory> getAllInventory();
}
