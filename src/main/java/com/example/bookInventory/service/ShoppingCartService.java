package com.example.bookInventory.service;

import com.example.bookInventory.entity.ShoppingCart;

public interface ShoppingCartService {
	ShoppingCart getCartByUserId(Integer userId);
	ShoppingCart updateIsbnByUserId(Integer userId, String isbn);
}
