package com.learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStream {
	
	public static void main(String[] args) {
		
		
		int max = 10;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
		
		long t0 = System.nanoTime();

		long count = values.stream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("sequential sort took: %d ms", millis));
		
		long t01 = System.nanoTime();

		long count1 = values.parallelStream().sorted().count();
		System.out.println(count1);

		long t11 = System.nanoTime();

		long millis1 = TimeUnit.NANOSECONDS.toMillis(t11 - t01);
		System.out.println(String.format("parallel sort took: %d ms", millis1));
		
		Map<Integer,String> map = new HashMap<>();
		map.put(1,"Hello");
		map.put(2, "Greet");
		
		map.forEach((key,val)->System.out.println(key + ""+ val));
		map.computeIfPresent(1, (num,val)-> val.concat(" Friends"));
		map.forEach((key,val)->System.out.println(key + ""+ val));
		
		

	}

}
