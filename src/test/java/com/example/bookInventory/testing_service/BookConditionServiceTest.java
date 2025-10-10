package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.BookCondition;
import com.example.bookInventory.service.BookConditionService;

public class BookConditionServiceTest {

	BookConditionService bookConditionService = mock(BookConditionService.class);
	
	@Test
	void testGetBookByRank() {
		BookCondition bookCondition = new BookCondition(1, "Good", "Good Book", 100.0);
		when(bookConditionService.getBookByRank(1)).thenReturn(bookCondition);
		
		BookCondition result = bookConditionService.getBookByRank(1);
		assertEquals("Good", result.getDescription());
	}
	
	@Test
	void testAddBookCondition() {
		BookCondition bookCondition = new BookCondition(1, "Good", "Good Book", 100.0);
		when(bookConditionService.addBookCondition(bookCondition)).thenReturn(bookCondition);
		
		BookCondition result = bookConditionService.addBookCondition(bookCondition);
		assertEquals("Good Book", result.getFullDesc());
	}
	
	@Test
	void testUpdateDescByRank() {
		BookCondition bookCondition = new BookCondition(1, "Good", "Good Book", 100.0);
		when(bookConditionService.updateDescByRank(123, "Good")).thenReturn(bookCondition);
		
		BookCondition result = bookConditionService.updateDescByRank(123, "Good");
		assertEquals("Good", result.getDescription());
	}
}
