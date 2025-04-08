package com.masantello.payment_service.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.masantello.payment_service.models.Payment;
import com.masantello.payment_service.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	private static final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);

	private final KafkaTemplate<String, String> kafkaTemplate;

	private final String topicName = "teste";

	public PaymentServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public void processPayment(Payment payment) {
		log.info("Processing payment ID={}, from User={}, at Date={}", payment.getId(),
				payment.getIdUser(), payment.getPaymentDate());
		kafkaTemplate.send(topicName, payment.toString());
		
	}

}
