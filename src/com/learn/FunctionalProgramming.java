package com.learn;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FunctionalProgramming {

	public static void main(String[] args) {
		System.out.println(isPrime(3));
		iterFun();
		threadFun();
	}

	public static boolean isPrime(final int number) {
		// Declarative
		return number > 1 && IntStream.range(2, number).noneMatch(index -> (number % index) == 0);
	}

	public static int doubleIt(final int number) {
		return number * 2;
	}

	public static int totals(List<Integer> values, Predicate<Integer> selector) {
		int result = 0;
		for (Integer elm : values) {
			if (selector.test(elm)) {
				result += elm;
			}
		}
		return result;
	}

	public static int totalsVariant(List<Integer> values, Predicate<Integer> selector) {
		int result = 0;
		result = values.stream().filter(selector).reduce(0, Math::addExact);

		return result;
	}

	public static int withoutParallelStream(List<Integer> values) {
		int result = 0;
		result = values.stream().mapToInt(FunctionalProgramming::doubleIt).sum();
		return result;
	}

	public static int withParallelStream(List<Integer> values) {
		int result = 0;
		result = values.parallelStream().mapToInt(FunctionalProgramming::doubleIt).sum();
		return result;
	}

	public static void iterFun() {
		List<Integer> values = Arrays.asList(10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 12, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3,
				4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8,
				9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		values.stream().map(String::valueOf).forEach(System.out::print);

		values.stream().map(num -> num.toString()).forEach(System.out::print);

		values.stream().map(String::valueOf).map(String::toString).forEach(System.out::print);

		Integer reduce = values.stream().reduce(0, (e, total) -> Integer.sum(e, total));

		System.out.println();
		System.out.println("Sum : " + reduce);

		Integer reduce1 = values.stream().reduce(0, Integer::sum);

		System.out.println();
		System.out.println("Sum 1: " + reduce1);

		System.out.println(values.stream().map(String::valueOf).reduce("", String::concat));

		System.out.println(values.stream().mapToInt(Integer::intValue).sum());

		Predicate<Integer> isGT3 = elm -> elm > 3;
		System.out.println("Total Variant : " + totalsVariant(values, isGT3));
		Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> number -> number > pivot;
		// lazy and composition
		Optional<Integer> findFirst = values.stream().filter(isGreaterThan.apply(3))
				.filter(FunctionalProgramming::isEven) // Higher-order functions
														// leads to lazy
														// evaluation
				.map(elm -> elm * 2).findFirst(); // Until this is called other
													// filters are not even
													// evaluated
		System.out.println(findFirst.get());
		long t0 = System.nanoTime();
		System.out.println(withoutParallelStream(values));
		long t1 = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("First Approach: %d ms", millis));
		t0 = System.nanoTime();
		;
		System.out.println(withParallelStream(values));
		t1 = System.nanoTime();
		millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("Second Approach: %d ms", millis));
	}

	public static boolean isEven(int num) {
		return (num % 2 == 0);
	}

	private static void threadFun() {
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Run Old" + Thread.currentThread().getName());
			}
		};
		new Thread(r1).start();
		new Thread((() -> System.out.println("Run " + Thread.currentThread().getName()))).start();

	}
}
