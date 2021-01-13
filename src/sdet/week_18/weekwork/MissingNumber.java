package sdet.week_18.weekwork;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array nums containing n distinct numbers in the range [0, n], 
return the only number in the range that is missing from the array.

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
*/

public class MissingNumber {

	@Test
	public void example1() {
		int[] nums = { 3, 0, 1 };
		Assert.assertEquals(2, findMissingNumber(nums));
	}

	@Test
	public void example2() {
		int[] nums = { 0, 1 };
		Assert.assertEquals(2, findMissingNumber(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		Assert.assertEquals(8, findMissingNumber(nums));
	}

	@Test
	public void example4() {
		int[] nums = { 0 };
		Assert.assertEquals(1, findMissingNumber(nums));
	}

	private int findMissingNumber(int[] nums) {
		int missingNum = nums.length;

		for (int i = 0; i < nums.length; i++)
			missingNum ^= i ^ nums[i];

		return missingNum;
	}
}
