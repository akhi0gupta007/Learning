package com.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComparingConcepts {

	public static void main(String[] args) {
		int i = 10;
		byte b = 4;
		Integer wi = 56;
		float f = 3.12f;
		go(f);
		List<Employee> employes = Employee.createEmployes();
		Collections.sort(employes,(emp1,emp2)->
			emp1.getName().compareTo(emp1.getName())			
		);		
		
		System.out.println("Before: ");
		System.out.println(employes);
		Collections.sort(employes, (x, y) -> x.getAge()
				.compareTo(y.getAge()));
		System.out.println("After: ");
		System.out.println(employes);
		Collections.sort(employes, (x, y) -> y.getAge()
				.compareTo(x.getAge()));
		System.out.println("After: ");
		System.out.println(employes);

		Comparator<Employee> cmp = Comparator.comparing(e -> e.getAge());
		
		Collections.sort(employes, cmp);
		System.out.println(employes);
		
		Map<Integer,Employee> map = new HashMap<Integer, Employee>();
		employes.stream().forEach(emp -> map.put(emp.getAge(), emp));
		
		
		System.out.println("Result : "+ map.size());
		map.values().stream().sorted(cmp).forEach(emp -> System.out.println(emp));

		addThem(2, 4);
	}

	static void go(Object b) {
		System.out.println("int wrapper " + (Float) b);
	}

	public static int addThem(Integer x, int y) {
		System.out.println("int");
		return x + y;
	}

	// Overload the addThem method to add doubles instead of ints
	public static double addThem(double x, double y) {
		System.out.println("double");
		return x + y;
	}

}
