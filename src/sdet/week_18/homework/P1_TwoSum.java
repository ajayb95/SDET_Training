package sdet.week_18.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*
https://leetcode.com/problems/two-sum/
*/

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/

public class P1_TwoSum {

	@Test
	public void example1() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		Assert.assertEquals(Arrays.toString(new int[] { 0, 1 }), Arrays.toString(findSumIndices(nums, target)));
	}

	@Test
	public void example2() {
		int[] nums = { 3, 2, 4 };
		int target = 6;
		Assert.assertEquals(Arrays.toString(new int[] { 1, 2 }), Arrays.toString(findSumIndices(nums, target)));
	}

	@Test
	public void example3() {
		int[] nums = { 3, 3 };
		int target = 6;
		Assert.assertEquals(Arrays.toString(new int[] { 0, 1 }), Arrays.toString(findSumIndices(nums, target)));
	}
	
	//Method 1
	//Pseudo code
	/*
	 * Create a map to add current element as key as its corresponding index as value
	 * iterate through each element in the array
	 * check if the target-current element is already present in the map
	 	* if present, return the index of target-current element and current element
	 	* else add the current element and it's index to map 
	 */
	//Space complexity: O[N]
	//Time complexity: O[N]
	private int[] findSumIndices(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i]))
				return new int[] { map.get(target - nums[i]), i };
			else
				map.put(nums[i], i);
		}
		throw new RuntimeException("No indices found");
	}
	
	//Method 2
	//Space complexity: O[N]
	//Time complexity: O[N]
	private int[] findSumIndices2(int[] nums, int target) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (list.contains(target - nums[i]))
				return new int[] { list.indexOf(target - nums[i]), i };
			else
				list.add(nums[i]);
		}
		throw new RuntimeException("No indices found");
	}
	
	//Brute force
	//Space complexity: O[1]
	//Time complexity: O[N*M]
	private int[] findSumIndices1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target)
					return new int[] { i, j };
			}
		}
		throw new RuntimeException("No indices found");
	}
}
