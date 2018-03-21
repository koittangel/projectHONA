package com.koitt.hona.dao;

import com.koitt.hona.model.Payment;
import com.koitt.hona.model.PaymentException;

public interface PaymentDao {

	// 주문번호를 이용하여 주문 하나 불러와 결제하기
	public Payment select(String paymentNo) throws PaymentException;
}
