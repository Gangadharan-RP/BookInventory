package com.example.bookInventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookInventory.entity.ShoppingCart;
import com.example.bookInventory.service.ShoppingCartService;

@RestController
@RequestMapping("/api/shoppingcart")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<ShoppingCart> getCartByUserId(@PathVariable Integer userId){
		return ResponseEntity.ok(shoppingCartService.getCartByUserId(userId));
	}
	
	@PutMapping("/update/isbn/{userId}")
	public ResponseEntity<ShoppingCart> updateIsbnByUserId(@PathVariable Integer userId, @RequestBody String isbn){
		return ResponseEntity.ok(shoppingCartService.updateIsbnByUserId(userId, isbn));
	}
}
