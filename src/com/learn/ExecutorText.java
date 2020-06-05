package com.learn;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorText implements Runnable{

	private boolean throwException ;
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		for(int i = 0; i < 4;i++) {
			
			if(i==1)
				service.execute(new ExecutorText(true));
			else
				service.execute(new ExecutorText(false));
					
		}
		service.execute(new ExecutorText(false));
		
		
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 1";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		    	System.out.println("Task 2...");
		        return "Task 2";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		    	System.out.println("Task 3...");
		        return "Task 3";
		    }
		});

		String result = null;
		try {
			result = executorService.invokeAny(callables);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("result = " + result);
		executorService.shutdown();
		service.shutdown();
		try {
			service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ExecutorText(boolean throwException) {
		super();
		this.throwException = throwException;
	}

	public boolean isThrowException() {
		return throwException;
	}

	public void setThrowException(boolean throwException) {
		this.throwException = throwException;
	}

	@Override
	public void run() {
		System.out.println("start working " + Thread.currentThread().getId());
		if(throwException) {
			throw new RuntimeException();
		}else {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Work is finished " + Thread.currentThread().getId());
	}
	
	

}
