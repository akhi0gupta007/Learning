package com.learn;

import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {

	WorkerThread[] workers;
	LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();

	public CustomThreadPool(int size) {
		workers = new WorkerThread[size];
		for(int i = 0; i < size;i++) {
			workers[i] = new WorkerThread();
			workers[i].start();
		}
	}

	public void addTask(Runnable runnable) {
		synchronized (queue) {
			queue.add(runnable);
			queue.notify();
		}
	}

	private class WorkerThread extends Thread {

		@Override
		public void run() {
			Runnable task;
			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							System.out.println("Thread with id "+Thread.currentThread().getId()+" is waiting for work");
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					task = queue.poll();

				}
				System.out.println("Thread with id "+Thread.currentThread().getId()+" will run task now");
				task.run();
			}

		}

	}
	
	public static void main(String[] args) {
		CustomThreadPool pool = new CustomThreadPool(10);
		Runnable task = () -> {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		for(int i = 0 ; i < 50;i++) {
			pool.addTask(task);
		}
	}

}
