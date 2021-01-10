package sdet.week_17.sorting;

import java.util.Arrays;

import org.junit.Test;

public class InsertionSort {

	@Test
	public void example1() {
		int[] nums = { 4, 11, 18, 2, 17, 22, 1 };
		insertionSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example2() {
		int[] nums = { -5, 5, -4, 1, -2, -3, -6 };
		insertionSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		insertionSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example4() {
		int[] nums = { 2, 1, 3, 2, 4, 6, 5 };
		insertionSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example5() {
		int[] nums = { 1, 2, 5, 4, 3 };
		insertionSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	private void insertionSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) { // Check adjacent
				swap(nums, i, i + 1); // If lesser, swap
				// once swapped, check the left side of the array from pivot
				for (int j = i; j > 0; j--)	
					if (nums[j] < nums[j - 1])	//swap to get left end array as sorted one
						swap(nums, j, j - 1);
			}
		}
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
}
