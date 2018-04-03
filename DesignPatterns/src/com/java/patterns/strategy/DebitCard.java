package com.java.patterns.strategy;

public class DebitCard extends Card {

	public DebitCard(String cardNo, int cvv, String expDate) {
		super(cardNo, cvv, expDate);
	}

	@Override
	public void pay(int bill) {
		System.out.println("Payment done using debit card for Rs. " + bill);
	}

}
