package com.learn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Barriers {
	
	void counting(String region){
		try {
			System.out.println("Counting population of "+region);
			
			//Thread.sleep(2000);
			barrier.await();
			stillCounting();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
	void stillCounting(){
		System.out.println("Still counting "+Thread.currentThread().getName());
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		
	}
	Runnable th2 = new Runnable() {			
		@Override
		public void run() {
			result();
		}
	};
	final CyclicBarrier barrier = new CyclicBarrier(2, th2);
	void result(){
		System.out.println("Done");
	}
	
	
	public static void main(String[] args) {
		Barriers  obj = new Barriers();
		
	
		Runnable th1 = new Runnable() {			
			@Override
			public void run() {
			obj.counting(Thread.currentThread().getName());	
			}
		};
	
		new Thread(th1).start();
		//Thread.sleep(50);
		new Thread(th1).start();

	}

}
