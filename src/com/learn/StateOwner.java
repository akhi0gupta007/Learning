package com.learn;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StateOwner {

	List<String> items = new ArrayList<String>();
	{
		items.add("one");
		items.add("two");
		items.add("three");
		items.add("four");
		items.add("five");
	}
	List<String> items1 = new ArrayList<String>();
	{
		items1.add("1");
		items1.add("2");
		items1.add("3");
		items1.add("4");
		items1.add("5");
	}

	interface Calculate {
		Integer sum(Integer a1, Integer a2);
	}

	@FunctionalInterface
	interface ConcateNate{
		String add(String s1,String s2);
	}
	
	
	interface CollectionPrinter {
		void print(Collection<String> items);
	}

	public List<String> getItems() {
		return items;
	}

	State presentState;
	Calculate calc;
	CollectionPrinter printer;
	List<StateChangeListener> listeners = new ArrayList<>();

	public void addPrinter(CollectionPrinter printer) {
		this.printer = printer;
	}

	public void addStateListener(StateChangeListener listener) {
		listeners.add(listener);
	}

	public void addCalculation(Calculate calc) {
		this.calc = calc;
	}

	public void changeState(State newState) {

		for (StateChangeListener listener : listeners) {
			listener.onStateChange(presentState, newState);
		}
		this.presentState = newState;
	}

	public static void main(String[] args) {

		StateOwner stateOwner = new StateOwner();
		stateOwner.addStateListener(new StateChangeListener() {

			@Override
			public void onStateChange(State oldState, State newState) {
				System.out.println(oldState + " to " + newState);
			}
		});

		stateOwner.addStateListener((oldstate, newState) -> {
			System.out.println("State changed from Lambda: " + newState);
		});

		stateOwner.addPrinter(elements -> {
			for (String item : elements)
				System.out.print(item + "");
		});

		stateOwner.changeState(Thread.State.NEW);

		stateOwner.addCalculation((s1, s2) -> s1 + s2);

		System.out.println(stateOwner.calc.sum(23, 23));

		List<String> items = stateOwner.getItems();
		List<String> items1 = stateOwner.items1;
		List<String> filtered = null;

		System.out.println(items.stream().count());

		filtered = items.stream().filter(item -> item.startsWith("o")).collect(Collectors.toList());

		stateOwner.printer.print(filtered);

		System.out.println(items.stream().min(Comparator.comparing(item -> item.length())).get());

		System.out.println(items
				.stream()
				.filter(item -> item.endsWith("e"))
				.count());

		String reduced2 = items.stream().reduce((acc, item) -> acc + " " + item).get();
		String reduced = items.stream().reduce("bla", (acc, item) -> acc + " " + item);
		// Collections.sort(items, (a, b) -> a.compareTo(b));
		//
		System.out.println(items);
		System.out.println(reduced2);
		System.out.println(reduced);

		Function<String, Integer> toInteger = value -> Integer.valueOf(value);
		Function<String, Integer> toInteger1 = Integer::valueOf;

		Predicate<String> predicate = value -> value.length() > 0;

		System.out.println(predicate.test(""));
		System.out.println(predicate.test("Akhi"));
		System.out.println(toInteger.apply("345"));

		items.stream().map(s -> s.toUpperCase()).filter(s -> s.startsWith("O")).forEach(System.out::print);
		System.out.println("\n Done");

		Optional<String> reduced21 = items
				.stream()
				.reduce((s1, s2) -> s1 + "#" + s2);
		reduced21.ifPresent(System.out::println);
		System.out.println("\n Done");

		List<String> set1 = items1
				.stream()				
				.map(s1 -> s1 + "#")
				.collect(Collectors.toList());

		System.out.println(set1);
		
		ConcateNate concateNae  = (s1,s2)->  s1 + s2;
		
		ConcateNate  old = new ConcateNate() {
			
			@Override
			public String add(String s1, String s2) {
				return s1+s2;
			}
		};
		System.out.println(concateNae.add("Pawan", "Kumar"));
		System.out.println(old.add("Pawan", "Kumar"));

	}

}
