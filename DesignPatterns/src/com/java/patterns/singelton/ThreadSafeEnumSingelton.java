package com.java.patterns.singelton;

public enum ThreadSafeEnumSingelton {
	Instance;
	public void doAction() {
		System.out.println("ThreadSafeEnumSingelton.enclosing_method()");
	}
}
