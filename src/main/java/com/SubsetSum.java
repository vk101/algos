package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SubsetSum {
	
	/*
	 * Given a list arr of N integers, print sums of all subsets in it. 
	 * Output should be printed in increasing order of sums.
	 * Input - [1, 2, 5]
	 * Output - [0, 1, 2, 3, 5, 6, 7, 8]
	 * 
	 * https://practice.geeksforgeeks.org/problems/subset-sums2234/1
	 */
	
	
	/**
	 * Using iteration
	 */
	private static List<Integer> subsetSumItr(int N, int[] input) {
		
		List<Integer> r = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			if(r.size() == 0) {
				r.add(0);
				r.add(input[i]);
			}
			else {
				final int i_f = i;
				List<Integer> rr = new ArrayList<>();
				r.stream().forEach(p->rr.add(p+input[i_f]));
				r.addAll(rr);
			}
		}
		return r;
	}
	
	
	/**
	 * Using recursion
	 */
	private static void subsetSumRecrs(List<Integer> in, List<Integer> out, int sum, int ptr, int end) {
		
		System.out.printf("Interim: %s, %s\n", ptr, sum);
		if(ptr > end) {
			out.add(sum);
			System.out.printf("%s, %s\n", ptr, sum);
			return;
		}
		
		subsetSumRecrs(in, out, sum+in.get(ptr), ptr+1, end);
		subsetSumRecrs(in, out, sum, ptr+1, end);
		
		
		
		/*   For inputs {1, 2, 5} ---> depth of the binary tree is equal to the number of input elements, each node has 2 children, 
		 * 							   one where input[level] number is added and second where number is not added.
		 *                                  
		 *[0]                                  [0(p)]    (has two children - include 1, do not include 1
		 *[1]                       [p+1]                          [p+(nothing)]      (both nodes have 2 children - include 2, do not include 2)
		 *[2]                 [p+1+2]    [p+1+(nothing)]  [p+(nothing)+2]     [p+(nothing)+(nothing)] (all the 4 nodes have 2 children - include 5, do not include 5)
		 *[5]
		 */
		
		
	}
	
	public static void main(String[] args) {
		int[] in = {1,2,5};
		
		//List<Integer> r = SubsetSum.subsetSumItr(3, in);
		  
		List<Integer> ina = Arrays.stream(in).boxed().collect(Collectors.toList());
		List<Integer> r = new ArrayList<>();
		subsetSumRecrs(ina, r, 0, 0, ina.size()-1);
		r.sort(Comparator.naturalOrder());
		 
		
		System.out.println(r);
	}
	
}
