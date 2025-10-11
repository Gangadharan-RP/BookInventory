package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.Publisher;
import com.example.bookInventory.service.PublisherService;

public class PublisherServiceTest {
	
	PublisherService publisherService = mock(PublisherService.class);
	
	@Test
	void testAddPublisher() {
		Publisher publisher = new Publisher(101,"Deepak","Salem","TN");
		when(publisherService.addPublisher(publisher)).thenReturn(publisher);
		
		Publisher result = publisherService.addPublisher(publisher);
		assertEquals("Deepak", result.getName());
	}
	
	@Test
	void testGetPublisherById() {
		Publisher publisher = new Publisher(101,"Deepak","Salem","TN");
		when(publisherService.getPublisherById(101)).thenReturn(publisher);
		
		Publisher result = publisherService.getPublisherById(101);
		assertEquals("Salem", result.getCity());
	}
	
	@Test
	void testUpdateCityById() {
		Publisher publisher = new Publisher(101,"Deepak","Salem","TN");
		when(publisherService.updateCityById(101, "Salem")).thenReturn(publisher);
		
		Publisher result = publisherService.updateCityById(101, "Salem");
		assertEquals("Salem", result.getCity());
	}
}
