package com.learn;

public class Notify {

	public String lock = "LOCK";
	void execute(){
		System.out.println("waiting for lock");
		synchronized (this) {
			System.out.println(Thread.currentThread().getId());
			System.out.println("Going for work");
			try {
				Thread.sleep(10000);
				this.notify();
				System.out.println("Done");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		void executeResult(){
			synchronized (this) {
				System.out.println(Thread.currentThread().getId());
				System.out.println("waiting for Result");
				try {
					this.wait();
					System.out.println("executeResult after wait");									
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	
	public static void main(String[] args) throws Exception {
		Notify obj = new Notify();
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
		Thread.sleep(500);
		new Thread(th1).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}).start();
		
		new Thread(()->System.out.println("executeResult after wait"+Thread.currentThread().getName())).start();
	}
	


}
