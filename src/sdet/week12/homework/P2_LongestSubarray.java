package sdet.week12.homework;

import org.junit.Test;

/*
Problem 2)

Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s. 

Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation: 
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
Example 2:

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation: 
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
*/

public class P2_LongestSubarray {

	@Test
	public void example1() {
		int[] arr = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		int k = 2;
		longSubarray(arr, k);
	}
	
	@Test
	public void example2() {
		int[] arr = { 0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1 };
		int k = 3;
		longSubarray(arr, k);
	}

	private void longSubarray(int[] arr, int k) {
		
		int start=0,end=0,zcnt=0;
		int op=0;
		
		while(end<arr.length) {
			if(arr[end]==0)
				zcnt++;
			op++;
			end++;
			if(zcnt>k) {
				if(arr[start]==0)
					zcnt--;
				start++;
				op--;
			}
		}
		System.out.println(op);
	}
}
