package com.java.patterns.singelton;

public class ThreadSafeSingleton {
	private ThreadSafeSingleton() {

	}

	private volatile static ThreadSafeSingleton instance;

	public static ThreadSafeSingleton getInstance() {
		if (instance == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeSingleton();
				}
			}
		}
		return instance;

	}

}