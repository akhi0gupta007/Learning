package com.learn;

import com.ds.Tree;
import com.ds.Tree.TreeElm;

public class BSTTest {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(tree.getRoot(), 10);
		tree.insert(tree.getRoot(), 11);
		tree.insert(tree.getRoot(), 4);
		tree.insert(tree.getRoot(), 15);
		tree.insert(tree.getRoot(), 6);
		tree.insert(tree.getRoot(), 17);
		tree.insert(tree.getRoot(), 8);
		tree.insert(tree.getRoot(), 19);
		tree.insert(tree.getRoot(), 2);
		/*
				  	10
				   /\
				  4  11	
				 / \   \ 
				2   6   15
				     \   \
				      8   17
				       \   \
				        8  19
		 * 
		 * 
		 * 	
		 * */
		TreeElm root = tree.getRoot();
		System.out.println("Height of tree "+tree.calculateHeight(root));
		System.out.println("Height of tree "+tree.height(root));
		tree.printLevelOrder(root);
		tree.preOrdertraversal(root);
		System.out.println();
		System.out.println("InOrder");
		tree.inOrdertraversal(root);
		System.out.println();
		System.out.println("isBST "+tree.isBSTUtil(root));
		System.out.println("search BST "+tree.searchBST(root, 17));		
		System.out.println("search "+tree.search(root, 17));
		System.out.println("delete "+tree.delete(tree.getRoot(), 2));
		System.out.println("InOrder");
		tree.inOrdertraversal(root);		
		constructTree();
		
	}
	
	private static void constructTree() {
		int in[] = {4,2,5,1,6,3};
		int pre[] = {1,2,4,5,3,6};
		Tree tree = new Tree();
		TreeElm root = tree.buildTree(in, pre, 0, in.length-1);
		System.out.println();
		tree.preOrdertraversal(root);
	}

}
