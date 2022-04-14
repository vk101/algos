package com;

import java.util.stream.IntStream;

public class DisjointSet {

	static int find(int A[], int X) {
		int p = X;
		while(A[p] > -1) {
			p = A[p];
		}
		return p;
	}
	
	/*
	 * disjoint-set used to find cycle in undirected graph
	 * graph is represented in an array
	 * vertex is an index in the array
	 * value is the parent of that vertex
	 * 
	 * initially every vertex has value of -1, meaning vertex itself is its parent
	 * as, edges are added, parents are changed
	 * if edge has one vertex in set1 and second vertex in set2, 
	 * 			then union set is created of set1 and set2
	 * union set, parent of one set is made child of the parent of another set
	 * 
	 * if both the vertices of an edge are in the same set, then it means there is a cycle.
	 * 
	 * condensed disjoint-set:
	 * here instead of keeping immediate parent of a vertex as array value, root vertex 
	 * is kept, so that traversal can be avoided.
	 * 
	 * Ex: for the below representation: 
	 * [0,-4,3,4,1,-1] - values
	 * [0, 1,2,3,4, 5] - indexes
	 * [1] has value -4, as it is the root and total vertices under it are 4
	 * 
	 * graph will be:
	 * 
	 * [1]--[4]--[3]--[2]
	 * [5]
	 * 
	 * 
	 */
	static void unionSet(int A[], int X, int Z) {
		int pX = find(A, X);
		int pZ = find(A, Z);
		
		if(pX != pZ) {
			if((pX*-1) >= (pZ*-1)) {
				A[pZ] = X;
			} else {
				A[pX] = Z;
			}
		}
	}
	
	public static void main(String[] args) {
		int N = 5; //1 to N
		
		int A[] = new int[N+1];
		IntStream.range(0, N+1).forEach(i -> A[i] = -1);
		
		System.out.println(find(A, 4));
		System.out.println(find(A, 1));
		unionSet(A, 3, 1);
		System.out.println(find(A, 3));
		
	}
}
