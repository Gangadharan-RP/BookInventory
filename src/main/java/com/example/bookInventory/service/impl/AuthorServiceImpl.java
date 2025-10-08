package com.example.bookInventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.Author;
import com.example.bookInventory.repository.AuthorRepository;
import com.example.bookInventory.service.AuthorService;


@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
//	@Autowired
//	private BookRepository bookRepository;

	@Override
	public Author addAuthor(Author author) {
		// TODO Auto-generated method stub
		if(authorRepository.existsById(author.getAuthorId()))
		{
			throw new RuntimeException("Author Already Exists");
		}
		
		return authorRepository.save(author);
	}

	@Override
	public Author getAuthorById(Long authorId) {
		// TODO Auto-generated method stub
		
		return authorRepository.findById(authorId)
				.orElseThrow(()-> new RuntimeException("Author Not Found"));
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
	public List<Author> getBookByAuthorId(Long authorId) {
		// TODO Auto-generated method stub
		return null;
		//return bookRepository.findBookByAuthorId(authorId);
	}

	@Override
	public List<Author> getAuthors() {
		// TODO Auto-generated method stub
		return authorRepository.findAll();
	}
	
}
