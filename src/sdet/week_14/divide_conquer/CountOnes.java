package sdet.week_14.divide_conquer;

import java.util.Arrays;

import org.junit.Test;

public class CountOnes {

	@Test
	public void example1() {
		int[] nums = { 0, 0, 1, 1, 1, 1, 1 };
		System.out.println(countOnes(nums));
	}

	@Test
	public void example2() {
		int[] nums = { 0, 0, 0, 0, 1, 1, 1 };
		System.out.println(countOnes(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 1, 1, 1, 1, 1 };
		System.out.println(countOnes(nums));
	}

	@Test
	public void example4() {
		int[] nums = { 0, 0, 0, 0, 0 };
		System.out.println(countOnes(nums));
	}

	private int countOnes(int[] nums) {
		return recursion(nums, 0, nums.length - 1);
	}

	private int recursion(int[] nums, int start, int end) {
		if (nums[end] == 0)
			return 0;

		if (nums[start] == 1)
			return (end - start) + 1;

		int mid = (start + end) / 2;

		return recursion(nums, start, mid) + recursion(nums, mid + 1, end);
	}
}
