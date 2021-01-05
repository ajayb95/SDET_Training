package sdet.week_17_weekwork;
/*
https://leetcode.com/problems/jump-game-ii/
*/

import org.junit.Test;

public class JumpGame {
	int minJump = Integer.MAX_VALUE;

	@Test
	public void example1() {
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(findMinJump(nums));
	}

	@Test
	public void example2() {
		int[] nums = { 2, 3, 0, 1, 4 };
		System.out.println(findMinJump(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 9, 8, 2, 2, 0, 2, 2, 0, 4, 1, 5, 7, 9, 6, 6, 0, 6, 5, 0, 5 };
		System.out.println(findMinJump(nums));
	}

	@Test
	public void example4() {
		int[] nums = { 3, 4, 3, 1, 0, 7, 0, 3, 0, 2, 0, 3 };
		System.out.println(findMinJump(nums));
	}

	private int findMinJump(int[] nums) {
		if (nums.length == 1)
			return 0;

		helperFunction(nums, 0, 0);
		return minJump;
	}

	private void helperFunction(int[] nums, int tempJump, int start) {
		if (start >= nums.length - 1) {
			if (start > nums.length - 1)
				tempJump += 1;
			minJump = Math.min(minJump, tempJump);
			return;
		}

		if (nums[start] == 0)
			return;

		for (int i = start; i < nums.length; i++) {
			int cur = nums[i];
			while (cur > 0) {
				helperFunction(nums, tempJump + 1, i + cur);
				cur--;
			}
			if (nums[i] == 0 || cur == 0)
				return;
		}
	}
}
