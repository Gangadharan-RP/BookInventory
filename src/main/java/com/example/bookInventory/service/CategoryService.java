package com.example.bookInventory.service;

import com.example.bookInventory.entity.Category;

public interface CategoryService {
	Category getCategoryByCatId(Integer catId);
	Category addCategory(Category category);
	Category updateCatDescByCatId(Integer catId, String catDesc);
}
