package com;

public class MorrisInorderTraversal {

	
	static class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public Node(int data) {
			this(data, null, null);
		}
	}
	
	/**
	 * 
	 * Morris traversal for in-order traversal does not require stack or recursion to traverse a binary tree.
	 * 
	 * Algorithm:
	 * 1. Two pointers are used: 
	 * 		a. curr - pointing to the current node as per in-order traversal
	 * 		b. prev - point to the predecessor as per in-order traversal
	 * 2. As moving down the tree, create right pointer from the right most node to parent or successor
	 * 3. If there is no right node, create right pointer from left node to its successor
	 * 4. This new pointer helps in going to the successor when left part of the tree is scanned
	 * 5. Remove the pointer after we have reached the successor after scanning the left most tree
	 * 
	 * Good explanation:
	 * https://stackoverflow.com/questions/5502916/explain-morris-inorder-tree-traversal-without-using-stacks-or-recursion
	 * 
	 */
	static void traversal(Node root) {
		
		Node curr = root;
		
		while(curr != null) {
			if (curr.left != null) {
				Node t = curr.left;
				// Find the right most node of the left subtree
				while(t.right != null && t.right != curr) {
					t = t.right;
				}
				// if right node is same as current, it means we have backtracked by 
				// the left subtree, we can then change this temporary right pointer created
				if(t.right == curr) {
					System.out.print(curr.data + " ");
					t.right = null;
					curr = curr.right;
				}
				else {
					//create right pointer from the right most node to the current, which will be the successor
					t.right = curr;
					curr = curr.left;
				}
			}
			// if there is no left node, print the curr node as it is the root and move curr to the right node
			else if(curr.left == null) {
				System.out.print(curr.data + " ");
				if(curr.right != null) {
					curr = curr.right;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		/*
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n3 = new Node(3, n4, n5);
		Node n2 = new Node(2, null, n3);
		Node root = new Node(1, n2, null);
		*/
		
		Node n14 = new Node(14);
		Node n13 = new Node(13, null, n14);
		Node n11 = new Node(11, n13, null);
		Node n9 = new Node(9, n11, null);
		Node n8 = new Node(8);
		Node n4 = new Node(4, n8, n9);
		Node n5 = new Node(5);
		Node n2 = new Node(2, n4, n5);
				
		Node n12 = new Node(12);
		Node n10 = new Node(10, n12, null);
		Node n7 = new Node(7, null,n10);
		Node n6 = new Node(6);
		Node n3 = new Node(3, n6, n7);
		
		Node root = new Node(1, n2, n3);
		
		/*
		Node n12 = new Node(12);
		Node n10 = new Node(10, n12, null);
		Node n7 = new Node(7, null,n10);
		Node n6 = new Node(6);
		Node n3 = new Node(3, n6, n7);
		
		Node root = new Node(1, null, n3);
		*/
		
		traversal(root);
	}
}
