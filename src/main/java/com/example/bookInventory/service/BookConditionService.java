package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.BookCondition;

public interface BookConditionService {
	BookCondition getBookByRank(Integer ranks);
	BookCondition addBookCondition(BookCondition bookCondition);
	BookCondition updateFullDescByRank(Integer ranks, String fullDesc);
	BookCondition updateDescByRank(Integer ranks, String Desc);
	BookCondition updatePriceByRank(Integer rankss, Double price);
	List<BookCondition> getAllBookCondition();
}
