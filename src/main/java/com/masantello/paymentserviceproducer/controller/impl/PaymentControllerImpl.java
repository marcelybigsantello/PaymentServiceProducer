package com.masantello.paymentserviceproducer.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masantello.paymentserviceproducer.controller.PaymentController;
import com.masantello.paymentserviceproducer.models.Payment;
import com.masantello.paymentserviceproducer.services.PaymentService;

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
