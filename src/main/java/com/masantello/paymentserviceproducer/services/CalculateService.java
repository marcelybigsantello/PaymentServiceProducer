package com.masantello.paymentserviceproducer.services;

import com.masantello.paymentserviceproducer.models.Payment;

public interface CalculateService {

	public float calculateFinalPrice(Payment payment);
}
