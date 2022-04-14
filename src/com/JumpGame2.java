package com;

import java.util.Arrays;

// https://leetcode.com/problems/jump-game-ii/
public class JumpGame2 {
    
	
	public int jump(int[] nums) {
		
		int cache[] = new int[nums.length];
		Arrays.fill(cache, -1);
		
		for(int i=nums.length-1;i>=0;i--) {
			if(i==nums.length-1) {
				cache[i]=1;
			}
			else {
				if(nums[i] == (nums.length-1-i)) {
					cache[i] = 1;
				} else {
					cache[i] = i<nums.length-1?cache[i+1]+1:1;
				}
			}
		}
		
		return cache[0];
    }
	
	public static void main(String[] args) {
		
		//int jumps[] = {2,3,1,1,4};
		int jumps[] = {2,3,0,1,4};
		
		JumpGame2 j = new JumpGame2();
		int steps = j.jump(jumps);
		System.out.println(steps);
	}
}
