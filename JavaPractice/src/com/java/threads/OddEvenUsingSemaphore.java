package com.java.threads;

import java.util.concurrent.Semaphore;

public class OddEvenUsingSemaphore {
	public static void main(String[] args) throws InterruptedException {
		printOddEven();
	}

	static Semaphore s = new Semaphore(1);
	static Semaphore t = new Semaphore(0);

	private static void printOddEven() throws InterruptedException {
		int maxCount = 50;
		Runnable odd = () -> {
			int count = 1;
			try {
				while (count <= maxCount) {
					t.acquire();
					System.out.println("Odd : " + count);
					count += 2;
					s.release();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		};

		Runnable even = () -> {
			int count = 0;
			try {
				while (count <= maxCount) {
					s.acquire();
					System.out.println("Even : " + count);
					count += 2;
					t.release();
				}
			} catch (Exception e) {
			}
		};
		Thread t1 = new Thread(odd);
		Thread t2 = new Thread(even);
		t2.start();
		t1.start();
		t2.join();
	}
}
