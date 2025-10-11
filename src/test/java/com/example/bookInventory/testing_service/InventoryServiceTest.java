package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.Inventory;
import com.example.bookInventory.service.InventoryService;

public class InventoryServiceTest {
	
	InventoryService inventoryService = mock(InventoryService.class);
	
	@Test
	void testGetInventoryById() {
		Inventory inventory = new Inventory(1,"123456",10,1);
		when(inventoryService.getInventoryById(1)).thenReturn(inventory);
		
		Inventory result = inventoryService.getInventoryById(1);
		assertEquals("123456", result.getIsbn());
	}
	
	@Test
	void testAddInventory() {
		Inventory inventory = new Inventory(1,"123456",10,1);
		when(inventoryService.addInventory(inventory)).thenReturn(inventory);
		
		Inventory result = inventoryService.addInventory(inventory);
		assertEquals(10, result.getRank());
	}
	
}
