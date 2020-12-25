package sdet.week_11.homework;

import java.util.Arrays;

import org.junit.Test;

/*
Write a program to fetch the sub array of length k from a given array and the sub array must have maximum sum of all combinations (without sorting the array)

Input: [4,2,11,1,23,2,3,15,14] , k = 3
Output: [11,1,23]

Input: [4,2,1,-7,23,2,-3,15,14], k = 4
Output: [2,-3,15,14]

Algorithm: Sliding Window
*/

//Pseudo code
/*
create 2 variables, start and end
first add k elements to window i.e. find sum of first k elements and increment end
assume first window is with maximum sum
now remove start element and add end element and increment both
now check whether sum of current window is greater than previous max
if yes, store current window as window with max sum
iterate till end of the array and return the window with maximum sum
*/

public class MaxSubarraySum {

	@Test
	public void example1() {
		int[] arr = { 4, 2, 11, 1, 23, 2, 3, 15, 14 };
		int k = 3;
		maxSubarray(arr, k);
	}

	@Test
	public void example2() {
		int[] arr = { 4, 2, 1, -7, 23, 2, -3, 15, 14 };
		int k = 4;
		maxSubarray(arr, k);
	}

	@Test
	public void example3() {
		int[] arr = { 4, 2, 1 };
		int k = 2;
		maxSubarray(arr, k);
	}

	private void maxSubarray(int[] arr, int k) {
		int start = 0, end = 0;
		int sum = 0, maxSum = Integer.MIN_VALUE;
		int[] copyOfRange = null;
		while (end < arr.length) {
			sum += arr[end++];

			if (end >= k) {
				if (sum > maxSum) {
					maxSum = sum;
					copyOfRange = Arrays.copyOfRange(arr, start, end);
				}
				sum -= arr[start++];
			}
		}
		System.out.println(Arrays.toString(copyOfRange));
	}
}
