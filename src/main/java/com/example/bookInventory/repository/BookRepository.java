package com.example.bookInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookInventory.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
