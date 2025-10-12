package com.example.bookInventory.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.Author;
import com.example.bookInventory.entity.Book;
import com.example.bookInventory.entity.BookAuthor;
import com.example.bookInventory.exception.AuthorNotFoundException;
import com.example.bookInventory.repository.AuthorRepository;
import com.example.bookInventory.repository.BookAuthorRepository;
import com.example.bookInventory.repository.BookRepository;
import com.example.bookInventory.service.AuthorService;


@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookAuthorRepository bookAuthorRepository;

	@Override
	public Author addAuthor(Author author) {
		// TODO Auto-generated method stub
		return authorRepository.save(author);
	}

	@Override
	public Author getAuthorById(Long authorId) {
		// TODO Auto-generated method stub
		
		return authorRepository.findById(authorId)
				.orElseThrow(()-> new AuthorNotFoundException("Author Not Found"));
	}

	@Override
	public List<Author> getAuthorByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return authorRepository.findByFirstName(firstName);
	}

	@Override
	public List<Author> getAuthorByLastName(String lastName) {
		// TODO Auto-generated method stub
		return authorRepository.findByLastName(lastName);
	}

	@Override
	public Author updateAuthorFirstName(Long authorId, String firstName) {
		// TODO Auto-generated method stub
		Author author = getAuthorById(authorId);
		author.setFirstName(firstName);
		return authorRepository.save(author);
	}

	@Override
	public Author updateAuthorLastName(Long authorId, String lastName) {
		// TODO Auto-generated method stub
		Author author = getAuthorById(authorId);
		author.setLastName(lastName);
		return authorRepository.save(author);
	}

	@Override
	public List<Book> getBookByAuthorId(Long authorId) {
		// TODO Auto-generated method stub
		List<BookAuthor> bookAuthors = bookAuthorRepository.findByIdAuthorId(authorId);
		List<String> isbns = bookAuthors.stream()
				.map(ba -> ba.getId().getIsbn())
				.collect(Collectors.toList());
		return bookRepository.findAllById(isbns);
	}

	@Override
	public List<Author> getAuthors() {
		// TODO Auto-generated method stub
		return authorRepository.findAll();
	}
	
}
