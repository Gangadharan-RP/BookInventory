package com.example.bookInventory.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	@GetMapping()
	public ResponseEntity<List<Inventory>> getAllInventory(){
		return ResponseEntity.ok(inventoryService.getAllInventory());
	}
	
	@GetMapping("/{inventoryId}")
	public ResponseEntity<Inventory> getInventoryById(@PathVariable Integer inventoryId){
		return ResponseEntity.ok(inventoryService.getInventoryById(inventoryId));
	}
	
	@PostMapping("/post")
	public ResponseEntity<Map<String, String>> addInventory(@RequestBody Inventory inventory){
		Map<String, String> response = new LinkedHashMap<>();
		try {
				inventoryService.getInventoryById(inventory.getInventoryId());
				response.put("code", "ADDFAILS");
				response.put("message", "Inventory already exists");
				return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
			}
		
		catch(RuntimeException e) {
		}
		
		inventoryService.addInventory(inventory);
		response.put("code", "POSTSUCCESS");
		response.put("message", "Inventory added successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/update/purchased/{inventoryId}")
	public ResponseEntity<Inventory> updatePurchasedById(@PathVariable Integer inventoryId, @RequestBody Integer purchased){
		return ResponseEntity.ok(inventoryService.updatePurchasedById(inventoryId, purchased));
	}
}
