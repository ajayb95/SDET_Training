package sdet.assessment.dunzo;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given an integer array with 1's and 0's, sort the array such a way than 0's to end or 1's to end.
 * Find the min swap required so that the input array is swapped
 */
public class SortArray {

	@Test
	public void example1() {
		int[] arr = { 1, 0, 1, 0, 0, 0, 0, 1 };
		Assert.assertEquals(6, findMinSwap(arr));
	}

	@Test
	public void example2() {
		int[] arr = { 1, 0, 1, 1, 1, 1, 1 };
		Assert.assertEquals(1, findMinSwap(arr));
	}

	@Test
	public void example3() {
		int[] arr = { 1, 1, 1, 1, 0, 0, 0, 0 };
		Assert.assertEquals(0, findMinSwap(arr));
	}

	@Test
	public void example4() {
		int[] arr = { 1, 1, 1, 1, 0, 1, 0, 1 };
		Assert.assertEquals(3, findMinSwap(arr));
	}

	@Test
	public void example5() {
		int[] arr = { 0, 1, 0, 1 };
		Assert.assertEquals(1, findMinSwap(arr));
	}

	private int findMinSwap(int[] arr) {
		int[] arrcopy = Arrays.copyOfRange(arr, 0, arr.length);
		return Math.min(sortArray(arr, 0), sortArray(arrcopy, 1));
	}

	private int sortArray(int[] arr1, int target) {
		int left = 0, right = 0;
		int sum = 0;
		while (left < arr1.length) {
			if (arr1[left] == target) {
				int temp = arr1[right];
				arr1[right] = arr1[left];
				arr1[left] = temp;
				sum += left - right;
				left++;
				right++;
			} else
				left++;
		}

		return sum;
	}
}
