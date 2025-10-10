package com.example.bookInventory.testing_service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.example.bookInventory.entity.Author;
import com.example.bookInventory.service.AuthorService;

public class AuthorServiceTest {
	
	AuthorService authorService = mock(AuthorService.class);
	
	@Test
	void testAddAuthor() {
		Author author = new Author(1L, "John", "Doe", "Y");
		when(authorService.addAuthor(author)).thenReturn(author);
		
		Author result = authorService.addAuthor(author);
		assertEquals("John", result.getFirstName());
		assertEquals("Doe", result.getLastName());
	}
	
	@Test
	void testGetAuthorById() {
		Author author = new Author(1L, "John", "Smith", "Y");
		when(authorService.getAuthorById(1L)).thenReturn(author);
		
		Author result = authorService.getAuthorById(1L);
		assertEquals("Smith", result.getLastName());
	}
	
	@Test
	void testUpdateAuthorLastName() {
		Author updatedAuthor = new Author(2L, "Carly", "Hampson", "Y");
		when(authorService.updateAuthorLastName(2L, "Hampson")).thenReturn(updatedAuthor);

		Author result = authorService.updateAuthorLastName(2L, "Hampson");
		assertNotNull(result);
		assertEquals("Hampson", result.getLastName());
		assertEquals("Carly", result.getFirstName());

	}
}
