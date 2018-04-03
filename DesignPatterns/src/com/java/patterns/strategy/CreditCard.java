package com.java.patterns.strategy;

public class CreditCard extends Card {

	public CreditCard(String cardNo, int cvv, String expDate) {
		super(cardNo, cvv, expDate);
	}
	@Override
	public void pay(int bill){
		System.out.println("Payment done using credit card for Rs. " + bill);
	}

}
