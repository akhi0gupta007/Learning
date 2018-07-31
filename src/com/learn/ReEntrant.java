package com.learn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrant {
	
	public Lock lock = new ReentrantLock();
	Condition cond = lock.newCondition();
	
	void execute() throws InterruptedException{
		System.out.println("execute waiting for lock Thread : " + Thread.currentThread().getId());
		
			try {
			lock.lock();
						
				System.out.println("execute got lock, waiting() Thread : " + Thread.currentThread().getId());
				
				cond.await();
				System.out.println("Woke Up Thread : " + Thread.currentThread().getId());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				//Thread.sleep(10000);
				doExecute();
			lock.unlock();
			
			}
			System.out.println("lock release going for sleep Thread : " + Thread.currentThread().getId());
		
	
	}
	private void doExecute() {
		System.out.println("doexecute waiting for lock  Thread :" + Thread.currentThread().getId());
		try {
		lock.lock();				
		System.out.println("doexecute got lock Thread : " + Thread.currentThread().getId());
		cond.signal();
		System.out.println("doexecute signal sent Thread : " + Thread.currentThread().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();		
		}
		
	}
	public static void main(String[] args) throws Exception {
		ReEntrant obj = new ReEntrant();
		Runnable th1 = new Runnable() {			
			@Override
			public void run() {
				try {
					obj.execute();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Runnable th2 = new Runnable() {			
			@Override
			public void run() {
				obj.doExecute();
			}
		};
		new Thread(th1).start();
		//Thread.sleep(50);
		new Thread(th2).start();

	}

}
