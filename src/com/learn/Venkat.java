package com.learn;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Venkat {

	public static void main(String[] args) {

		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1);

		num.stream()
				.map(String::valueOf) // parameter became an argument for method reference
				.forEach(System.out::print);

		num.stream()
				.map(String::valueOf)
				.map(String::toString) // parameter is target and method is instance method
				.forEach(System.out::println);

		num.stream()
				.reduce(0, (total, e) -> Integer.sum(total, e));
		
		//Infinite streams
		IntStream.iterate(50, elm -> elm+1)
		.limit(100)
		.forEach(System.out::print);;
		
		Stream.generate(() -> new Random().nextInt(100))
		.filter(x-> x% 2 ==0)
		.limit(20)
		.forEach(System.out::println);

		// T result = identity;
		// for (T element : this stream)
		// result = accumulator.apply(result, element)
		// return result;

		System.out.println(num.stream()
				.reduce(0, Integer::sum)); // Using method reference with two params

		System.out.println(num.stream()
				.map(String::valueOf)
				.reduce("", (carry, str) -> carry.concat(str)));

		System.out.println(num.stream()
				.map(String::valueOf)
				.reduce("", String::concat));

		// given the values, double the even numbers and total

		int result = 0;
		for (int e : num) {
			if (e % 2 == 0) {
				result += e * 2;
			}
		}

		System.out.println(result);

		// way 1
		Optional<Integer> result1 = num.stream()//
				.filter(e -> e % 2 == 0)//
				.map(e -> e * 2)//
				.reduce(Integer::sum);//

		// way 2

		System.out.println(num.stream()
				.filter(e -> e % 2 == 0)
				.mapToInt(e -> e * 2)
				.sum());

		System.out.println(num.stream()
				.filter(Venkat::isEven)
				.map(Venkat::doubleIt)
				.sorted()
				.distinct()
				.collect(Collectors.toList()));

		// infinite stream, can not exist without laziness

		System.out.println(Stream.iterate(100, e -> e + 3)
				.limit(120)
				.collect(Collectors.toList()));

		System.out.println(result1.get());

		// Given a number k, and count n, find the total of double of the n even number
		// starting with k, where square root of each number is > 20

		int k = 121;
		int n = 51;
		System.out.println(compute(k, n));

//		System.out.println(Employee.createEmployes()
//				.stream()
//				.filter(emp -> emp.getAge() > 20)
//				.map(Employee::getName)
//				.map(String::toUpperCase)
//				.collect(Collectors.toCollection(TreeSet::new)));

		//Note the third param in toMap function is mergeFunction, that will determine, which one of duplicates needed to put in map.
		System.out.println("Map...");
		System.out.println(Employee.createEmployes()
				.stream()
				.filter(emp -> emp.getAge() > 20)
				.collect(Collectors.toMap(Employee::getName, Employee::getAge,(a1, a2) -> a1)));

		// create comma seperated list (string) of age greater than 20

		String collect = Employee.createEmployes()
				.stream()
				.filter(emp -> emp.getAge() > 20)
				.map(Employee::getName)
				.collect(Collectors.joining(","));

		System.out.println(collect);

		// Grouping the result by collectors
		Map<Boolean, List<Employee>> resultMap = Employee.createEmployes()
				.stream()
				.collect(Collectors.partitioningBy(emp -> emp.getAge() > 20));

		System.out.println(resultMap);

		// Group the people based on their common name

		Map<String, List<Employee>> byName = Employee.createEmployes()
				.stream()
				.collect(Collectors.groupingBy(p -> p.getName()));

		System.out.println(byName);
		
		//Collector Mapping , if we want to customise  groupingBy

		Map<String, List<Integer>> ageByName = Employee.createEmployes()
				.stream()
				.collect(Collectors.groupingBy(p -> p.getName(),
						Collectors.mapping(Employee::getAge, Collectors.toList())));
		
		System.out.println(ageByName);
		
		//Count the number of occurences in groupingBy
		
		Map<String, Long> countByName = Employee.createEmployes()
				.stream()
				.collect(Collectors.groupingBy(Employee::getName,Collectors.counting()));

		System.out.println(countByName);

		

	}

	private static int compute(int k, int n) {
//		int result = 0;
//		int index = k;
//		int count = 0;
//		while (count < n) {
//			if (index % 2 == 0 && Math.sqrt(index) > 20) {
//				result += index * 2;
//				count++;
//			}
//
//			index++;
//		}
//
//		return result;

		// infinite stream, can not exist without laziness, the return type of lazy
		// function is always a Stream. Terminal function
		// such as sum, reduce, collect are not lazy, however return type of
		// intermediate function such as Map, filter are stream
		// We get efficiency by postponing the actual evaluation
		return Stream.iterate(k, e -> e + 1) // unbounded, lazy
				.filter(e -> e % 2 == 0) // unbounded, lazy
				.filter(e -> Math.sqrt(e) > 20)// unbounded, lazy
				.mapToInt(e -> e * 2) // unbounded, lazy
				.limit(n) // sized and lazy (no work is done :P)
				.sum(); // if there is no sum invocation, no work is done at all
	}

	public static boolean isEven(int num) {
		System.out.println("isEven");
		return num % 2 == 0 ? true : false;
	}

	public static int doubleIt(int num) {
		System.out.println("double it");
		return 2 * num;
	}

}