package sdet.week_19.weekwork;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
1) Given list of integers, find 2 numbers which matches the product
without using map
*/
public class FW_ProductOfTwo {

	@Test
	public void example1() {
		int[] nums = { 4, 7, 6, 9, 3, 1, 1 };
		int target = 18;
		Assert.assertEquals(Arrays.toString(new int[] { 6, 3 }), Arrays.toString(productOfTwo(nums, target)));
	}

	@Test
	public void example2() {
		int[] nums = { 4, 9, 6, 2, 3 };
		int target = 18;
		Assert.assertEquals(Arrays.toString(new int[] { 9, 2 }), Arrays.toString(productOfTwo(nums, target)));
	}

	@Test
	public void example3() {
		int[] nums = { -1, 2, -8, -5, -2, 3 };
		int target = 40;
		Assert.assertEquals(Arrays.toString(new int[] { -8, -5 }), Arrays.toString(productOfTwo(nums, target)));
	}

	@Test
	public void example4() {
		int[] nums = { 1, 2, 4, 0, 0, 4 };
		int target = 16;
		Assert.assertEquals(Arrays.toString(new int[] { 4, 4 }), Arrays.toString(productOfTwo(nums, target)));
	}

	@Test
	public void example5() {
		int[] nums = { 1, 2, 3, 4, 5, 6 };
		int target = 50;
		Assert.assertEquals(Arrays.toString(new int[] {}), Arrays.toString(productOfTwo(nums, target)));
	}

	private int[] productOfTwo(int[] nums, int target) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			if (i == 0)
				continue;
			if (set.contains(target / i))
				return new int[] { target / i, i };
			else
				set.add(i);
		}
		return new int[] {};
	}

	private int[] productOfTwo1(int[] nums, int target) {
		Arrays.sort(nums);
		int p1 = 0, p2 = nums.length - 1;

		while (p1 < p2) {
			if (nums[p1] * nums[p2] == target)
				return new int[] { nums[p1], nums[p2] };
			if (nums[p1] * nums[p2] > target)
				p2--;
			else
				p1++;
		}

		return new int[] {};
	}
}
