package com.java.patterns.singelton;

public class MainClasForTest {
	public static void main(String[] args) {
		testEnumSingelton();
	}

	private static void testEnumSingelton() {
		ThreadSafeEnumSingelton instance = ThreadSafeEnumSingelton.Instance;
		instance.doAction();
	}
}
