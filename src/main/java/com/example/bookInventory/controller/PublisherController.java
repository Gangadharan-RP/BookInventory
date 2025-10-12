package com.example.bookInventory.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookInventory.entity.Publisher;
import com.example.bookInventory.exception.PublisherNotFoundException;
import com.example.bookInventory.service.PublisherService;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

	@Autowired
	private PublisherService publisherService;
	
	@GetMapping()
	public ResponseEntity<List<Publisher>> getAllPublisher(){
		return ResponseEntity.ok(publisherService.getAllPublisher());
	}
	
	@GetMapping("/{publisherId}")
	public ResponseEntity<Publisher> getPublisherById(@PathVariable Integer publisherId){
		return ResponseEntity.ok(publisherService.getPublisherById(publisherId));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Publisher> getPublisherByName(@PathVariable String name){
		return ResponseEntity.ok(publisherService.getPublisherByName(name));
	}
	
	@GetMapping("/city/{city}")
	public ResponseEntity<List<Publisher>> getPublisherByCity(@PathVariable String city){
		return ResponseEntity.ok(publisherService.getPublisherByCity(city));
	}
	
	@GetMapping("/state/{stateCode}")
	public ResponseEntity<List<Publisher>> getPublisherByState(@PathVariable String stateCode){
		return ResponseEntity.ok(publisherService.getPublisherByState(stateCode));
	}
	
	@PostMapping("/post")
	public ResponseEntity<Map<String, String>> addPublisher(@RequestBody Publisher publisher){
		Map<String, String> response = new LinkedHashMap<>();
		try {
				publisherService.getPublisherById(publisher.getPublisherId());
				response.put("code", "ADDFAILS");
				response.put("message", "Publisher already exists");
				return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
			}
		
		catch(PublisherNotFoundException e) {
		}
		
		publisherService.addPublisher(publisher);
		response.put("code", "POSTSUCCESS");
		response.put("message", "Publisher added successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
	
	@PutMapping("/update/name/{publisherId}")
	public ResponseEntity<Publisher> updatePublisherNameById(@PathVariable Integer publisherId, @RequestBody String name){
		return ResponseEntity.ok(publisherService.updateNameById(publisherId, name));
	}
	
	@PutMapping("/update/city/{publisherId}")
	public ResponseEntity<Publisher> updatePublisherCityById(@PathVariable Integer publisherId, @RequestBody String city){
		return ResponseEntity.ok(publisherService.updateCityById(publisherId, city));
	}
	
	@PutMapping("/update/stateCode/{publisherId}")
	public ResponseEntity<Publisher> updatePublisherStateById(@PathVariable Integer publisherId, @RequestBody String stateCode){
		return ResponseEntity.ok(publisherService.updateStateById(publisherId, stateCode));
	}
}
