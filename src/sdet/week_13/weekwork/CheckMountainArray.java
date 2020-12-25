package sdet.week_13.weekwork;

import org.junit.Test;

public class CheckMountainArray {

	@Test
	public void example1() {
		int[] arr = { 0, 2, 3, 4, 5, 2, 1, 0 };
		System.out.println(checkArray(arr));
	}

	@Test
	public void example2() {
		int[] arr = { 0, 2, 3, 3, 5, 2, 1, 0 };
		System.out.println(checkArray(arr));
	}

	@Test
	public void example3() {
		int[] arr = { 5, 4, 3, 2, 1 };
		System.out.println(checkArray(arr));
	}

	@Test
	public void example4() {
		int[] arr = { 0, 3, 2, 1 };
		System.out.println(checkArray(arr));
	}

	@Test
	public void example5() {
		int[] arr = { 1, 2 };
		System.out.println(checkArray(arr));
	}

	private boolean checkArray(int[] arr) {
		if (arr.length < 3)
			return false;

		boolean inc = false, dec = false;

		for (int cur = 1; cur < arr.length; cur++) {
			if (arr[cur] > arr[cur - 1] && !dec)
				inc = true;
			else if (arr[cur] < arr[cur - 1])
				dec = true;
			else
				return false;
		}

		if (!inc || !dec)
			return false;

		return true;
	}
}
