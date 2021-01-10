package sdet.week_17.sorting;

import java.util.Arrays;

import org.junit.Test;

public class MergeSort {

	@Test
	public void example1() {
		int[] input = { 6, 5, 3, 1, 8, 7, 2, 4 };
		mergeSort(input);
		System.out.println(Arrays.toString(input));
	}

	@Test
	public void example2() {
		int[] nums = { 4, 11, 18, 2, 17, 22, 1 };
		mergeSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example3() {
		int[] nums = { -5, 5, -4, 1, -2, -3, -6 };
		mergeSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example4() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		mergeSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example5() {
		int[] nums = { 2, 1, 3, 2, 4, 6, 5 };
		mergeSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	@Test
	public void example6() {
		int[] nums = { 1, 2, 5, 4, 3 };
		mergeSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	private void mergeSort(int[] input) {
		divide(input, 0, input.length - 1);
	}

	private void divide(int[] input, int left, int right) {
		if (left == right)
			return;

		if (left < right) {
			int mid = (left + right) / 2;
			divide(input, left, mid);
			divide(input, mid + 1, right);
			merge(input, left, mid, right);
		}

	}

	private void merge(int[] input, int left, int mid, int right) {
		int[] larr = Arrays.copyOfRange(input, left, mid + 1);
		int[] rarr = Arrays.copyOfRange(input, mid + 1, right + 1);
		int p1 = 0, p2 = 0;
		int ind = left;
		while (p1 < larr.length && p2 < rarr.length) {
			if (larr[p1] <= rarr[p2])
				input[ind++] = larr[p1++];
			else
				input[ind++] = rarr[p2++];
		}

		while (p1 < larr.length)
			input[ind++] = larr[p1++];

		while (p2 < rarr.length)
			input[ind++] = rarr[p2++];
	}
}
