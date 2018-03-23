package com.koitt.hona.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koitt.hona.dao.TypeDao;
import com.koitt.hona.model.Product;
import com.koitt.hona.model.ProductException;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {
	
	@Autowired
	private TypeDao dao;
	
	public TypeServiceImpl() {}

	@Override
	public List<Product> selectType(String productType) throws ProductException {
		return dao.selectType(productType);
	}

/*	@Override
	public List<Product> selectType() throws ProductException {
		return dao.selectType();
	}
*/

	
	


}
