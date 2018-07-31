package com.learn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyLocks {

	public Lock lock = new ReentrantLock();
	int counter = 0;
	void execute(){
		System.out.println("execute waiting for lock" + Thread.currentThread().getId());
		
			System.out.println();
			System.out.println("execute Going for work\n");
			try {
			lock.lock();
				while(counter<=150){
					counter++;
					System.out.println("["+counter+"]");
				}				
				System.out.println("execute Done");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
			lock.unlock();
			}
		
	}
		void executeResult(){
			lock.lock();
				System.out.println();
				System.out.println("executeResult waiting for Result"+Thread.currentThread().getId());
				try {				
					while(counter<=100){
						counter++;
						System.out.println("executeResult <"+counter+">");
					}
					System.out.println("executeResult after wait");									
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					lock.unlock();
				}			
			
	}
	
	
	public static void main(String[] args) throws Exception {
		NotifyLocks obj = new NotifyLocks();
		Runnable th1 = new Runnable() {			
			@Override
			public void run() {
				obj.execute();
			}
		};
		Runnable th2 = new Runnable() {			
			@Override
			public void run() {
				obj.executeResult();
			}
		};
		new Thread(th2).start();
		//Thread.sleep(50);
		new Thread(th1).start();
		
	}

}
