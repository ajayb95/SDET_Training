package sdet.week1.array;

import java.util.Arrays;

import org.junit.Test;

public class RotateArray {

	@Test
	public void example1() {
		int arr[] = { 1, 3, 5, 7, 9, 11 };
		int times = 6;
		/*
		 * int[] rotateArr = rotateArr(arr, times);
		 * System.out.println(Arrays.toString(rotateArr));
		 */

		int[] rotArr = rotateArr1(arr, times);
		System.out.println(Arrays.toString(rotArr));
	}

	@Test
	public void example2() {
		int arr[] = { 1 };
		int times = 5;
		int[] rotArr = rotateArr1(arr, times);
		System.out.println(Arrays.toString(rotArr));
	}

	@Test
	public void example3() {
		int arr[] = { 1, 3, 5, 7, 9, 11 };
		int times = 7;
		int[] rotArr = rotateArr2(arr, times);
		System.out.println(Arrays.toString(rotArr));
	}

	// works only if no of times is lesser than array length
	private int[] rotateArr(int[] arr, int times) {
		int[] temp = new int[times]; // o[1]
		for (int i = 0; i < times; i++) {
			temp[i] = arr[i]; // o[N]
		}
		int ind = 0, nind = 0; // o[1]
		for (int j = times; j < arr.length; j++) {
			arr[ind++] = arr[j]; // o[N]
		}
		for (int k = ind; k < temp.length; k++) {
			arr[k] = temp[nind++]; // o[N]
		}
		// o[1]+o[N]+o[1]+o[N]+o[N]=o[2]+o[3N]=o[N]
		return arr;
	}

	// works for any size
	private int[] rotateArr1(int[] arr, int times) {
		for (int i = 0; i < times; i++) {
			int temp = arr[0], ind = 0;// o[M]
			for (int j = 1; j < arr.length; j++) {
				arr[ind++] = arr[j]; // o[N*M]
			}
			arr[ind] = temp; // o[M]
		}
		return arr; // o[1]

		// o[1]+o[M]+o[M]+o[N*M]=o[1]+o[2M]+o[N*M]=o[N+M]
	}

	private int[] rotateArr2(int[] arr, int times) {
		int rotate = 0;
		if (arr.length < times && times % arr.length != 0) {
			rotate = times % arr.length;
			for (int i = 0; i < rotate; i++) {
				int temp = arr[0], ind = 0;// o[M]
				for (int j = 1; j < arr.length; j++) {
					arr[ind++] = arr[j]; // o[N*M]
				}
				arr[ind] = temp; // o[M]
			}
			return arr; // o[1]
		} else {
			return arr;
		}
		// o[1]+o[M]+o[M]+o[N*M]=o[1]+o[2M]+o[N*M]=o[N+M]
	}
	
	/*
	 * private int[] rotateArr3(int[] arr, int times) { int rotate = 0; if
	 * (arr.length < times && times % arr.length != 0) { rotate = times %
	 * arr.length;
	 * 
	 * } else { return arr; } }
	 */
	
	
}
