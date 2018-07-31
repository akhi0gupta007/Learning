package com.learn;

import com.ds.Tree;
import com.ds.Tree.TreeElm;

public class TreeTest {

	public static void main(String[] args) {
		Tree tree = new Tree();
		Tree.TreeElm elm = tree.insert(tree.getRoot(), 10);
		elm = tree.insert(tree.getRoot(), 200);
		elm = tree.insert(tree.getRoot(), 8);
		elm = tree.insert(tree.getRoot(), 21);
		elm = tree.insert(tree.getRoot(), 18);
		elm = tree.insert(tree.getRoot(), 3);
		elm = tree.insert(tree.getRoot(), 1);
		elm = tree.insert(tree.getRoot(), 44);
		elm = tree.insert(tree.getRoot(), 5);
		elm = tree.insert(tree.getRoot(), 2);
		elm = tree.insert(tree.getRoot(), 6);
		System.out.println(tree.search(tree.getRoot(), 19));
		tree.preOrdertraversal(tree.getRoot());
		System.out.println();
		tree.postOrdertraversal(tree.getRoot());
		System.out.println();
		tree.inOrdertraversal(tree.getRoot());
		System.out.println(tree.search(tree.getRoot(), 30));
		System.out.println(tree.max(tree.getRoot()));

		leftViewTest();

	}

	private static void leftViewTest() {
		Tree tree = new Tree();
		TreeElm root = tree.getInstance(2);
		root.setLeft(tree.getInstance(1));
		root.setRight(tree.getInstance(3));
		tree.preOrdertraversal(root);
		System.out.println("isBST "+tree.isBSTUtil(root));
		
	}

}