package com.koitt.hona.service;

import com.koitt.hona.model.Payment;
import com.koitt.hona.model.PaymentException;

public interface PaymentService {

	// 주문 번호를 이용하여 주문을 불러와 결제하기
	public Payment detail(String paymentNo) throws PaymentException;
}
