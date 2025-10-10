package com.example.bookInventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookInventory.entity.BookCondition;
import com.example.bookInventory.repository.BookConditionRepository;
import com.example.bookInventory.service.BookConditionService;

@Service
public class BookConditionServiceImpl implements BookConditionService{
	
	@Autowired
	private BookConditionRepository bookConditionRepository;

	@Override
	public BookCondition getBookByRank(Integer ranks) {
		// TODO Auto-generated method stub
		return bookConditionRepository.getByRanks(ranks);
	}

	@Override
	public BookCondition addBookCondition(BookCondition bookCondition) {
		// TODO Auto-generated method stub
		return bookConditionRepository.save(bookCondition);
	}

	@Override
	public BookCondition updateFullDescByRank(Integer ranks, String fullDesc) {
		// TODO Auto-generated method stub
		BookCondition bookCondition = getBookByRank(ranks);
		bookCondition.setFullDesc(fullDesc);
		return bookConditionRepository.save(bookCondition);
	}

	@Override
	public BookCondition updateDescByRank(Integer ranks, String Desc) {
		// TODO Auto-generated method stub
		BookCondition bookCondition = getBookByRank(ranks);
		bookCondition.setDescription(Desc);
		return bookConditionRepository.save(bookCondition);
	}

	@Override
	public BookCondition updatePriceByRank(Integer ranks, Double price) {
		// TODO Auto-generated method stub
		BookCondition bookCondition = getBookByRank(ranks);
		bookCondition.setPrice(price);
		return bookConditionRepository.save(bookCondition);
	}

}
