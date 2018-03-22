package com.koitt.hona.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koitt.hona.model.Product;
import com.koitt.hona.model.ProductException;

@Repository
public class TypeDaoImpl implements TypeDao {
	
	private static final String MAPPERS_NS = Product.class.getName();
	
	@Autowired
	private SqlSession session;
	
	public TypeDaoImpl() {}

/*	@Override
	public List<Product> selectType() throws ProductException {
		List<Product> list = null;
		
		try {
			list = session.selectList(MAPPERS_NS + ".selectType");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new ProductException(e.getMessage());
		}
		return list;
	}*/

	@Override
	public Product selectType(String productType) throws ProductException {
		Product product  = null;
		try {
			product = session.selectOne(MAPPERS_NS + ".select-top", productType);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new ProductException(e.getMessage());
		}		
		return product;
	}
	
	
	

}
