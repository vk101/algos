package com;

import java.util.Arrays;

public class LongestIncreasing {

	
	private int lis(int[] arr, int end) {
		
		if(end == 0)
			return 1;
		
		int max = 0;
		int m = 0;
		
		//Find max seq ending at 'end'
		for(int i=0; i<end; i++) {
			
			int t = lis(arr, i);
			if(arr[i]<arr[end-1] && t+1 > m) {
				m=t+1;
			}
		}
		
		max = max>m?max:m;
		
		return max;
		
	}
	
	private int lis_recur(int[] arr) {
		int max = lis(arr, arr.length);
		return max;
	}
	
	
	private int lis_dp(int arr[]) {
		
		int dp[] = new int[arr.length];
		
		Arrays.fill(dp, 1);
		
		//bottom up approach - seq ending pointer is moved from 1 to n
		int max = 0;
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				
				if(arr[j]<arr[i]) {
					if(dp[i] < dp[j]+1) {
						dp[i] = dp[j]+1;
						
						max = max > dp[i]?max:dp[i];
					}
				}
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		
		LongestIncreasing l = new LongestIncreasing();
		
		int[] input = new int[]{10, 22, 9, 33, 21, 50, 41, 60};
		
		int m = l.lis_recur(input);
		System.out.println("With recur: " + m);
		
		m = l.lis_dp(input);
		
		System.out.println("With dp: " + m);
		
	}
	
}
