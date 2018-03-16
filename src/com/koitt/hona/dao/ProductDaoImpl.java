package com.koitt.hona.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koitt.hona.model.Product;
import com.koitt.hona.model.ProductException;

@Repository
public class ProductDaoImpl implements ProductDao{

	private static final String MAPPER_NS = Product.class.getName();
	
	@Autowired
	private SqlSession session;
	
	public ProductDaoImpl() {}
	
	@Override
	public Product select(String productNo) throws ProductException {
		Product product = null;
		
		try {
			product = session.selectOne(MAPPER_NS + ".select-product", productNo);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new ProductException(e.getMessage());
		}
		
		return product;
	}
	
	@Override
	public List<Product> selectAll() throws ProductException {
		List<Product> list = null;
		
		try {
			list = session.selectList(MAPPER_NS + ".select-all-product");
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new ProductException(e.getMessage());
		
		}
		return list;
	}
	
	@Override
	public void insert(Product product) throws ProductException {
		try {
			session.insert(MAPPER_NS + ".insert-product", product);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new ProductException(e.getMessage());
		}
	}

	@Override
	public void updates(Product product) throws ProductException {
		try {
			session.update(MAPPER_NS + ".update-product", product);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new ProductException(e.getMessage());
		}
	}

	@Override
	public void delete(String productNo) throws ProductException {
		try {
			session.delete(MAPPER_NS + ".delete-product", productNo);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new ProductException(e.getMessage());
		}
	}
}
