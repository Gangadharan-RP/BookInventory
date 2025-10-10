package com.example.bookInventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/{ranks}")
	public ResponseEntity<BookCondition> getBookByRank(@PathVariable Integer ranks){
		return ResponseEntity.ok(bookConditionService.getBookByRank(ranks));
	}
	
	@PostMapping("/post")
	public ResponseEntity<BookCondition> addBookCondition(@RequestBody BookCondition bookCondition){
		return ResponseEntity.ok(bookConditionService.addBookCondition(bookCondition));
	}
	
	@PutMapping("/update/desc/{ranks}")
	public ResponseEntity<BookCondition> updateDescByRank(@PathVariable Integer ranks, @RequestBody String desc){
		return ResponseEntity.ok(bookConditionService.updateDescByRank(ranks, desc));
	}
	
	@PutMapping("/update/fulldesc/{ranks}")
	public ResponseEntity<BookCondition> updateFullDescByRank(@PathVariable Integer ranks, @RequestBody String fullDesc){
		return ResponseEntity.ok(bookConditionService.updateFullDescByRank(ranks, fullDesc));
	}
	
	@PutMapping("/update/price/{ranks}")
	public ResponseEntity<BookCondition> updatePriceByRank(@PathVariable Integer ranks, @RequestBody Double price){
		return ResponseEntity.ok(bookConditionService.updatePriceByRank(ranks, price));
	}
}
