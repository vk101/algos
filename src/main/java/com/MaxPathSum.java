package com;


public class MaxPathSum {

	// https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
	
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

	//May not work for skew tree - where all the nodes are on one side only
	static int max = -9999;
	static int dfs(Node node) {
		if(node==null) return 0;
		if(node.left == null && node.right == null)
			return node.data;
		
		int lm = dfs(node.left);
		int rm = dfs(node.right);
		
		int rt = node.right == null?0:rm;
		int lt = node.left == null?0:lm;
		
		int l2l = (lt+rt+node.data);
		
		max = l2l>max?l2l:max;
		
		int t=0;
		if(node.right == null) {
			t = lm+node.data;
		} 
		else if (node.left == null) {
			t = rm+node.data;
		}
		else {
			t = lm>rm?lm+node.data:rm+node.data;
		}
		
		return t;	
	}
	
	static int findMax(Node node) {
		dfs(node);
		return max;
	}
	
	public static void main(String[] args) {
		
		/*
		Node nm10 = new Node(-10);
		Node n4 = new Node(4);
		Node np4 = new Node(4, nm10, n4);
		Node n5 = new Node(5);
		Node root = new Node(3, np4, n5);
		*/
		
		
		/*
		           -15                               
		         /      \                          
		        5         6                      
		      /  \       / \
		    -8    1     3   9
		   /  \              \
		  2   -3              0
		                     / \
		                    4  -1
		                       /
		                     10 
		*/
		
		/*
		Node n2 = new Node(2);
		Node nm3 = new Node(-3);
		Node nm8 = new Node(-8,n2,nm3);
		Node n1 = new Node(1);
		Node n5 = new Node(5, nm8, n1);
		
		Node n10 = new Node(10);
		Node n4 = new Node(4);
		Node nm1 = new Node(-1, n10, null);
		Node n0 = new Node(0,n4,nm1);
		Node n9 = new Node(9,null,n0);
		Node n3 = new Node(3);
		Node n6 = new Node(6, n3, n9);
		
		Node root = new Node(-15,n5,n6);
		*/
		
		
		Node n2 = new Node(2);
		Node nm8 = new Node(-8,n2,null);
		Node n1 = new Node(1);
		Node n5 = new Node(5, nm8, n1);
		Node root = new Node(-15,n5, null);		
		
		int max = findMax(root);
		System.out.println(max);
		
	}
	
}
