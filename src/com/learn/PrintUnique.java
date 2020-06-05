package com.learn;

public class PrintUnique implements Runnable {

	int id;
	ThreadLocal<Integer> th;
	static int allowedThread = 1;

	final String lock = "LOCK";

	public static void main(String[] args) throws Exception {
		int id = 1;
		Thread th1 = new Thread(new PrintUnique(id));
		id++;
		Thread th2 = new Thread(new PrintUnique(id));
		id++;
		Thread th3 = new Thread(new PrintUnique(id));
		th1.start();
		th2.start();
		th3.start();

	}

	@Override
	public void run() {
		th = ThreadLocal.withInitial(() ->
			{
				if (id == 1) {
					return 1;
				} else if (id == 2) {
					return 2;
				} else {
					return 3;
				}
			});

		while (true) {
			printValue();
		}
	}

	public void printValue() {
		try {
			
			synchronized (lock) {
				while (allowedThread != id) {
					lock.wait();
				}

				System.out.println("id : " + id + ", val: " + th.get());
				th.set(th.get() + 3);
				Thread.sleep(1000);
				lock.notifyAll();
				++allowedThread;

				if (allowedThread > 3) {
					allowedThread = 1;
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public PrintUnique(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
