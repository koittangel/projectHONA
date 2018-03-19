package com.koitt.hona.dao;

import java.util.List;

import com.koitt.hona.model.Product;
import com.koitt.hona.model.ProductException;

public interface ProductDao {

	public Product select(String producNo) throws ProductException;
	
	public List<Product> selectAll() throws ProductException;
	
	public void insert(Product product) throws ProductException;

	public void update(Product product) throws ProductException;
	
	public void delete(String productNo) throws ProductException;
}
