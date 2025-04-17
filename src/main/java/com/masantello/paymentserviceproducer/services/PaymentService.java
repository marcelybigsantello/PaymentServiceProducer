package com.masantello.paymentserviceproducer.services;

import com.masantello.paymentserviceproducer.models.Payment;

public interface PaymentService {
	
	public void processPayment(Payment payment) throws InterruptedException;

}
