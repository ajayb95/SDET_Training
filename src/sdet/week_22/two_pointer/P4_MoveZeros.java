package sdet.week_22.two_pointer;

import java.util.Arrays;

import org.junit.Test;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
*/

public class P4_MoveZeros {

	@Test
	public void example1() {
		int[] nums = { 0, 1, 0, 3, 12 };
		//moveZeroToEnd(nums);
		//System.out.println(Arrays.toString(nums));
		
		System.out.println(Arrays.toString(moveZeroToEnd(nums)));
	}

	private void moveZeroToEnd1(int[] nums) {
		int nzero = 0, zero = 0;

		while (nzero < nums.length) {
			if (nums[nzero] != 0) {
				nums[zero++] = nums[nzero];
				nums[nzero] = 0;
			} else
				nzero++;
		}
	}

	private int[] moveZeroToEnd(int[] nums) {
		int len = nums.length;
		int left = 0, lind = 0;
		int right = len - 1, rind = len - 1;
		int[] output = new int[len];

		while (left < len && right >= 0) {
			if (nums[left++] != 0)
				output[lind++] = nums[left - 1];
			if (nums[right--] == 0)
				output[rind--] = nums[right + 1];
		}
		
		return output;
	}
}
