package com.learn;

import java.util.Arrays;
import java.util.List;

public class Employee {
	private Integer id;
	private String name;
	private String lastName;
	public Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return name + "--"+age;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Employee(Integer id, String name, String lastName) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
	}

	public Employee(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public static List<Employee> createEmployes() {

		return Arrays.asList(new Employee("Akhilesh", 23), new Employee("Abhishek", 20), new Employee("Nancy", 13),
				new Employee("Aditi", 3), new Employee("Mohan", 34), new Employee("Deepa", 56),
				new Employee("Mukesh", 8),new Employee("Mukesh", 81),new Employee("Akhilesh", 73));
	}

}
