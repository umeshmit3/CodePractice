package com.java.patterns.strategy;

public class Card implements PaymentMethod {
	private String cardNo;
	private int cvv;
	private String expDate;
	
	public Card(String cardNo, int cvv, String expDate) {
		this.cardNo = cardNo;
		this.cvv = cvv;
		this.expDate = expDate;
	}

	@Override
	public void pay(int bill) {
		System.out.println("Bill Payed for Rs. "+bill);
	}

}
