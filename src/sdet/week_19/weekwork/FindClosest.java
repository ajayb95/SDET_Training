package sdet.week_19.weekwork;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.*;

import org.junit.Test;

/*
Find the closest element for each number

Input: arr[]={2,1,5,8,3}
Output: -1 2 2 5 2

Explanation:
[2], it is the only number in this prefix. Hence, the answer is -1.
[2,1], the closest number to 1 is 2.
[2,1,5], the closest number to 5 is 2.
[2,1,5,8], the closest number to 8 is 5.
[2,1,5,8,3], the closest number to 3 is 2.
*/

public class FindClosest {

	@Test
	public void example1() {
		int[] arr = { 2, 1, 5, 8, 3 };
		findEachClosestNumbers(arr);
	}

	@Test
	public void example2() {
		int[] arr = { 1, 2, 1, 4, 6, 5, 5, 1 };
		findEachClosestNumbers(arr);
	}

	@Test
	public void example3() {
		int[] arr = { 3, 3, 2, 4, 6, 5, 5, 1 };
		findEachClosestNumbers(arr);
	}

	// Red-Black Tree implementation
	private void findEachClosestNumbers(int[] arr) {
		TreeSet<Integer> set = new TreeSet<>();
		int up, down;
		// O[N log N]
		for (int i = 0; i < arr.length; i++) {
			set.remove(arr[i]); // O[log N]
			try {
				up = set.ceiling(arr[i]); // O[log N]
			} catch (Exception e) {
				up = -1;
			}
			try {
				down = set.floor(arr[i]); // O[log N]
			} catch (Exception e) {
				down = -1;
			}

			if (up == arr[i])
				up = -1;
			if (down == arr[i])
				down = -1;

			set.add(arr[i]);

			if (up == -1 && down == -1)
				arr[i] = -1;
			else if ((up == -1 && down != -1) || arr[i] - down < up - arr[i])
				arr[i] = down;
			else if ((down == -1 && up != -1) || arr[i] - down > up - arr[i])
				arr[i] = up;
			else
				arr[i] = Math.min(up, down);
		}

		System.out.println(Arrays.toString(arr));
	}

	private void findEachClosestNumbers1(int[] arr) {
		int[] output = new int[arr.length];
		output[0] = -1;
		int close, mindiff, diff;
		for (int i = 1; i < output.length; i++) {
			close = -1;
			mindiff = Integer.MAX_VALUE;
			for (int j = i - 1; j >= 0; j--) {
				diff = Math.abs(arr[i] - arr[j]);
				if (diff <= mindiff && diff != 0) {
					close = (diff == mindiff) ? Math.min(close, arr[j]) : arr[j];
					mindiff = diff;
				}
			}
			output[i] = close;
		}

		System.out.println(Arrays.toString(output));
	}
}
