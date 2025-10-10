package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.Publisher;

public interface PublisherService {
	Publisher addPublisher(Publisher publisher);
	List<Publisher> getAllPublisher();
	Publisher getPublisherById(Integer publisherId);
	Publisher getPublisherByName(String name);
	List<Publisher> getPublisherByCity(String city);
	List<Publisher> getPublisherByState(String stateCode);
	Publisher updateNameById(Integer publisherId, String name);
	Publisher updateCityById(Integer publisherId, String city);
	Publisher updateStateById(Integer publisherId, String stateCode);
}
