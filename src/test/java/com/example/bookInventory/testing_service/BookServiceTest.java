package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.Book;
import com.example.bookInventory.service.BookService;

public class BookServiceTest {
	
	BookService bookService = mock(BookService.class);
	
	@Test
	void testAddBook() {
		Book book = new Book("123","Books","Nice Story",4,"1",2);
		when(bookService.addBook(book)).thenReturn(book);
		
		Book result = bookService.addBook(book);
		assertEquals("Books", result.getTitle());
		assertEquals("Nice Story", result.getDescription());
	}
	
	@Test
	void testGetBookByIsbn() {
		Book book = new Book("123","Sherlock","Detective",4,"1",2);
		when(bookService.getBookByIsbn("123")).thenReturn(book);
		
		Book result = bookService.getBookByIsbn("123");
		assertEquals("Sherlock", result.getTitle());
	}
	
	@Test 
	void testUpdateBookTitle(){
		Book book = new Book("123","Sherlock","Detective",4,"1",2);
		when(bookService.updateBookDescription("123","Detective")).thenReturn(book);
		
		Book result = bookService.updateBookDescription("123","Detective");
		assertEquals("Detective", result.getDescription());
	}
}
