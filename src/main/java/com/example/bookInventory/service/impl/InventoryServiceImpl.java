package com.example.bookInventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.Inventory;
import com.example.bookInventory.repository.InventoryRepository;
import com.example.bookInventory.service.InventoryService;


@Service
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Override
	public List<Inventory> getAllInventory(){
		return inventoryRepository.findAll();
	}

	@Override
	public Inventory getInventoryById(Integer inventoryId) {
		// TODO Auto-generated method stub
		Inventory inventory = inventoryRepository.getByInventoryId(inventoryId);
		if(inventory == null)
			throw new RuntimeException();
		return inventory;
	}

	@Override
	public Inventory addInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		return inventoryRepository.save(inventory);
	}

	@Override
	public Inventory updatePurchasedById(Integer inventoryId, Integer purchased) {
		// TODO Auto-generated method stub
		Inventory inventory = getInventoryById(inventoryId);
		inventory.setPurchased(purchased);
		return inventoryRepository.save(inventory);
	}

}
