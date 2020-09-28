package sdet.ds.week1hw;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
Given 3 integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, 
return a sorted array of only the integers that appeared in all three arrays.

Input: arr1=[1,2,3,4,5], arr2=[1,2,5,7,9], arr3=[1,3,4,5,8]
Output: [1,5]

Explanation: Only 1 and 5 appeared in the 3 arrays.
*/

public class TC007_ArrayIntersection {
	@Test
	public void example1() {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 1, 2, 5, 7, 9 };
		int[] arr3 = { 1, 3, 4, 5, 8 };

		bruteForce_2(arr1, arr2, arr3);
	}

	private void bruteForce_1(int[] arr1, int[] arr2, int[] arr3) {
		List<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j])
					temp.add(arr1[i]);
			}
		}

		for (int i : temp) {
			for (int j = 0; j < arr3.length; j++) {
				if (i == arr3[j])
					System.out.println(i);
			}
		}
	}

	private void bruteForce_2(int[] arr1, int[] arr2, int[] arr3) {
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					for (int k = 0; k < arr3.length; k++) {
						if (arr1[i] == arr3[k])
							System.out.println(arr1[i]);
					}
				}
			}
		}
	}

	private void bruteForce_3(int[] arr1, int[] arr2, int[] arr3) {
	}
}
