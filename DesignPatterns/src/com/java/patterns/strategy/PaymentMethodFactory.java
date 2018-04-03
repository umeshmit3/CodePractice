package com.java.patterns.strategy;

public class PaymentMethodFactory {

	public PaymentMethod getPaymentMethod(String paymentMethod) {
		switch (paymentMethod) {
		case "cash":
			return createCashPayment();
		case "creditcard":
			return createCreditCard();
		case "debitcard":
			return createDebitCard();
		default:
			System.out.println("Invalid payment method");
			return null;
		}
	}

	private PaymentMethod createDebitCard() {
		return new DebitCard("124635", 122, "10/23");
	}

	private PaymentMethod createCashPayment() {

		return new Cash();
	}

	private PaymentMethod createCreditCard() {
		return new CreditCard("2618734", 128, "11/23");
	}
}
