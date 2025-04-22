package com.masantello.paymentserviceproducer.services.impl;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.masantello.paymentserviceproducer.models.Payment;
import com.masantello.paymentserviceproducer.services.CalculateService;
import com.masantello.paymentserviceproducer.services.PaymentService;
import com.masantello.paymentserviceproducer.utils.Formatter;

@Service
public class PaymentServiceImpl implements PaymentService {

	private static final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);

	private final KafkaTemplate<String, Serializable> kafkaTemplate;
	private final CalculateService calculateService;

	private final String topicName = "Valid.Payments";

	public PaymentServiceImpl(KafkaTemplate<String, Serializable> kafkaTemplate,
			CalculateService calculateService) {
		this.kafkaTemplate = kafkaTemplate;
		this.calculateService = calculateService;
	}

	@Override
	public void processPayment(Payment payment) throws InterruptedException {
		payment.setPaymentDate(LocalDateTime.now());
		payment.setFinalPrice(calculateService.calculateFinalPrice(payment));
		log.info("Processing payment ID={}, from User={}, Final Price={}, at Date={}", 
				payment.getId(), payment.getUser().getUserName(),
				Formatter.formatPrice(payment.getFinalPrice()),
				Formatter.formatDateTime(payment.getPaymentDate()));
		Thread.sleep(1000);
		
		log.info("Sending payment to topic {}", topicName);
		kafkaTemplate.send(topicName, payment);
		
	}

}
