package sdet.week_14.divide_conquer;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfRotations {

	@Test
	public void example1() {
		int[] nums = { 1, 2, 3, 4 }; // 0
		Assert.assertEquals(0, findRotationCount(nums));
	}

	@Test
	public void example2() {
		int[] nums = { 4, -2, -1, 3 }; // 1
		Assert.assertEquals(1, findRotationCount(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 5, 6, 7, 1, 3, 4 }; // 3
		Assert.assertEquals(3, findRotationCount(nums));
	}

	@Test
	public void example4() {
		int[] nums = { 5, 1, 2, 3, 4 };
		Assert.assertEquals(1, findRotationCount(nums));
	}

	@Test
	public void example5() {
		int[] nums = { 2, 3, 4, 5, 6, 1 };
		Assert.assertEquals(5, findRotationCount(nums));
	}

	private int findRotationCount(int[] nums) {
		return divideConquer(nums, 0, nums.length - 1);
	}

	private int divideConquer(int[] nums, int left, int right) {
		if (left == right || nums[right] > nums[left])
			return left;

		int mid = (left + right) / 2;

		if (mid > left && nums[mid - 1] > nums[mid])
			return mid;

		if (mid < right && nums[mid] > nums[mid + 1])
			return mid + 1;

		if (nums[right] < nums[left])
			return divideConquer(nums, left, mid);
		else
			return divideConquer(nums, mid + 1, right);

	}
}
