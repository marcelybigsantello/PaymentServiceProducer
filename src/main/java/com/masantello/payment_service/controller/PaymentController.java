package com.masantello.payment_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.masantello.payment_service.models.Payment;

public interface PaymentController {

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Payment> performPayment(@RequestBody Payment payment);
}
