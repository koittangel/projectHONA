package com.koitt.hona.dao;

import java.util.List;

import com.koitt.hona.model.Product;
import com.koitt.hona.model.ProductException;

public interface TypeDao {
	
	// top만 선택하기..?
	public Product selectType(String productType) throws ProductException;
	
	//public List<Product> selectType() throws ProductException;

}
