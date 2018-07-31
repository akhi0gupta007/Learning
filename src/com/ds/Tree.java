package com.ds;

public class Tree {
	static int preIndex = 0;
	private TreeElm root;
	private int size;

	public static class TreeElm {
		private TreeElm left;
		private TreeElm right;
		int data;

		public TreeElm getLeft() {
			return left;
		}

		public void setLeft(TreeElm left) {
			this.left = left;
		}

		public TreeElm getRight() {
			return right;
		}

		public void setRight(TreeElm right) {
			this.right = right;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public TreeElm(TreeElm left, TreeElm right, int data) {
			super();
			this.left = left;
			this.right = right;
			this.data = data;
		}

		@Override
		public String toString() {
			return "TreeElm [data=" + data + "]";
		}

	}

	public TreeElm getInstance(int data) {
		return new TreeElm(null, null, data);
	}

	public TreeElm insert(TreeElm root, int data) {
		if (root == null) {
			root = new TreeElm(null, null, data);
			if (null == this.root)
				this.root = root;
		} else if (data < root.getData()) {
			root.left = insert(root.getLeft(), data);
		} else {
			root.right = insert(root.getRight(), data);
		}
		return root;

	}

	public boolean search(TreeElm root, int data) {
		if (root != null) {
			if (root.data == data) {
				return true;
			} else {
				if (true == search(root.getLeft(), data)) {
					return true;
				} else if (true == search(root.getRight(), data)) {
					return true;
				}
			}
		}
		return false;
	}

	public TreeElm delete(TreeElm root, int data) {

		if (root == null)
			return null;
		if (data < root.getData()) {
			root.left  = delete(root.getLeft(), data);
		} else if (data > root.getData()) {
			root.right = delete(root.getRight(), data);
		} else {
			if(root.getLeft() ==null && root.getRight() == null){
				root = null;
			}
			else if (root.getLeft() == null){ //1 child
				root = root.getRight();
			}
			else if (root.getRight() == null){ //1 child
				root = root.getLeft();
			}
			else{
				TreeElm temp = FindMin(root.getLeft());
				root.data = temp.data;
				temp = null;
			}
		}
		
		return root;

	}
	
	/** Find minimum in BST
	 * @param root is root node 
	 * @return minimum reference
	 */
	TreeElm FindMin(TreeElm root){
		
		if(root == null)
			return null;
		
		while(root.getLeft()!=null){
			root = root.getLeft();
		}		
		
		return root;
		
	}

	public boolean searchBST(TreeElm root, int data) {

		if (root == null)
			return false;
		if (data == root.data)
			return true;
		if (data < root.data) {
			return searchBST(root.getLeft(), data);
		} else {
			return searchBST(root.getRight(), data);
		}
	}

	public int max(TreeElm root) {
		int max = -1, lMax = -1, rMax = -1;
		if (root == null) {
			return -1;
		}
		if (root.getData() > max) {
			max = root.getData();
		}
		lMax = max(root.getLeft());
		if (lMax > max) {
			max = lMax;
		}
		rMax = max(root.getRight());
		if (rMax > max) {
			max = rMax;
		}

		return max;

	}

	public boolean isBSTUtil(TreeElm root) {

		if (root == null)
			return true;

		if (null != root.getLeft() && (root.getData() < max(root.getLeft())))
			return false;

		if (null != root.getRight() && root.getData() > max(root.getRight()))
			return false;

		if (!isBSTUtil(root.getLeft()) || !isBSTUtil(root.getRight()))
			return false;

		return true;
	}

	public void preOrdertraversal(TreeElm root) {
		if (root != null) {
			System.out.print(root.getData() + " ");
			preOrdertraversal(root.getLeft());
			preOrdertraversal(root.getRight());
		}
	}

	public void postOrdertraversal(TreeElm root) {
		if (root == null) {
			return;
		} else {
			postOrdertraversal(root.getLeft());
			postOrdertraversal(root.getRight());
			System.out.print(root.getData() + " ");
		}
	}

	public void inOrdertraversal(TreeElm root) {
		if (root == null) {
			return;
		} else {
			inOrdertraversal(root.getLeft());
			System.out.print(root.getData() + " ");
			inOrdertraversal(root.getRight());
		}
	}

	public TreeElm getRoot() {
		return root;
	}

	public void setRoot(TreeElm root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void printLeftView(TreeElm root) {
		if (null != root) {
			System.out.printf("%d ", root.getData());
			printLeftView(root.getLeft());
		}
	}
	
	public int calculateHeight(TreeElm root){
		
		if(root ==null)
			return 0;
		
		int lHeight = calculateHeight(root.getLeft());
		int rHeight = calculateHeight(root.getRight());
		if(lHeight>rHeight)
			return lHeight+1;
		else
			return rHeight + 1;		
	}
	
	public int height(TreeElm root) {
		if (root == null) 
		return 0;
		return( 1 + Math.max(height(root.left), height(root.right)));
		}

	
	public void printLevelOrder(TreeElm root){
		int height = height(root);
		
		for(int i = 1;i<= height;i++){
			printGivenLevel(root,i);
			System.out.println();
		}
	}

	private void printGivenLevel(TreeElm root, int level) {
		if(root== null)
			return;
		if(1== level){
			System.out.printf("%d ", root.getData());
			return;
		}else{
			printGivenLevel(root.getLeft(), level-1);
			printGivenLevel(root.getRight(), level-1);
		}
		
	}
	
	public TreeElm buildTree(int in[],int pre[],int inStrt,int inEnd){
		
		if(inStrt>inEnd)
			return null;
		
		TreeElm elm = this.getInstance(pre[preIndex++]);
		
		 if (inStrt == inEnd)
	           return elm;
		
		 int rootIndex = searchInorder(elm.data,in);
		 
		 elm.left = buildTree(in, pre, inStrt, rootIndex-1);
		 elm.right = buildTree(in, pre, rootIndex+1, inEnd);
		 
		return elm;		
	}

	private int searchInorder(int data, int[] in) {
		for(int i = 0;i <in.length ;i++){
			if(in[i] == data){
				return i;
			}
		}
		return -1;
	}
}