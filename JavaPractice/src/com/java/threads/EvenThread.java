package com.java.threads;

public class EvenThread implements Runnable {
	Object ob;

	public EvenThread(Object ob) {
		this.ob = ob;
	}

	int count = 0;

	@Override
	public void run() {
		synchronized (ob) {
			while (count <= 50) {
				try {

					System.out.println("Even : " + count);
					count += 2;
					ob.notify();
					ob.wait();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			ob.notifyAll();
		}
		
	}

}
