package sdet.interview.freshworks;

import java.util.Arrays;

import org.junit.Test;

/*
given an array of integers, return all pairs whose sum matches target
Input: [1,2,7,6,4,2] target: 8
Output: (1,7) and (2,6)
*/

public class FindPairs {

	@Test
	public void example1() {
		System.out.println("Example 1:");
		int[] input = { 1, 2, 7, 6, 4, 2 };
		int target = 8;
		findPairs(input, target);
	}

	@Test
	public void example2() {
		System.out.println("Example 2:");
		int[] input = { 2, 4, 3, 5, 6, -2, 4, 7, 8, 9 };
		int target = 7;
		findPairs(input, target);
	}

	@Test
	public void example3() {
		System.out.println("Example 3:");
		int[] input = { 2, 3, 4, 5, 5 };
		int target = 8;
		findPairs(input, target);
	}

	private void findPairs(int[] input, int target) {
		Arrays.sort(input); // o[n log n]
		int left = 0, right = input.length - 1;

		while (left < right) { // o[n]
			if (input[left] + input[right] < target)
				left++;
			else if (input[left] + input[right] > target)
				right--;
			else
				System.out.println(input[left++] + "," + input[right--]);
		}
	}
}