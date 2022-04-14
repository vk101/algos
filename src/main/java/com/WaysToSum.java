package com;

public class WaysToSum {

	/*
	 * https://www.geeksforgeeks.org/different-ways-sum-n-using-numbers-greater-equal-m/
	 * 
	 * Find number of ways to find sum 'n' for numbers greater than 'm'
	 * 
	 */
	private int find_dp(int m, int n) {
		
		int[][] dp = new int[n+1][n+1];
		
		for(int r=1;r<=n; r++) {
			for(int c=m; c<=n; c++) {
				
				if(r==1) {
					dp[r][c] = 1;
				}
				else {
					dp[r][c] = dp[r-1][c];
					
					if(c-r > 0) {
						dp[r][c] += dp[r][c-r];
					}
					else if(c-r == 0) {
						dp[r][c] += 1;
					}
				}
			}
			/*
			for(int c=m; c<=n; c++) {
				System.out.print(dp[r][c] + " ");
			}
			System.out.println();
			*/
		}
		
		return dp[n][n];
		
	}

	public static void main(String[] args) {
		
		int m = 1;
		int n = 4;
		
		WaysToSum w = new WaysToSum();
		int res = w.find_dp(m, n);
		
		System.out.println(res);
	}
}
