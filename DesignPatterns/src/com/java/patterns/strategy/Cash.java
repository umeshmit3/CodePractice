package com.java.patterns.strategy;

public class Cash implements PaymentMethod{

	@Override
	public void pay(int bill) {
		System.out.println("Payment through cass done for Rs. " + bill);
		
	}

}
