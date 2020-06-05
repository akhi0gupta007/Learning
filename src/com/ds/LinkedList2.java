package com.ds;

public class LinkedList2 {

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


	public int getSize() {
		return size;
	}

}
