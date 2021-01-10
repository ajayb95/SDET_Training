package sdet.week_17.classwork;

import org.junit.Assert;
import org.junit.Test;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum 
and return its sum.

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*/
public class FindMaxSubarraySum {

	@Test
	public void example1() {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		Assert.assertEquals(6, bruteForce(nums));
		Assert.assertEquals(6, KandaneAlgo(nums));
		Assert.assertEquals(6, divideConquer(nums));
	}

	@Test
	public void example2() {
		int[] nums = { -1, 2, 3, 5, -4, -2 };
		Assert.assertEquals(10, bruteForce(nums));
		Assert.assertEquals(10, KandaneAlgo(nums));
		Assert.assertEquals(10, divideConquer(nums));
	}

	// Space: O[1]
	// Time: O[N^2]
	private int bruteForce(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				maxSum = Math.max(sum, maxSum);
			}
		}
		return maxSum;
	}

	// Space: O[1]
	// Time: O[N]
	/*
	 * create a variable for sum and maxsum (to store maximum value) add consecutive
	 * elements if sum becomes less than or equal to 0, then make sum as 0 else
	 * compare the sum with previous maxsum
	 */
	private int KandaneAlgo(int[] nums) {
		int sum = 0, maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (sum <= 0)
				sum = 0;
			else
				maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

	private int divideConquer(int[] nums) {
		return divide(nums, 0, nums.length - 1);
	}

	private int divide(int[] nums, int left, int right) {
		if (left == right)
			return nums[left];

		int mid = left+(right-left) / 2;

		int leftSum = divide(nums, left, mid);
		int rightSum = divide(nums, mid + 1, right);
		int bothSum = conquer(nums, left, mid, right);

		return Math.max(leftSum, Math.max(bothSum, rightSum));
	}

	private int conquer(int[] nums, int left, int mid, int right) {
		int leftSum = 0;
		int leftMax = Integer.MIN_VALUE;
		for (int i = mid; i >=left; i--) {
			leftSum += nums[i];
			leftMax = Math.max(leftMax, leftSum);
		}

		int rightSum = 0;
		int rightMax = Integer.MIN_VALUE;
		for (int i = mid + 1; i <= right; i++) {
			rightSum += nums[i];
			rightMax = Math.max(rightMax, rightSum);
		}

		return leftMax + rightMax;

	}
}
