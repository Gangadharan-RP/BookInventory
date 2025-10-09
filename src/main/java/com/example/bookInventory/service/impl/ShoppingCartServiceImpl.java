package com.example.bookInventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.ShoppingCart;
import com.example.bookInventory.repository.ShoppingCartRepository;
import com.example.bookInventory.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Override
	public ShoppingCart getCartByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return shoppingCartRepository.getByUserId(userId);
	}

	@Override
	public ShoppingCart updateIsbnByUserId(Integer userId, String isbn) {
		// TODO Auto-generated method stub
		ShoppingCart shoppingCart = getCartByUserId(userId);
		shoppingCart.setIsbn(isbn);
		return shoppingCartRepository.save(shoppingCart);
	}

}
