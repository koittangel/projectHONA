package com.koitt.hona.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koitt.hona.dao.ProductDao;
import com.koitt.hona.model.Product;
import com.koitt.hona.model.ProductException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao dao;
	
	public ProductServiceImpl() {}
	
	@Override
	public List<Product> list() throws ProductException {
		return dao.selectAll();
	}
	
	@Override
	public Product detail(String productNo) throws ProductException {
		return dao.select(productNo);
	}

	@Override
	public void add(Product product) throws ProductException {
		dao.insert(product);
	}

	@Override
	public String modify(Product product) throws ProductException {
		Product item = dao.select(product.getProductNo().toString());
		String filename = item.getAttachment();
		dao.update(product);
		
		return filename;
	}

	@Override
	public String remove(String productNo) throws ProductException {
		Product product = dao.select(productNo);
		String filename = product.getAttachment();
		
		dao.delete(productNo);
		
		return filename;
	}

}
