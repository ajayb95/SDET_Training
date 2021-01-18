package sdet.week_18.homework;

import java.util.Arrays;

import org.junit.Test;

/*
https://leetcode.com/problems/product-of-array-except-self/
*/

/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] 
is equal to the product of all the elements of nums except nums[i].

Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array 
(including the whole array) fits in a 32 bit integer.
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? 
(The output array does not count as extra space for the purpose of space complexity analysis.)
*/

public class P7_PrdtOfArray {

	@Test
	public void example1() {
		int[] nums = { 1, 2, 3, 4 };
		productOfArray(nums);
	}

	@Test
	public void example2() {
		int[] nums = { 4, 5, 1, 8, 2, 10, 6 };
		productOfArray(nums);
	}

	@Test
	public void example3() {
		int[] nums = { 4, 5, 1, 8, 2 };
		productOfArray(nums);
	}

	private void productOfArray(int[] nums) {
		int len = nums.length;
		int[] output = new int[len];
		int prev = 1;
		output[0] = prev;
		for (int i = 1; i < len; i++) {
			output[i] = nums[i - 1] * prev;
			prev = output[i];
		}
		prev = 1;
		for (int i = len - 1; i >= 0; i--) {
			output[i] *= prev;
			prev *= nums[i];
		}
		System.out.println(Arrays.toString(output));
	}
}
