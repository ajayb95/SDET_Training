package sdet.week_22.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they product up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,4,15], target = 8
Output: [0,3]
Output: Because nums[0] * nums[3] == 8, we return [0, 3].
*/

public class P1_FindTwoProduct {

	@Test
	public void example1() {
		int[] nums = { 2, 7, 11, 4, 15 };
		int target = 8;
		System.out.println(Arrays.toString(findIndices(nums, target)));
	}

	@Test
	public void example2() {
		int[] nums = { 2, 7, 11, 4, 15 };
		int target = 65;
		System.out.println(Arrays.toString(findIndices(nums, target)));
	}
	
	@Test
	public void example3() {
		int[] nums = { -2, -7, -11, -4, -15 };
		int target = 30;
		System.out.println(Arrays.toString(findIndices(nums, target)));
	}
	
	@Test
	public void example4() {
		int[] nums = { -2, -7, -11, 4, 15 };
		int target = -28;
		System.out.println(Arrays.toString(findIndices(nums, target)));
	}

	private int[] findIndices(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0 && target % nums[i] == 0 && map.containsKey(target / nums[i]))
				return new int[] { map.get(target / nums[i]), i };
			else
				map.put(nums[i], i);
		}

		return new int[] { -1, -1 };
	}
}
