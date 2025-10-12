package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.ShoppingCart;

public interface ShoppingCartService {
	ShoppingCart getCartByUserId(Integer userId);
	ShoppingCart updateIsbnByUserId(Integer userId, String isbn);
	ShoppingCart addCart(ShoppingCart shoppingCart);
	List<ShoppingCart> getAllShoppingCart();
}
