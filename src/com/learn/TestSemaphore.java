package com.learn;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class TestSemaphore {

	static Semaphore sem = new Semaphore(3);
	static Connection[] conns = new Connection[3];

	static class Connection {
		int id;

		public Connection(int id) {
			super();
			this.id = id;
		}

		@Override
		public String toString() {
			return "Connection [id=" + id + "]";
		}

		public int getId() {
			return id;
		}

	}

	static public void display() {
		System.out.println("Displaying .....");
		for (Connection con : conns) {
			System.out.println(con);
		}
		System.out.println("\n");
	}

	static {
		conns[0] = new TestSemaphore.Connection(0);
		conns[1] = new TestSemaphore.Connection(1);
		conns[2] = new TestSemaphore.Connection(2);
	}

	static Connection getConnection() {
		Connection result = null;
		try {
			sem.acquire();
			int tmp = 0;
			while (conns.length > tmp) {
				result = conns[tmp];
				if (null != result) {
					conns[tmp] = null;
					System.out.println("Request " + result);
					return result;
				}
				tmp++;
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		return null;

	}

	static void returnConnection(Connection conn) {
		if (conn != null) {
			conns[conn.getId()] = conn;
			sem.release();
		}
	}

	public static void main(String[] args) {
		display();
		getConnection();
		Connection conn = getConnection();
		getConnection();
		returnConnection(conn);
		getConnection();
		display();
	}
}
