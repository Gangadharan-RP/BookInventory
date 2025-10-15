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


import com.example.bookInventory.entity.Category;
import com.example.bookInventory.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping()
	public ResponseEntity<List<Category>> getAllCategory(){
		return ResponseEntity.ok(categoryService.getAllCategory());
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<Category> getCategoryByCatId(@PathVariable Integer catId){
		return ResponseEntity.ok(categoryService.getCategoryByCatId(catId));
	}
	
	@PostMapping("/post")
	public ResponseEntity<Map<String, String>> addCategory(@RequestBody Category category){
		Map<String, String> response = new LinkedHashMap<>();
		try {
				categoryService.getCategoryByCatId(category.getCatId());
				response.put("code", "ADDFAILS");
				response.put("message", "Category already exists");
				return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
			}
		
		catch(RuntimeException e) {
		}
		
		categoryService.addCategory(category);
		response.put("code", "POSTSUCCESS");
		response.put("message", "Category added successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/update/catdesc/{catId}")
	public ResponseEntity<Category> updateCatDescByCatId(@PathVariable Integer catId, @RequestBody Category category){
		return ResponseEntity.ok(categoryService.updateCatDescByCatId(catId, category.getCatDescription()));
	}
}
