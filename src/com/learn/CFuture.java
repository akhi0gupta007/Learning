package com.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CFuture obj = new CFuture();
//		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> obj.getResult())
//				.thenApply(result -> obj.getResult2(result))
//				.thenAccept(result -> obj.getResultFinal(result));
//		System.out.println(cf.get());	
//		
//		CompletableFuture<String> completableFuture 
//		  = CompletableFuture.supplyAsync(() -> "Hello");
//		
//		CompletableFuture<String> future = completableFuture
//				  .thenApply(s -> s + " World");
//				 
//		System.out.println(future.get());
//		
//		System.out.println(completableFuture.get());
//		 
//		CompletableFuture<Void> future2 = completableFuture
//		  .thenRun(() -> System.out.println("Computation finished."));
//		 
//		System.out.println(future2.get());
		
		CompletableFuture<String> cf1 = new CompletableFuture<String>();
		cf1.complete(obj.getResult());
		
		CompletableFuture<String> cf2 = new CompletableFuture<String>();
		cf1.complete(obj.getResult2(""));
		
		List<CompletableFuture<String>> list = new ArrayList<>();
		list.add(cf1);
		list.add(cf2);

		CompletableFuture<Void> cfs = CompletableFuture.allOf(cf1,cf2);
		System.out.println("Waiting for join");
		CompletableFuture<List<String>> ints = cfs.thenApply(result -> list.stream().map(future -> future.join()).collect(Collectors.toList()));
		CompletableFuture<Long> finalResult = ints.thenApply(x -> x.stream().count());
		System.out.println(finalResult.get());
		//cfs.join();
		
	//	System.out.println(cfs.get());
		
		
	}

	String getResult() {
		try {
			//Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "done";
	}

	String getResult2(String result) {
		try {
			//Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result + "done2";
	}

	void getResultFinal(String result) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(result + "final");
	}

}
