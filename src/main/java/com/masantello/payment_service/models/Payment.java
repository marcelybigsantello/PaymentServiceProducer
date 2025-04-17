package com.masantello.payment_service.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Payment implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private User user;
	private List<Product> products;
	private Float finalPrice;
	private String cardNumber;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
	private LocalDateTime paymentDate;

	public Payment() {

	}

	public Payment(Long id, User user, Float finalPrice, String cardNumber, LocalDateTime paymentDate) {
		this.id = id;
		this.user = user;
		this.finalPrice = finalPrice;
		this.cardNumber = cardNumber;
		this.paymentDate = paymentDate;
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public Float getFinalPrice() {
		return finalPrice;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	
}
