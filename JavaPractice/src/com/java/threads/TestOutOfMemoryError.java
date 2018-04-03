package com.java.threads;

import java.util.ArrayList;

public class TestOutOfMemoryError {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 10000; i++) {
			try {
				array.add(new ArrayList<Integer>(1000000));
			} catch (StackOverflowError | OutOfMemoryError e2) {
				System.out.println(i+" : "+e2.getMessage());
				break;
			}
		}
	}
}
