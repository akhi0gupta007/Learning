package com.learn;

import java.util.ArrayList;
import java.util.Random;

public class MemoryLeaks {

	private Random random = new Random();
	public static final ArrayList<Double> list = new ArrayList<Double>(1000000);

	public void givenStaticField_whenLotsOfOperations_thenMemoryLeak() throws InterruptedException {
		for (int i = 0; i < 1000000; i++) {
			list.add(random.nextDouble());
		}

		System.gc();
		Thread.sleep(10000); // to allow GC do its job
	}
	
	public static void main(String[] args) {
		try {
			while(true){
				new MemoryLeaks().givenStaticField_whenLotsOfOperations_thenMemoryLeak();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
