package com.koitt.hona.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koitt.hona.model.Payment;
import com.koitt.hona.model.PaymentException;

@Repository
public class PaymentDaoImpl implements PaymentDao{
	
	private static final String MAPPER_NS = Payment.class.getName();
	
	@Autowired
	private SqlSession session;
	
	public PaymentDaoImpl() {}

	@Override
	public Payment select(String paymentNo) throws PaymentException {
		Payment payment = null;
		
		try {
			payment = session.selectOne(MAPPER_NS + ".select-payment", paymentNo);
			
		} catch (Exception e) { 
			System.out.println(e.getMessage());
			throw new PaymentException(e.getMessage());
		}
		return payment;
	}

}
