package com.masantello.payment_service.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masantello.payment_service.controller.PaymentController;
import com.masantello.payment_service.models.Payment;
import com.masantello.payment_service.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentControllerImpl implements PaymentController {
	
	private final PaymentService paymentService;
	
	public PaymentControllerImpl(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@Override
	public ResponseEntity<Payment> performPayment(Payment payment) {
		try {
			paymentService.processPayment(payment);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	
}
