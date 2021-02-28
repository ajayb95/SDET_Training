package sdet.week_22.two_pointer;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray 
[numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, 
return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
*/

public class P1_MinSubarray {

	@Test
	public void example1() {
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int target = 7;
		Assert.assertEquals(2, findMinSubarray(nums, target));
	}

	@Test
	public void example2() {
		int[] nums = { 1, 4, 4 };
		int target = 4;
		Assert.assertEquals(1, findMinSubarray(nums, target));
	}

	@Test
	public void example3() {
		int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1 };
		int target = 11;
		Assert.assertEquals(0, findMinSubarray(nums, target));
	}

	private int findMinSubarray(int[] nums, int target) {
		int start = 0, sum = 0, minLen = Integer.MAX_VALUE;
		
		for (int end = 0; end < nums.length; end++) {
			sum += nums[end];

			while (sum >= target) {
				minLen = Math.min(minLen, end - start + 1);
				sum -= nums[start++];
			}
		}

		return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
	}
}
