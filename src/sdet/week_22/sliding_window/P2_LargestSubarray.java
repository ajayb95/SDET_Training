package sdet.week_22.sliding_window;

import java.util.Arrays;

import org.junit.Test;

/*
In array A is larger than some array B if for the first index i where A[i] != B[i], A[i] > B[i].
For example, consider 0-indexing:
[1,3,2,4] > [1,2,2,4], since at index 1, 3 > 2.
[1,4,4,4] < [2,1,1,1], since at index 0, 1 < 2.
A subarray is a contiguous subsequence of the array.
Given an integer array nums of distinct integers, return the largest subarray of nums of length k.

Example 1:
Input: nums = [1,4,5,2,3], k = 3
Output: [5,2,3]
Explanation: The subarrays of size 3 are: [1,4,5], [4,5,2], and [5,2,3].
Of these, [5,2,3] is the largest.
Example 2:
Input: nums = [1,4,5,2,3], k = 4
Output: [4,5,2,3]
Explanation: The subarrays of size 4 are: [1,4,5,2], and [4,5,2,3].
Of these, [4,5,2,3] is the largest.
*/

public class P2_LargestSubarray {

	@Test
	public void example1() {
		int[] nums = { 1, 4, 5, 2, 3 };
		int k = 3;
		System.out.println(Arrays.toString(getLargestSubarray(nums, k)));
	}

	@Test
	public void example2() {
		int[] nums = { 1, 4, 5, 2, 3 };
		int k = 4;
		System.out.println(Arrays.toString(getLargestSubarray(nums, k)));
	}

	@Test
	public void example3() {
		int[] nums = { 1, 1, 1, 3 };
		int k = 3;
		System.out.println(Arrays.toString(getLargestSubarray(nums, k)));
	}

	@Test
	public void example4() {
		int[] nums = { 4, 6, 2, 6, 2, 2, 7 };
		int k = 4;
		System.out.println(Arrays.toString(getLargestSubarray(nums, k)));
	}

	@Test
	public void example5() {
		int[] nums = { 4, 0, 6, 0, 2, 6, 2, 2 };
		int k = 3;
		System.out.println(Arrays.toString(getLargestSubarray(nums, k)));
	}

	@Test
	public void example6() {
		int[] nums = { 4, 0, 2, 0, 2, 4, 0, 3 };
		int k = 3;
		System.out.println(Arrays.toString(getLargestSubarray(nums, k)));
	}

	@Test
	public void example7() {
		int[] nums = { 0, 0, 2, 0, 2, 4, 0, 2 };
		int k = 3;
		System.out.println(Arrays.toString(getLargestSubarray(nums, k)));
	}

	private int[] getLargestSubarray(int[] nums, int k) {
		int prev = 0;
		for (int i = 1, cnt = 0; i <= nums.length - k; i++) {
			if (nums[prev] < nums[i])
				prev = i;

			cnt = 0;
			while (nums[prev] == nums[i] && ++cnt < k && nums[prev + cnt] <= nums[i + cnt]) {
				if (nums[prev + cnt] < nums[i + cnt]) {
					prev = i;
					break;
				}
			}
		}

		return Arrays.copyOfRange(nums, prev, prev + k);
	}
}
