package com;

import java.util.stream.IntStream;

/**
 * https://www.geeksforgeeks.org/temple-offerings/
 * 
 * The temples are located in a row at different heights. Each temple should
 * receive at least one offer. If two adjacent temples are at different
 * altitudes, then the temple that is higher up should receive more offerings
 * than the one that is lower down. If two adjacent temples are at the same
 * height, then their offerings relative to each other do not matter.
 * 
 * For [1, 2, 2] offerings will be [1, 2, 1] total 4
 *
 */
public class TempleOfferings {
	
	
	private static class Temple {
		private int left;
		private int right;
		
		private int max() {
			return left>right?left:right;
		}
		
		@Override
		public String toString() {
			return "[" + left + ", " + right + "]";
		}
	}
	
	private int templateOfferings(int[] tHeight) {
		
		Temple[] temples = IntStream.range(0, tHeight.length).mapToObj(i->new Temple()).toArray(Temple[]::new);
		
		temples[0].left = 1;
		temples[tHeight.length-1].right = 1;
		
		//Traverse from left to right, and assign offerings based on number of temples on left to a temple
		for(int i=1; i<tHeight.length; i++) {
			if(tHeight[i-1]<tHeight[i]) {
				temples[i].left = temples[i-1].left+1;
			}
			else {
				temples[i].left = 1;
			}
		}
		
		//Traverse from right to left, and assign offerings based on number of temples on right to a temple
		for(int i=tHeight.length-2; i>=0; i--) {
			if(tHeight[i]>tHeight[i+1]) {
				temples[i].right = temples[i+1].right+1;
			}
			else {
				temples[i].right = 1;
			}
		}
		
		// Find max offering to a temple by taking maximum from both left and right
		int offerings = 0;
		for(int i=0; i<tHeight.length; i++) {
			offerings += temples[i].max();
		}
		
		return offerings;
	}
	
	public static void main(String[] args) {
		
		int t[] = {1,4,3,2,6,1};
		
		TempleOfferings o = new TempleOfferings();
		int offerings = o.templateOfferings(t);
		
		System.out.println(offerings);
		
	}

}
