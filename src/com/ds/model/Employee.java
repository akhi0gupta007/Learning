package com.ds.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {

	private String firstName;
	private Integer age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Employee(String firstName, Integer age) {
		super();
		this.firstName = firstName;
		this.age = age;
	}

	public static void main(String[] args) {
		Employee e1 = new Employee("Akhilesh", 32);
		Employee e2 = new Employee("Abhishek", 28);
		Employee e3 = new Employee("Hitesh", 32);
		Employee e4 = new Employee("Hitesh", 18);
		Employee e5 = new Employee("Aditi", 3);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		employees.add(e5);

//		Comparator<Employee> byFirstNameAndAge = Comparator.comparing(Employee::getFirstName)
//				.thenComparing(Employee::getAge);

		// Taking care of null based compound scenario
		Comparator<Employee> byFirstNameAndAge = Comparator
				.comparing(Employee::getFirstName, Comparator.nullsFirst(Comparator.naturalOrder()))
				.thenComparing(Employee::getAge, Comparator.nullsFirst(Comparator.naturalOrder()));

		System.out.println("Before Sort" + employees);

		// Collections.sort(employees, byFirstNameAndAge);

//		Collections.sort(employees, new Comparator<Employee>() {
//
//			@Override
//			public int compare(Employee e1, Employee e2) {
//				int firstName = e1.getFirstName()
//						.compareTo(e2.getFirstName());
//				if (firstName != 0) {
//					return firstName;
//				}
//				int age = e1.getAge()
//						.compareTo(e2.getAge());
//
//				return age;
//			}
//		});

		Comparator<Employee> byFirstNameAndAge2 = (x, y) ->
			{

				int firstName = x.getFirstName()
						.compareTo(y.getFirstName());
				if (firstName != 0) {
					return firstName;
				}
				int age = x.getAge()
						.compareTo(y.getAge());

				return age;
			};

		Collections.sort(employees, byFirstNameAndAge2);

		System.out.println("After Sort" + employees);

		Map<String, List<Employee>> map = employees.stream()
				.filter(emp -> emp.getAge() > 20)
				.collect(Collectors.groupingBy(Employee::getFirstName));

		Map<Integer, List<Employee>> nums = employees.stream()
				.collect(Collectors.groupingBy(Employee::getAge));

		System.out.println(map);

		System.out.println(nums);

	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", age=" + age + "]\n";
	}

}
