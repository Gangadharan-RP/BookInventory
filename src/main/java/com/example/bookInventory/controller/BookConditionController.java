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

import com.example.bookInventory.entity.BookCondition;
import com.example.bookInventory.service.BookConditionService;

@RestController
@RequestMapping("/api/bookcondition")
public class BookConditionController {

	@Autowired
	private BookConditionService bookConditionService;
	
	@GetMapping()
	public ResponseEntity<List<BookCondition>> getAllBookCondition(){
		return ResponseEntity.ok(bookConditionService.getAllBookCondition());
	}
	
	@GetMapping("/{ranks}")
	public ResponseEntity<BookCondition> getBookByRank(@PathVariable Integer ranks){
		return ResponseEntity.ok(bookConditionService.getBookByRank(ranks));
	}
	
	@PostMapping("/post")
	public ResponseEntity<Map<String, String>> addBookCondition(@RequestBody BookCondition bookCondition){
		Map<String, String> response = new LinkedHashMap<>();
		try {

				bookConditionService.getBookByRank(bookCondition.getRanks());
				response.put("code", "ADDFAILS");
				response.put("message", "Book Condition already exists");
				return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
			}
		
		catch(RuntimeException e) {
		}
		
		bookConditionService.addBookCondition(bookCondition);
		response.put("code", "POSTSUCCESS");
		response.put("message", "Book Condition added successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/update/desc/{ranks}")
	public ResponseEntity<BookCondition> updateDescByRank(@PathVariable Integer ranks, @RequestBody BookCondition bookCondition){
		return ResponseEntity.ok(bookConditionService.updateDescByRank(ranks, bookCondition.getDescription()));
	}
	
	@PutMapping("/update/fulldesc/{ranks}")
	public ResponseEntity<BookCondition> updateFullDescByRank(@PathVariable Integer ranks, @RequestBody BookCondition bookCondition){
		return ResponseEntity.ok(bookConditionService.updateFullDescByRank(ranks, bookCondition.getFullDesc()));
	}
	
	@PutMapping("/update/price/{ranks}")
	public ResponseEntity<BookCondition> updatePriceByRank(@PathVariable Integer ranks, @RequestBody BookCondition bookCondition){
		return ResponseEntity.ok(bookConditionService.updatePriceByRank(ranks, bookCondition.getPrice()));
	}
}
