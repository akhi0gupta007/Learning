package com.learn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Barriers implements Runnable {

	static class Target implements Runnable {

		@Override
		public void run() {
			System.out.println("Target reached...");
		}

	}

	ThreadLocal<Integer> th;
	CyclicBarrier barrier = new CyclicBarrier(3, new Barriers.Target());

	public static void main(String[] args) {

		Barriers bar = new Barriers();
		Thread th1 = new Thread(bar);
		Thread th2 = new Thread(bar);
		Thread th3 = new Thread(bar);
		th1.start();
		th2.start();
		th3.start();

	}

	@Override
	public void run() {
		th = ThreadLocal.withInitial(() ->
			{
				return 1;
			});

		while (true) {
			try {
				Integer i = th.get();
				System.out.println(Thread.currentThread().getId()+ " : "+i);
				th.set(++i);
				if (i % 5 == 0) {
					barrier.await();
				}
				Thread.sleep(1000);
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}

		}
	}

}
