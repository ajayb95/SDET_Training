package sdet.week13.weekwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RemoveDuplicatesSortedArray {

	/*
	 * Given a sorted array nums, remove the duplicates in-place such that
	 * duplicates appeared at most twice and return the new length.
	 * 
	 * Do not allocate extra space for another array; you must do this by modifying
	 * the input array in-place with O(1) extra memory.
	 * 
	 * Input: nums = [1,1,1,2,2,3] Output: 5, nums = [1,1,2,2,3] Explanation: Your
	 * function should return length = 5, with the first five elements of nums being
	 * 1, 1, 2, 2 and 3 respectively. It doesn't matter what you leave beyond the
	 * returned length.
	 * 
	 * Input: nums = [0,0,1,1,1,1,2,3,3] Output: 7, nums = [0,0,1,1,2,3,3]
	 * Explanation: Your function should return length = 7, with the first seven
	 * elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively. It
	 * doesn't matter what values are set beyond the returned length.
	 */

	@Test
	public void example1() {
		int[] arr = { 1, 1, 1, 2, 2, 3 };
		System.out.println(removeDuplicates(arr));
	}

	@Test
	public void example2() {
		int[] arr = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		System.out.println(removeDuplicates(arr));
	}

	@Test
	public void example3() {
		int[] arr = { 1, 1, 1, 2, 2, 2, 3, 3 };
		System.out.println(removeDuplicates(arr));
	}

	private String removeDuplicates(int[] arr) {
		int prevEl=arr[1];
		
		for (int i = 2; i < arr.length; i+=2) {
			
		}
		return "";
	}
}
