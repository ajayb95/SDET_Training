package sdet.week12.homework;
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining.

Input:
height=[0,1,0,2,1,0,1,3,2,1,2,1]
output=6
explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.
*/

import java.util.Arrays;

import org.junit.Test;

public class P1_RainwaterTrapping {

	@Test
	public void example1() {
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		rainTrapping(arr);
	}

	@Test
	public void example2() {
		int[] arr = { 6, 4, 1, 3 };
		rainTrapping(arr);
	}

	@Test
	public void example3() {
		int[] arr = { 3, 2, 4, 5 };
		rainTrapping(arr);
	}

	@Test
	public void example4() {
		int[] arr = { 0, 1, 0, 0, 0 };
		rainTrapping(arr);
	}

	@Test
	public void example5() {
		int[] arr = { 1, 3, 2, 1, 2, 1 };
		rainTrapping(arr);
	}

	private void rainTrapping(int[] arr) {
		int max = Integer.MIN_VALUE;
		int ind = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				ind = i;
				max = arr[i];
			}
		}

		int[] left = Arrays.copyOfRange(arr, 0, ind + 1);
		int[] right = Arrays.copyOfRange(arr, ind, arr.length);

		int cnt = 0;
		max = Integer.MIN_VALUE;

		if (left.length > 2) {
			for (int i = 0; i < left.length; i++) {
				if (max <= left[i])
					max = left[i];
				else
					cnt += max - left[i];
			}
		}
		max = Integer.MIN_VALUE;
		if (right.length > 2) {
			for (int i = right.length - 1; i >= 0; i--) {
				if (max <= right[i])
					max = right[i];
				else
					cnt += max - right[i];
			}
		}

		System.out.println(cnt);
	}

	private void rainTrapping1(int[] arr) {
		int l = 0, r = arr.length - 1;
		int lmax = Integer.MIN_VALUE;
		int rmax = Integer.MIN_VALUE;
		int cnt = 0;
		while (l < r) {
			if (arr[l] < arr[r]) {
				if (arr[l] >= lmax)
					lmax = arr[l];
				else
					cnt += lmax - arr[l];
				l++;
			} else {
				if (arr[r] >= rmax)
					rmax = arr[r];
				else
					cnt += rmax - arr[r];
				r--;
			}
		}

		System.out.println(cnt);
	}
}
