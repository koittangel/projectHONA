package com.koitt.hona.service;

import java.util.List;

import com.koitt.hona.model.Product;
import com.koitt.hona.model.ProductException;

public interface TypeService {
	
	// top만 선택하기...?
	//public Product selectType(String productType) throws ProductException;

	//public List<Product> selectType() throws ProductException;
	
	public List<Product> selectType(String productType) throws ProductException; 
}
