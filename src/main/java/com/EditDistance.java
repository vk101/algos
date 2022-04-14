package com;

public class EditDistance {
	
	
	/**
	 * Bottom-up DP approach where smaller elements are tried first and then built upon
	 * 
	 * For top-down approach recursion can be used, and memoization can be added to use pre-computed results
	 * 
	 */
	private static int editDisDP(String str1, String str2) {
		
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		
		for(int r=0; r<c1.length+1; r++) {
			for(int c=0; c<c2.length+1; c++) {
				
				if(r==0) {
					dp[r][c] = c;
				}
				else if(c==0) {
					dp[r][c] = r;
				}
				else if(c1[r-1] == c2[c-1]) {
					dp[r][c] = dp[r-1][c-1];
				}
				else {
					dp[r][c] = 1 + Math.min(dp[r-1][c], Math.min(dp[r][c-1], dp[r-1][c-1]));
				}
			}
		}
		
		return dp[c1.length][c2.length];
	}
	
	public static void main(String[] args) {
		
		String str1 = "sunday";
		String str2 = "saturday";
		
		int dis = editDisDP(str1, str2);
		System.out.println(dis);
	}

}
