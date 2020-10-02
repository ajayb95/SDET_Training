package sdet.week1.array;

import java.util.Arrays;

import org.junit.Test;

public class ArrayIntersection {

	@Test
	public void eg1() {
		System.out.println("Method 1");
		int arr1[] = { 1, 2, 4, 5 };
		int arr2[] = { 2, 4, 7, 9 };
		arrIntersec(arr1, arr2);
		arrIntersec1(arr1, arr2);
	}
	
	@Test
	public void eg2() {
		System.out.println("Method 2");
		int arr1[] = { 1, 2, 4, 5 };
		int arr2[] = { 1, 2, 4, 5 };
		arrIntersec(arr1, arr2);
		arrIntersec1(arr1, arr2);
	}
	
	@Test
	public void eg3() {
		System.out.println("Method 3");
		int arr1[] = { 1, 2, 4, 5 };
		int arr2[] = { 2, 4, 7, 9 };
		arrIntersec(arr1, arr2);
		arrIntersec1(arr1, arr2);
	}
	
	@Test
	public void eg4() {
		System.out.println("Method 4");
		int arr1[] = { 1, 2, 4, 5 };
		int arr2[] = { 2, 4, 7, 9 };
		arrIntersec(arr1, arr2);
		arrIntersec1(arr1, arr2);
	}

	private void arrIntersec(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j])
					System.out.println(arr1[i]);
			}
		}
	}

	private void arrIntersec1(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			if (Arrays.binarySearch(arr2, arr1[i]) >= 0)
				System.out.println(arr1[i]);
		}
	}
}
