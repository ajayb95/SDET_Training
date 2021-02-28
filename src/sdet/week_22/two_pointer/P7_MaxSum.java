package sdet.week_22.two_pointer;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.
 
Example 1:
Input: nums = [34,23,1,24,75,33,54,8], k = 60
Output: 58
Explanation: We can use 34 and 24 to sum 58 which is less than 60.
*/

public class P7_MaxSum {

	@Test
	public void example1() {
		int[] nums = { 34, 23, 1, 24, 75, 33, 54, 8 };
		int k = 60;
		Assert.assertEquals(58, findMaxSum(nums, k));
	}

	@Test
	public void example2() {
		int[] nums = { 10, 20, 30 };
		int k = 15;
		Assert.assertEquals(-1, findMaxSum(nums, k));
	}

	private int findMaxSum(int[] nums, int k) {
		Arrays.sort(nums);

		int left = 0, right = nums.length - 1;
		int maxSum = Integer.MIN_VALUE;
		while (left < right) {
			if (nums[left] + nums[right] >= k)
				right--;
			else
				maxSum = Math.max(maxSum, nums[left++] + nums[right]);
		}

		return (maxSum == Integer.MIN_VALUE) ? -1 : maxSum;
	}
}
