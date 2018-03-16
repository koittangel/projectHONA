package com.koitt.hona.service;

import java.util.List;

import com.koitt.hona.model.Product;
import com.koitt.hona.model.ProductException;

public interface ProductService {
	

	public Product detail(String productNo) throws ProductException;
	

	public List<Product> list() throws ProductException;
	

	public void add(Product product) throws ProductException;
	
	public String modify(Product product) throws ProductException;
	
	public String remove(String productNo) throws ProductException;
}
