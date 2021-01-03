package sdet.week1.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/*
Given an unsorted integer array, find the smallest missing positive integer. // Simple 
    [2,8,10,1,0, 2,1] => 3
*/
public class SmallMissing {

	@Test
	public void ex1() {
		int[] arr = { 2, 8, 10, 1, 0, 2, 1 };
		int smallInt = smallMissPositiveInt(arr);
		System.out.println(smallInt);
	}

	@Test
	public void ex2() {
		int[] arr = { -3, -6, -9, -1, 0, 2 };
		int smallInt = smallMissPositiveInt(arr);
		System.out.println(smallInt);
	}

	@Test
	public void ex3() {
		int[] arr = { 6, 5, 2, 8, 10 };
		int smallInt = smallMissPositiveInt(arr);
		System.out.println(smallInt);
	}

	private int smallMissPositiveInt(int arr[]) {
		Set<Integer> set = new TreeSet<Integer>();
		for (int i : arr) {
			set.add(i);
		}

		List<Integer> list = new ArrayList<Integer>(set);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) != list.get(i - 1) + 1)
				return list.get(i - 1) + 1;
		}

		throw new RuntimeException("No smallest missing element");
	}

	private int smallMissPositiveInt1(int arr[]) {
		Arrays.sort(arr); // o[1]
		/*
		 * for (int i = 1; i < arr.length; i++) if (arr[i] != arr[i - 1]) // o[N] if
		 * (arr[i] != arr[i - 1] + 1) // o[N] if (arr[i - 1] + 1 > 0) // o[N] return
		 * arr[i - 1] + 1; // o[1] else // o[N] continue; // o[N] throw new
		 * RuntimeException("No smallest missing element"); // o[1]
		 */

		for (int i = 1; i < arr.length; i++)
			if (arr[i] != arr[i - 1] && arr[i] != arr[i - 1] + 1 && arr[i - 1] + 1 > 0) // o[N]
				return arr[i - 1] + 1; // o[1]
			else // o[N]
				continue; // o[N]
		throw new RuntimeException("No smallest missing element"); // o[1]

		// o[1]+o[N]+o[1]+o[N]+o[N]+o[1]=o[3]+o[3N]=o[N]
	}
}
