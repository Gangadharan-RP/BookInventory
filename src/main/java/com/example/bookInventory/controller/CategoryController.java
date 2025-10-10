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

import com.example.bookInventory.entity.Category;
import com.example.bookInventory.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/{catId}")
	public ResponseEntity<Category> getCategoryByCatId(@PathVariable Integer catId){
		return ResponseEntity.ok(categoryService.getCategoryByCatId(catId));
	}
	
	@PostMapping("/post")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		return ResponseEntity.ok(categoryService.addCategory(category));
	}
	
	@PutMapping("/update/catdesc/{catId}")
	public ResponseEntity<Category> updateCatDescByCatId(@PathVariable Integer catId, @RequestBody String catDesc){
		return ResponseEntity.ok(categoryService.updateCatDescByCatId(catId, catDesc));
	}
}
