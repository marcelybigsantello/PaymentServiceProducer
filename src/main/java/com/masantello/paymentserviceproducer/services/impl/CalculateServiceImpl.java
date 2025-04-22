package com.masantello.paymentserviceproducer.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masantello.paymentserviceproducer.models.Payment;
import com.masantello.paymentserviceproducer.services.CalculateService;

@Service
public class CalculateServiceImpl implements CalculateService {

	@Override
	public float calculateFinalPrice(Payment payment) {
		return Optional.ofNullable(payment)
				.map(Payment::getProducts)
				.map(products -> products.stream()
						.mapToDouble(product -> product.calculateTotalPrice())
						.sum())
				.orElse(0.0)
				.floatValue();
	}
}
