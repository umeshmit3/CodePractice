package com.java.threads;

public class OddEvenThread {

	public static void main(String[] args) throws InterruptedException {
	
		printOddEven();
	}

	private static void printOddEven() throws InterruptedException {
		Object ob = new Object();
		Thread odd = new Thread(new OddThread(ob));
		Thread even = new Thread(new EvenThread(ob));
		even.start();
		odd.start();
		even.join();
		System.out.println("Done");
	}
	
	
}
