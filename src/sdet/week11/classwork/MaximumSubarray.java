package sdet.week11.classwork;

import org.junit.Test;

/*
Given an array A of 0s and 1s, you are allowed to change K values from 0 to 1.
Return the length of the longest (contiguous) sub array that contains only 1s. 
Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
*/

public class MaximumSubarray {

	@Test
	public void example1() {
		int[] arr = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		int k = 2;
		maxSubArray(arr, k);
	}

	@Test
	public void example2() {
		int[] arr = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
		int k = 3;
		maxSubArray(arr, k);
	}

	@Test
	public void example3() {
		int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0 };
		int k = 3;
		maxSubArray(arr, k);
	}

	@Test
	public void example4() {
		int[] arr = { 1, 1, 1, 1, 1, 1 };
		int k = 3;
		maxSubArray(arr, k);
	}

	@Test
	public void example5() {
		int[] arr = { 0, 0, 0, 0 };
		int k = 1;
		maxSubArray(arr, k);
	}

	private void maxSubArray(int[] arr, int k) {
		int start = 0, end = 0;

		while (end < arr.length) {
			if (arr[end] == 0)
				k--;
			end++;
			if (k < 0) {
				if (arr[start] == 0)
					k++;
				start++;
			}
		}

		System.out.println(end - start);
	}

	/*
	 * Increase the window size up to which it has exactly K zeros if zero count in
	 * the window is more than K shrink the size of the window and calculate the
	 * zero count accordingly else if window has exactly K zeros, then compare the
	 * window size to previous window size and assign to a variable return the max
	 * window size
	 */

	private void maxSubArray1(int[] arr, int k) {
		int start = 0, end = 0;
		int maxWindow = Integer.MIN_VALUE;
		int sum = 0, zcnt = 0;

		while (end < arr.length) {
			if (arr[end] == 0)
				zcnt++;
			sum++;
			end++;
			if (zcnt > k) {
				sum--;
				if (arr[start] == 0)
					zcnt--;
				start++;
			}

			maxWindow = Math.max(maxWindow, sum);
		}
		System.out.println(maxWindow);
	}
}
