package com.ds;

public class LinkedList {

	private Node head;
	private int size;

	class Node {

		private Node next;
		private Integer data;

		Node(Node next, Integer data) {
			this.next = next;
			this.data = data;
		}

		public Node(Node next) {
			super();
			this.next = next;
		}

		public Node(Integer data) {
			super();
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [next=" + next + ", data=" + data + "]";
		}

	}

	public void traverse() {
		if (head == null) {
			System.out.println("Empty list");
			return;
		}
		Node tmp = head;
		while (tmp != null) {
			System.out.print("->" + tmp.getData());
			tmp = tmp.getNext();
		}
		System.out.println("\n");
	}

	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
		size++;
	}

	public void append(int new_data) {
		Node new_node = new Node(new_data);
		Node tmp = head;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
		}
		tmp.setNext(new_node);
		new_node.setNext(null);
		size++;
	}

	public void reverse() {
		Node current = head;
		Node prev = null, next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;

	}

	public void reverse2() {
		reverseRecursion(null, head);
	}

	public int midElement() {
		Node current = head;
		Node mid = head;
		while (current != null) {
			current = current.getNext() == null ? null : current.next.next;
			mid = mid.next;
		}
		return mid.data;

	}

	public int nthFromLast(int n) {
		Node first = head, second = head;

		while (first != null) {

			first = first.next;
			if (n <= 0) {
				second = second.next;
			}
			n--;
		}

		return second.data;

	}

	public void reverseRecursion(Node prev, Node current) {

		if (current.next == null) {
			head = current;
			current.next = prev;
			return;
		}
		Node next = current.next;
		current.next = prev;
		reverseRecursion(current, next);

	}

	public void truncateList() {
		head = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public int[] asArray() {
		int arr[] = new int[size];
		int i = 0;
		Node current = head;
		while (current != null) {
			arr[i] = current.data;
			current = current.next;
			i++;
		}
		return arr;

	}

}
