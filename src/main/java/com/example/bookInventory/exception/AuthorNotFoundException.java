package com.example.bookInventory.exception;

@SuppressWarnings("serial")
public class AuthorNotFoundException extends RuntimeException{
	public AuthorNotFoundException(String message) {
        super(message);
    }
}
