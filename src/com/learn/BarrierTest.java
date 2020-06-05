package com.learn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BarrierTest implements Runnable {

	public static CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("Done with all the threads"));

	@Override
	public void run() {
		doWork();
	}

	private void doWork() {
		System.out.println("start working " + Thread.currentThread().getId());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}

		System.out.println("Work is finished " + Thread.currentThread().getId());

	}

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(5);
		BarrierTest test = new BarrierTest();
		for (int i = 0; i < 5; i++) {
			service.execute(new Thread(test));
		}

		service.shutdown();
	}

}
