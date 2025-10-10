package com.example.bookInventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookInventory.entity.Inventory;
import com.example.bookInventory.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/{inventoryId}")
	public ResponseEntity<Inventory> getInventoryById(@PathVariable Integer inventoryId){
		return ResponseEntity.ok(inventoryService.getInventoryById(inventoryId));
	}
	
	@PostMapping("/post")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory){
		return ResponseEntity.ok(inventoryService.addInventory(inventory));
	}
	
	@PutMapping("/update/purchased/{inventoryId}")
	public ResponseEntity<Inventory> updatePurchasedById(@PathVariable Integer inventoryId, @RequestBody Integer purchased){
		return ResponseEntity.ok(inventoryService.updatePurchasedById(inventoryId, purchased));
	}
}
