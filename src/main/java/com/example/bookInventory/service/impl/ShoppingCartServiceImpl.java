package com.example.bookInventory.service.impl;

import java.util.List;

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
	public List<ShoppingCart> getAllShoppingCart(){
		return shoppingCartRepository.findAll();
	}
	
	@Override
	public ShoppingCart addCart(ShoppingCart shoppingCart) {
	return shoppingCartRepository.save(shoppingCart);
	}
	
	@Override
	public ShoppingCart getCartByUserId(Integer userId) {
		// TODO Auto-generated method stub
		ShoppingCart shoppingCart = shoppingCartRepository.getByUserId(userId);
		if(shoppingCart==null)
			throw new RuntimeException();
		return shoppingCart;
	}

	@Override
	public ShoppingCart updateIsbnByUserId(Integer userId, String isbn) {
		// TODO Auto-generated method stub
		ShoppingCart shoppingCart = getCartByUserId(userId);
		shoppingCart.setIsbn(isbn);
		return shoppingCartRepository.save(shoppingCart);
	}

}
