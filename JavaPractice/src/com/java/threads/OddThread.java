package com.java.threads;

public class OddThread implements Runnable {
	Object ob;

	public OddThread(Object ob) {
		this.ob = ob;
	}

	int count = 1;

	@Override
	public void run() {
		synchronized (ob) {
			while (count < 50) {
				try {

					System.out.println("Odd : " + count);
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
