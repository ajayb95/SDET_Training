package sdet.week0.warmup;

import java.util.Arrays;

import org.junit.Test;

public class RotateArray {

	/*
	 * Given an array, rotate the array to the right by k steps, where k is
	 * non-negative. Follow up: Try to come up as many solutions as you can, there
	 * are at least 3 different ways to solve this problem. Could you do it in-place
	 * with O(1) extra space?
	 * 
	 * Example 1: Input: nums = [1,2,3,4,5,6,7], k = 3 Output: [5,6,7,1,2,3,4]
	 * Explanation: rotate 1 steps to the right: [7,1,2,3,4,5,6] rotate 2 steps to
	 * the right: [6,7,1,2,3,4,5] rotate 3 steps to the right: [5,6,7,1,2,3,4]
	 * 
	 * Example 2: Input: nums = [-1,-100,3,99], k = 2 Output: [3,99,-1,-100]
	 * Explanation: rotate 1 steps to the right: [99,-1,-100,3] rotate 2 steps to
	 * the right: [3,99,-1,-100]
	 * 
	 * Constraints: 1 <= nums.length <= 2 * 104 -231 <= nums[i] <= 231 - 1 0 <= k <=
	 * 105
	 */

	@Test
	public void example1() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotateAnArray(nums, k);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example2() {
		int[] nums = { -1 };
		int k = 2;
		rotateAnArray(nums, k);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 1, 2 };
		int k = 3;
		rotateAnArray(nums, k);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example4() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = -2;
		rotateAnArray(nums, k);
		System.out.println(Arrays.toString(nums));
	}

	public void rotateAnArray(int[] nums, int k) {
		int len = nums.length;

		if (len < 2)
			return;

		if (k > 0) {
			k %= len;
			rotate(nums, 0, len - 1);
			rotate(nums, 0, k - 1);
			rotate(nums, k, len - 1);
			return;
		}

		k = Math.abs(k);
		k %= len;
		rotate(nums, 0, len - 1);
		rotate(nums, 0, len - k - 1);
		rotate(nums, len - k, len - 1);
	}

	public void rotate(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
	}
}
