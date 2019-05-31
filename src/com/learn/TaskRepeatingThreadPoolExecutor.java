package com.learn;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskRepeatingThreadPoolExecutor extends ThreadPoolExecutor {

	public TaskRepeatingThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}
	
	private static final AtomicInteger nextId = new AtomicInteger(0);
	private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(()->nextId.getAndIncrement());

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		this.submit(r);
	}
	
	public static void main(String[] args) throws Exception {
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
		Thread th1 = new Thread(() -> {
			Thread.currentThread().setName("Ramu");
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				System.out.println(Thread.currentThread().getName()+ " finished");
			}
		});

		Thread th2 = new Thread(() -> {
			Thread.currentThread().setName("Shyamu");
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				System.out.println(Thread.currentThread().getName()+ " finished");
			}
		});
		
		Thread th3 = new Thread(() -> {
			Thread.currentThread().setName("Radha");
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				System.out.println(Thread.currentThread().getName()+ " finished");
			}
		});
		
	//workQueue.add(th3);
//	workQueue.add(th2);
//		
		TaskRepeatingThreadPoolExecutor exec = new TaskRepeatingThreadPoolExecutor(5, 5, 60, TimeUnit.MINUTES, workQueue);
		exec.submit(th1);
//		exec.submit(th2);
//		exec.submit(th3);
//		exec.afterExecute(th1, null);
		
		
		
	}

}
