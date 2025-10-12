package com.example.bookInventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.Category;
import com.example.bookInventory.repository.CategoryRepository;
import com.example.bookInventory.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryByCatId(Integer catId) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.getByCatId(catId);
		if(category==null)
			throw new RuntimeException();
		return category;
	}

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCatDescByCatId(Integer catId, String catDesc) {
		// TODO Auto-generated method stub
		Category category = getCategoryByCatId(catId);
		category.setCatDescription(catDesc);
		return categoryRepository.save(category);
	}

}
