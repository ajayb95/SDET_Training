package sdet.week_17.sorting;

import java.util.Arrays;

import org.junit.Test;

public class SelectionSort {

	@Test
	public void example1() {
		int[] nums = { 4, 11, 18, 2, 17, 22, 1 };
		selectionSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example2() {
		int[] nums = { -5, 5, -4, 1, -2, -3, -6 };
		selectionSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		selectionSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example4() {
		int[] nums = { 2, 1, 3, 2, 4, 6, 5 };
		selectionSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example5() {
		int[] nums = { 1, 2, 5, 4, 3 };
		selectionSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	private void selectionSort(int[] nums) {
		int minEl = 0, minInd = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			minEl = nums[i];
			minInd = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < minEl) {
					minEl = nums[j];
					minInd = j;
				}
			}
			int temp = nums[i];
			nums[i] = nums[minInd];
			nums[minInd] = temp;
		}
	}
}
