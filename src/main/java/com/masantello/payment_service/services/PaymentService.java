package com.masantello.payment_service.services;

import com.masantello.payment_service.models.Payment;

public interface PaymentService {
	
	public void processPayment(Payment payment);

}
