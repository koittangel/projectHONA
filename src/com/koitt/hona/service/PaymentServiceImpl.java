package com.koitt.hona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koitt.hona.dao.PaymentDao;
import com.koitt.hona.model.Payment;
import com.koitt.hona.model.PaymentException;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentDao dao;
	
	public PaymentServiceImpl() {}
	
	@Override
	public Payment detail(String paymentNo) throws PaymentException {
		return dao.select(paymentNo);
	}

}
