package sdet.week_17.classwork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
*/

public class TwoSum {

	@Test
	public void example1() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		Assert.assertEquals(Arrays.toString(new int[] { 0, 1 }), Arrays.toString(bruteForce(nums, target)));
		Assert.assertEquals(Arrays.toString(new int[] { 0, 1 }), Arrays.toString(hashingTech(nums, target)));
		Assert.assertEquals(Arrays.toString(new int[] { 0, 1 }), Arrays.toString(TwoPointer(nums, target)));
	}

	@Test
	public void example2() {
		int[] nums = { 3, 2, 4 };
		int target = 6;
		Assert.assertEquals(Arrays.toString(new int[] { 1, 2 }), Arrays.toString(bruteForce(nums, target)));
		Assert.assertEquals(Arrays.toString(new int[] { 1, 2 }), Arrays.toString(hashingTech(nums, target)));
		Assert.assertEquals(Arrays.toString(new int[] { 1, 2 }), Arrays.toString(TwoPointer(nums, target)));
	}

	@Test
	public void example3() {
		int[] nums = { 3, 2, 4 };
		int target = 10;
		bruteForce(nums, target);
		hashingTech(nums, target);
	}

	// Space: O[1]
	// Time: O[M*N]
	private int[] bruteForce(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target)
					return new int[] { i, j };
			}
		}

		throw new RuntimeException("No indices found");
	}
	
	//Space: O[N]
	//Time: O[N log N]
	private int[] TwoPointer(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], i);

		Arrays.sort(nums);

		int left = 0, right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == target)
				return new int[] { map.get(nums[left]), map.get(nums[right]) };
			else if (nums[left] + nums[right] < target)
				left++;
			else
				right--;
		}

		throw new RuntimeException("No indices found");
	}

	// Space: O[N]
	// Time: O[N]
	private int[] hashingTech(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i]))
				return new int[] { map.get(target - nums[i]), i };
			else
				map.put(nums[i], i);
		}
		throw new RuntimeException("No indices found");
	}
}
