package sdet.week1.array;

import java.util.Arrays;

import org.junit.Test;

public class SquareofSortedArray {

	@Test
	public void example1() {
		int[] nums = { -4, -1, 0, 3, 10 };
		System.out.println(Arrays.toString(sortedSquares(nums)));
	}

	@Test
	public void example2() {
		int[] nums = { -7, -3, 2, 3, 11 };
		System.out.println(Arrays.toString(sortedSquares(nums)));
	}

	public int[] sortedSquares(int[] nums) {
		if (nums.length == 0)
			return nums;

		for (int k = 0; k < nums.length; k++)
			nums[k] *= nums[k];

		int i = 0, j = nums.length - 1, index = nums.length - 1;
		int[] temp = new int[nums.length];

		while (i <= j) {
			if (nums[i] > nums[j])
				temp[index--] = nums[i++];
			else
				temp[index--] = nums[j--];
		}

		return temp;

	}

}
