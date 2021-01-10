package sdet.week_17.sorting;

import java.util.Arrays;

import org.junit.Test;

public class BubbleSort {

	@Test
	public void example1() {
		int[] nums = { 4, 11, 18, 2, 17, 22, 1 };
		bubbleSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example2() {
		int[] nums = { -5, 5, -4, 1, -2, -3, -6 };
		bubbleSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		bubbleSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example4() {
		int[] nums = { 2, 1, 3, 2, 4, 6, 5 };
		bubbleSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	private void bubbleSort(int[] nums) {
		boolean flag;
		for (int i = 0; i < nums.length; i++) {
			flag = false;
			for (int j = 1; j < nums.length - i; j++) {
				if (nums[j - 1] > nums[j]) {
					flag=true;
					int temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
				}
			}
			if (!flag)
				break;
		}
	}
}
