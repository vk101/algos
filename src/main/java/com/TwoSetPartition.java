package com;

import java.util.Arrays;

public class TwoSetPartition {


	/**
	 * It is a tree structure, where left child is '0' meaning element is not
	 * included in the set, right is '1' meaning element is included in the set.
	 */
	int find_all(int[] in, int element, int sumCalculated, int sumTotal) {

		if (element == 0) {
			return Math.abs((sumTotal-sumCalculated) - sumCalculated);
		}

		return Math.min(
				find_all(in, element-1, sumCalculated + in[element-1], sumTotal),
				find_all(in, element-1, sumCalculated, sumTotal));

	}

	void find_recur(int[] in) {

		int sumOfAll = Arrays.stream(in).sum();
		int result = find_all(in, in.length, 0, sumOfAll);
		
		System.out.println(result);
	}

	
	public static void main(String[] args) {
		
		int[] v = {1, 6, 11, 5};
		
		(new TwoSetPartition()).find_recur(v);
	}
}
