package com;

import java.util.HashSet;
import java.util.Set;

public class AllSubsequences {

	private static void printAllSubsequences(char[] s1, char[] s2) {
		
		int[][] l = new int[s1.length+1][s2.length+1];		
		
		/*
		 * using dynamic programming and memoization
		 * string 1 in row, string 2 in columns
		 * check every character of string 2 against string 1 and store longest common subsequence
		 * if char in str2 matches with char of str1, use the previously found LCS at [i-1][j-1]
		 * else pick the max from [i-1][j] and [i][j-1]
		 * 
		 */
		
		for(int i=1; i<s1.length+1; i++) {
			for(int j=1; j<s2.length+1; j++) {
				
				if(s1[i-1] == s2[j-1]) {
					l[i][j] = l[i-1][j-1] + 1;
				}
				else {
					l[i][j] = Math.max(l[i][j-1], l[i-1][j]);
				}
			}
		}
		
		System.out.println("Result:");
		
	    Set<String> all = printLcs(l, new String(s1), new String(s2), s1.length, s2.length);
	    System.out.println(all);
	}
	
	/*
	 * starting from bottom right corner:
	 * if chars in str1 and str2 match, take diagonal path
	 * else up of left depending on the max value
	 * if both up and left are same, then traverse both the paths to get the subsequence
	 * take character from column string when moving diagonally
	 * 
	 * https://en.wikibooks.org/wiki/Algorithm_Implementation/Strings/Longest_common_subsequence#Reading_out_all_LCSs
	 */
	private static Set<String> printLcs(int[][] dp, String fst, String snd, int i, int j) {
		    Set<String> lcss = new HashSet<>();

		    if (i == 0 || j == 0) {
		        lcss.add("");
		    } else if (fst.charAt(i - 1) == snd.charAt(j - 1)) {
		        for (String lcs : printLcs(dp, fst, snd, i - 1, j - 1)) {
		            lcss.add(lcs + fst.charAt(i - 1));
		        }
		    } else {
		        if (dp[i - 1][j] >= dp[i][j - 1]) {
		            lcss.addAll(printLcs(dp, fst, snd, i - 1, j));
		        }

		        if (dp[i][j - 1] >= dp[i - 1][j]) {
		            lcss.addAll(printLcs(dp, fst, snd, i, j - 1));
		        }
		    }
		    return lcss;
	}
	
	static void print2D(int[][] l) {
		for(int i=0; i<l.length; i++) {
			for(int j=0; j<l[0].length; j++) {
				System.out.print(l[i][j] + " - ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		String s1 = "abaaa";
		String s2 = "baabaca";
		
		printAllSubsequences(s1.toCharArray(), s2.toCharArray());
	}
	
}
