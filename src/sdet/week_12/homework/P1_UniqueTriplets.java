package sdet.week_12.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
Given an array nums of n integers, 
are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:

Input: nums = []
Output: []
*/

public class P1_UniqueTriplets {

	@Test
	public void example1() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		System.out.println(uniqueTriplets(nums));
	}

	@Test
	public void example2() {
		int[] nums = {};
		System.out.println(uniqueTriplets(nums));
	}

	private List<List<Integer>> uniqueTriplets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		int sum = 0;
		Arrays.sort(nums);
		findTriplets(nums, list, new ArrayList<>(), sum, 0);
		return list;
	}

	private void findTriplets(int[] nums, List<List<Integer>> list, List<Integer> combo, int sum, int start) {
		if (combo.size() == 3 && sum == 0) {
			List<Integer> temp = new ArrayList<>(combo);
			if (!list.contains(temp))
				list.add(temp);
			return;
		}

		if (combo.size() == 3 && sum != 0)
			return;

		for (int i = start; i < nums.length; i++) {
			combo.add(nums[i]);
			findTriplets(nums, list, combo, sum + nums[i], i + 1);
			combo.remove(combo.size() - 1);
		}
	}

	private Set<String> uniqueTriplets2(int[] nums) {
		Set<String> set = new HashSet<>();
		if (nums.length < 3)
			return new HashSet<>();

		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if ((nums[i] + nums[j] + nums[k]) == 0) {
						int[] a = new int[3];
						a[0] = nums[i];
						a[1] = nums[j];
						a[2] = nums[k];
						Arrays.sort(a);
						set.add(Arrays.toString(a));
					}
				}
			}
		}

		return set;
	}

	private Set<String> uniqueTriplets1(int[] nums) {
		Set<String> set = new HashSet<>();
		if (nums.length < 3)
			return new HashSet<>();

		int start = 0, sum = 0;
		for (int end = 0; end < nums.length; end++) {
			sum += nums[end];

			if (end >= 3)
				sum -= nums[start++];

			if (end >= 2 && sum == 0)
				set.add(Arrays.toString(Arrays.copyOfRange(nums, start, end + 1)));
		}
		return set;
	}
}
