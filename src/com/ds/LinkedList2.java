package com.ds;

public class LinkedList2 {

	private Node head;
	private int size;

	public class Node {

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

	public void reverse() {
		if (head == null) {
			System.out.println("Empty list");
			return;
		}
		Node current = head, prev = null, tmp = null;
		while (current != null) {
			tmp = current.next;
			current.next = prev;
			prev = current;
			current = tmp;
		}
		head = prev;
	}

	public Integer middleElement() {

		Node slow = head, fast = head;

		while (fast != null) {
			if (fast.getNext() == null) {
				break;
			}

			fast = fast.getNext()
					.getNext();
			slow = slow.getNext();
		}

		return slow != null ? slow.data : -1;
	}

	public void reverseRecursion(Node node) {
		if (node.next == null) {
			head = node; // exit condition
			return;
		}
		reverseRecursion(node.next);
		Node tmp = node.next;
		tmp.next = node;
		node.next = null;
	}

	public Node newHead = null;
	public Node reverseList2(Node head) {
		System.out.println("Process " + head.data);
		if (head.next == null) {
			newHead = head;
			System.out.println("exit " + head.data);
			return head;
		}
		System.out.println("Continue.." + head.data);
		Node tmp = reverseList2(head.next);
		System.out.println("tmp" + tmp.data);
		System.out.println("head" + head.data);
		tmp.next = head;
		head.next = null;
		System.out.println("Setting tmp as " + tmp);
		System.out.println("Returning " + head.data);
		System.out.println(head);
		return head;
	}

	public void traverse() {
		if (head == null) {
			System.out.println("Empty list");
			return;
		}
		System.out.println("\n");
		Node tmp = head;
		while (tmp != null) {
			System.out.print("->" + tmp.getData());
			tmp = tmp.getNext();
		}
		System.out.println("\n");
	}

	public void traverse2(Node node) {
		if (node == null) {
			System.out.println("Empty list");
			return;
		}
		System.out.println("\n");
		Node tmp = node;
		while (tmp != null) {
			System.out.print("->" + tmp.getData());
			tmp = tmp.getNext();
		}
		System.out.println("\n");
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void traverseRecursion(Node next) {
		if (next == null) {
			System.out.println();
			return;
		}

		System.out.print(String.format("-> %d", next.getData()));
		traverseRecursion(next.next);
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
