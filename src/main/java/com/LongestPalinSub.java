package com;

/*
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
class LongestPalinSub {
	
	public static void main(String[] args) {
		
		String s = "cbbd";
		char[] cs = s.toCharArray();
		
		/* keeps track of the starting position of the last palindrome */
		int sRoot = 0;
		
		int max = 0;
		int curr = 1;
		
		for(int i=0; i<cs.length;i++) {
			
			if(i>0) {
				if (cs[i] == cs[i-1]) {
					curr += 1;
					sRoot = i-1;
				}
				else if (sRoot>0 && (cs[i] == cs[sRoot-1])) {
					curr += 2;
					sRoot = sRoot - 1;
				}
				else if (i>2 && cs[i] == cs[i-2]) {
					sRoot = i-2;
					curr = 3;
				}
				else {
					sRoot = i;
					max = max > curr ? max : curr;
					curr = 1;
				}
			}	
		}
		max = max > curr ? max : curr;
		
		System.out.println("Longest palindrome: " + max);
	}
}