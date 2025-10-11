package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.PurchaseLog;
import com.example.bookInventory.service.PurchaseLogService;

public class PurchaseLogServiceTest {
	
	PurchaseLogService purchaseLogService = mock(PurchaseLogService.class);
	
	@Test
	void testAddPurchaseLog() {
		PurchaseLog purchaseLog = new PurchaseLog(1, 101);
		when(purchaseLogService.addLog(purchaseLog)).thenReturn(purchaseLog);
		
		PurchaseLog result = purchaseLogService.addLog(purchaseLog);
		assertEquals(101, result.getInventoryId());
	}
	
	@Test
	void testGetLogByUserId() {
		PurchaseLog purchaseLog = new PurchaseLog(1, 101);
		when(purchaseLogService.getLogByUserId(1)).thenReturn(purchaseLog);
		
		PurchaseLog result = purchaseLogService.getLogByUserId(1);
		assertEquals(101, result.getInventoryId());
	
	}
}
