package com.learn;

public class TestOpps extends Parent{

	String name = "Abhishek";
	
	TestOpps(){
		super();
		System.out.println(this.name);
		System.out.println(super.getName());
	}
	
	public static void main(String[] args) {
		Parent parent = new TestOpps();
		System.out.println("Parent name "+parent.getName());
	}
	
	public String getName() {
		return name;
	}

}

class Parent {
	String name = "AKhilesh";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
