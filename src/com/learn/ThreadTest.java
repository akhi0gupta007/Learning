package com.learn;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
	final static ReentrantLock lock = new ReentrantLock();

	public void longMethod() {
		lock.lock();
		System.out.println("longMethod " + Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
			testMethod();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();
	}

	public void testMethod() {
		System.out.println("TestMethod waiting for lock " + Thread.currentThread().getName());
		lock.lock();
		System.out.println("TestMethod " + Thread.currentThread().getName());
		lock.unlock();
	}

	public static void main(String[] args) throws Exception {
		ThreadTest obj = new ThreadTest();

		Runnable r1 = () -> {
			obj.longMethod();
		};
		Runnable r2 = () -> {
			obj.testMethod();
		};
		new Thread(r1).start();

		Thread.sleep(1000);

		new Thread(r2).start();
	}

}
