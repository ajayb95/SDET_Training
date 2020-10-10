package sdet.week4.assesments;

import org.junit.Test;

/*
Given an array of integers, without reordering, determine the maximum
difference between any element and any prior smaller difference. If
there is never a lower prior element, return -1.

Example
arr = [5, 3, 6, 7, 4]
There are no earlier elements than arr[0].
There is no earlier reading with a value lower than arr[1].
There are two lower earlier readings with a value lower than arr[2] = 6:
arr[2] - arr[1] = 6 - 3 = 3
arr[2] - arr[0] = 6 - 5 = 1
There are three lower earlier readings with a lower value than arr[3] = 7:
arr[3] - arr[2] = 7 - 6 = 1
arr[3] - arr[1] = 7 - 3 = 4
arr[3] - arr[0] = 7 - 5 = 2
There is one lower earlier reading with a lower value than arr[4] = 4:
arr[4] - arr[1] = 4 - 3 = 1
The maximum trailing record is arr[3] - arr[1] = 4.

Example
arr = [4, 3, 2, 1]
No item in arr has a lower earlier reading, therefore return -1
*/

public class P2_RiverRecords {

	@Test
	public void example1() {
		int[] input = { 5, 3, 6, 7, 4 };
		System.out.println(riverRecords(input));
	}

	@Test
	public void example2() {
		int[] input = { 4, 3, 2, 1 };
		System.out.println(riverRecords(input));
	}

	@Test
	public void example3() {
		int[] input = { 2, 3, 10, 2, 4, 8, 1 };
		System.out.println(riverRecords(input));
	}

	@Test
	public void example4() {
		int[] input = { 7, 9, 5, 6, 3, 2 };
		System.out.println(riverRecords(input));
	}

	private int riverRecords1(int[] input) {
		int max = input[input.length - 1], diff = 0;

		for (int i = input.length - 2; i >= 0; i--) {
			if (input[i] > max) {
				max = input[i];
			} else {
				diff = Math.max(diff, max - input[i]);
			}
		}

		return diff == 0 ? -1 : diff;
	}

	private int riverRecords2(int[] input) {
		int maxDiff = 0, max = input[input.length - 1];
		for (int i = input.length - 2; i >= 0; i--) {
			max = Math.max(max, input[i]);
			maxDiff = Math.max(maxDiff, max - input[i]);
		}
		return maxDiff == 0 ? -1 : maxDiff;
	}
	
	private int riverRecords(int[] input) {
		int max=0;
		for (int i = 1; i < input.length; i++) {
			for (int j = i-1; j >=0; j--) {
				if(input[j]<input[i])
					max=Math.max(max, input[i]-input[j]);
			}
		}
		
		return max==0?-1:max;
	}
}
