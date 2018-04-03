package com.java.patterns.strategy;

public class MakePayment {
	public static void initiatePaymment() {
		PaymentMethodFactory factory = new PaymentMethodFactory();
		PaymentMethod paymentMethod = factory.getPaymentMethod("debitcard");
		paymentMethod.pay(100);
	}
	
	public static void main(String[] args) {
		initiatePaymment();
	}

}
