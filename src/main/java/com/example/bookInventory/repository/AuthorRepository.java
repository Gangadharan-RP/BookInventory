package com.example.bookInventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookInventory.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	List<Author> findByFirstName(String firstName);

	List<Author> findByLastName(String lastName);

}
