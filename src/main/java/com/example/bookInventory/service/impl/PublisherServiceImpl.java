package com.example.bookInventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.Publisher;
import com.example.bookInventory.repository.PublisherRepository;
import com.example.bookInventory.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService{
	
	@Autowired
	private PublisherRepository publisherRepository;

	@Override
	public Publisher addPublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		return publisherRepository.save(publisher);
	}

	@Override
	public List<Publisher> getAllPublisher() {
		// TODO Auto-generated method stub
		return publisherRepository.findAll();
	}

	@Override
	public Publisher getPublisherById(Integer publisherId) {
		// TODO Auto-generated method stub
		return publisherRepository.getByPublisherId(publisherId);
	}

	@Override
	public Publisher getPublisherByName(String name) {
		// TODO Auto-generated method stub
		return publisherRepository.getByName(name);
	}

	@Override
	public List<Publisher> getPublisherByCity(String city) {
		// TODO Auto-generated method stub
		return publisherRepository.getByCity(city);
	}

	@Override
	public List<Publisher> getPublisherByState(String stateCode) {
		// TODO Auto-generated method stub
		return publisherRepository.getByStateCode(stateCode);
	}

	@Override
	public Publisher updateNameById(Integer publisherId, String name) {
		// TODO Auto-generated method stub
		Publisher publisher = getPublisherById(publisherId);
		publisher.setName(name);
		return publisherRepository.save(publisher);
	}

	@Override
	public Publisher updateCityById(Integer publisherId, String city) {
		// TODO Auto-generated method stub
		Publisher publisher = getPublisherById(publisherId);
		publisher.setCity(city);
		return publisherRepository.save(publisher);
	}

	@Override
	public Publisher updateStateById(Integer publisherId, String stateCode) {
		// TODO Auto-generated method stub
		Publisher publisher = getPublisherById(publisherId);
		publisher.setStateCode(stateCode);
		return publisherRepository.save(publisher);
	}

}
