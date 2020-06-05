package com.learn;

import java.util.ArrayList;
import java.util.List;

public class TestSuper extends SuperClass {	
	public static void main(String[] args) throws Exception {
		SuperClass obj = new TestSuper();
	//	obj.method(new Integer(2));
		obj.method(null);
	//	obj.method("hi");
//		obj.method(1, 2);
//		obj.method(new Integer(2),2);
//		obj.method(1, 2);	
		//Generics		
		List<TestSuper> list = new ArrayList<TestSuper>();		
		m1();
		}
	
	 String method(int i ) throws RuntimeException,ArrayIndexOutOfBoundsException{
		System.out.println("TestSuper");	
		return null;
	}
	 
	String method(Integer i) {
			System.out.println("base Integer wrapper ");
			return null;
	}
	 
	 static void m1() throws Exception{		 
		 try {			 throw new Exception();
			 
		 }
		 catch(Exception ex){
			 System.out.println("caught");
			 return;
		 }finally{
			 System.out.println("finally");
		 }
	 }
}

class SuperClass {
	 Object method(int i) throws NullPointerException {
		System.out.println("SuperClass");
		return null;
	}
//	 String method(Integer i) {
//			System.out.println("SuperClass Integer wrapper ");
//			return null;
//	}
		 
	 Object method(Integer i,int x) {
		System.out.println("SuperClass wrapper Integer i,int x");
		return null;
	}
	 
	 Object method(int i,int x) {
			System.out.println("SuperClass wrapper int i,int x");
			return null;
	} 
	 
	 Object method(Object i) {
		System.out.println("SuperClass Object wrapper");
		return null;
	} 
	 
	 void method(String str) {
		 System.out.println("String ");
	 }
	 
}