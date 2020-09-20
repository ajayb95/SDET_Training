package sdet.ds.array;

import org.junit.Test;

public class SlidingWindow {

	@Test
	public void eg1() {
		System.out.println("Test 1");
		int arr[] = { 1, 5, 3, 7, 1, 2 };
		int k = 3;
		maxSeq(arr, k);
	}

	@Test
	public void eg2() {
		System.out.println("Test 2");
		int arr[] = { 1, 5, 3, 7, 1, 8 };
		int k = 3;
		maxSeq(arr, k);
	}

	@Test
	public void eg3() {
		System.out.println("Test 3");
		int arr[] = { 1, 5, -3, 7, 1, -8 };
		int k = 3;
		maxSeq1(arr, k);
	}

	@Test
	public void eg4() {
		System.out.println("Test 4");
		int arr[] = { 1, 5, -3, 7, 1, -8 };
		int k = 7;
		maxSeq1(arr, k);
	}
	
	private void maxSeq(int[] arr, int k) {
		int max = 0, op = 0;

		for (int i = 0; i < k; i++) {
			max += arr[i];
		}
		op = max;
		for (int j = 1; j < arr.length; j++) {
			if (j + 3 <= arr.length) {
				op = op - arr[j - 1] + arr[j + k - 1];
				if (op > max)
					max = op;
			}
		}
		System.out.println(max);
	}

	private void maxSeq1(int[] arr, int k) {
		
		if(k>arr.length)
			throw new IllegalArgumentException("Invalid frame");
		int max = 0, op = 0;

		for (int i = 0; i < k; i++) {
			max += arr[i];
		}
		op = max;

		for (int j = k; j < arr.length; j++) {
			op += arr[j] - arr[j - k];
			max = Math.max(max, op);
		}
		System.out.println(max);
	}
}
