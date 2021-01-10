package sdet.week_17.weekwork;
/*
https://leetcode.com/problems/jump-game-ii/
*/

import org.junit.Test;

public class JumpGameGreedy {
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
		if (nums.length < 2) {
			return 0;
		}

		int minJumps = 1;
		int i = 1;

		// Holds the max distance we can move currently
		// Initialized to starting index distance
		int curMaxDistance = nums[0];

		// Holds the maximum distance we can move after the next jump
		int nextMaxDistance = 0;

		while (i < nums.length) {
			// If we are not able to move anymore with this jump
			if (curMaxDistance == 0) {
				// Increase the minJumps
				minJumps++;

				// Make curMaxDistance as the nextMaxDistance saved while moving
				curMaxDistance = nextMaxDistance;

				// Reinitialize the nextMaxDistance
				nextMaxDistance = 0;
			} else {
				// Decrement the current and next maxDistance because this step needs to be
				// considered for both
				curMaxDistance--;
				nextMaxDistance--;

				// If the current value of nextMaxDistance is lower than something already in
				// the range initialize to that
				nextMaxDistance = Math.max(nextMaxDistance, nums[i]);
				i++;
			}
		}
		return minJumps;
	}

	private int findMinJump3(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return 0;
		}
		int jumps = 1;
		int max = nums[0];
		int next = nums[0];

		for (int i = 0; i < nums.length; i++) {
			if (i + nums[i] > next) { // finding the greatest jump we can make
				next = i + nums[i];
			}
			if (max == i && i != nums.length - 1) { // checking if end of window, then we will update the jump
				max = next; // add the highest value found till end of the window of jump
				jumps += 1;
			}
			if (max >= nums.length - 1) {
				break; // if the index becomes greater than lenght or equal
			}
		}
		return jumps;
	}

	private int findMinJump2(int[] nums) {
		if (nums.length == 1)
			return 0;

		int n = nums.length - 1;
		int count = 0;
		int reachable = 0;
		int pos = 0;

		for (int i = 0; i < n; i++) {
			reachable = Math.max(reachable, nums[i] + i);
			if (pos == i) {
				pos = reachable;
				count++;
			}
		}
		return count;
	}

	private int findMinJump1(int[] nums) {
		int jumps = 0;
		int currend = 0;
		int currfarthest = 0;
		// nums.length-1 cause we dont need to jump from end index
		for (int i = 0; i < nums.length - 1; i++) {
			// the farthest we can reach from a index
			currfarthest = Math.max(currfarthest, nums[i] + i);
			// if we reach end index before reaching currend we already
			// know that we should have jumped earlier so we will
			// update currend to farthest(i.e end index or greater)
			// increment jumps and break
			if (i == currend) {
				// when we reach currentend we need to take another jump
				jumps++;
				currend = currfarthest;
				// break the loop if we already reached end or further
				if (currend >= nums.length - 1) {
					break;
				}
			}

		}
		return jumps;
	}
}
