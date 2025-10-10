package com.example.bookInventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookInventory.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer>{

	Publisher getByPublisherId(Integer publisherId);

	Publisher getByName(String name);

	List<Publisher> getByCity(String city);

	List<Publisher> getByStateCode(String stateCode);

}
