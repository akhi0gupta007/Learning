package com.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {
		
		Consumer<Integer> simpleConsumer = elm -> System.out.println(elm);
		
		simpleConsumer.accept(5);
		
		// Consumer to multiply 2 to every integer of a list 
        Consumer<List<Integer> > modify = list -> 
        { 
            for (int i = 0; i < list.size(); i++) 
                list.set(i, 2 * list.get(i)); 
        }; 
        
        List<Integer> list = new ArrayList<Integer>(); 
        list.add(2); 
        list.add(1); 
        list.add(3); 
  
        // Implement modify using accept() 
        modify.accept(list);
        
        System.out.println(list);
        
		
	}
}
