package com.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionTest {

	static List<Employee> employess = new ArrayList<Employee>();
	
	static{
		employess.add(new Employee(10, "Akhi","Gupta"));
		employess.add(new Employee(1, "Pawan","Mishra"));
		employess.add(new Employee(3, "Hitesh","Garg"));
	}
	
	public static void main(String[] args) {
		
		System.out.println(employess);
		Collections.sort(employess, (e1,e2)->e1.getId().compareTo(e2.getId()));
		System.out.println(employess);
		Collections.sort(employess,(e1,e2)-> e1.getName().compareTo(e2.getName()));
		System.out.println(employess);
		
		//Another way
		Comparator<Employee> cmp = Comparator.comparing(e->e.getId());
		Collections.sort(employess,cmp);
		System.out.println(employess);
		
		
		//Reverse order
		Comparator<Employee> revcmp = Comparator.comparing(e->e.getId());
		Collections.sort(employess,revcmp.reversed());
		System.out.println(employess);
		
		//Sort on multiple fields – thenComparing()
		Comparator<Employee> multipleCmp = Comparator.comparing(e->e.getLastName());
		multipleCmp.thenComparing(e->e.getName());
		
		
		//Parallel Sorting, if collection is big then multiple threads are used
		Employee[] employeesArray = employess.toArray(new Employee[employess.size()]);
		Arrays.parallelSort(employeesArray, multipleCmp);
		System.out.println(employess); 
		
		//old way
		employess.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
			
		});
	}

}
