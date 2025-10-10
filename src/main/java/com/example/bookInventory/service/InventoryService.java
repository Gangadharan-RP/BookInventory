package com.example.bookInventory.service;

import com.example.bookInventory.entity.Inventory;

public interface InventoryService {
	Inventory getInventoryById(Integer inventoryId);
	Inventory addInventory(Inventory inventory);
	Inventory updatePurchasedById(Integer inventoryId, Integer purchased);
}
