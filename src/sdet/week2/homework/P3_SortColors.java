package sdet.week2.homework;

import java.util.Arrays;

import org.junit.Test;

/*
3) Sort Colors

Given an array nums with n objects colored red, white, or blue, 
sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

Here, use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

Example 3:
Input: nums = [0]
Output: [0]

Example 4:
Input: nums = [1]
Output: [1]
*/

public class P3_SortColors {

	@Test
	public void example1() {
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		sortColors(nums);
	}

	@Test
	public void example2() {
		int[] nums = { 2, 0, 1 };
		sortColors(nums);
	}

	@Test
	public void example3() {
		int[] nums = { 0 };
		sortColors(nums);
	}

	@Test
	public void example4() {
		int[] nums = { 1 };
		sortColors(nums);
	}

	private void sortColors1(int[] nums) {
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
	}

	private void sortColors2(int[] nums) {
		if (nums.length == 1)
			System.out.println(Arrays.toString(nums));
		else {
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] < nums[i]) {
						int temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
					}
				}
			}
			System.out.println(Arrays.toString(nums));
		}
	}

	private void sortColors3(int[] nums) {
		int red = 0, white = 0, blue = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				red++;
			else if (nums[i] == 1)
				white++;
			else
				blue++;
		}

		for (int i = 0; i < nums.length; i++) {
			if (red > 0) {
				nums[i] = 0;
				red--;
			} else if (white > 0) {
				nums[i] = 1;
				white--;
			} else {
				nums[i] = 2;
				blue--;
			}
		}

		System.out.println(Arrays.toString(nums));
	}
	
	private void sortColors(int[] nums) {
		int low=0,mid=0,high=nums.length-1;
		
		while(mid<=high) {
			if(nums[mid]==0) {
				int temp=nums[low];
				nums[low++]=nums[mid];
				nums[mid++]=temp;
			}
			else if(nums[mid]==2) {
				int temp=nums[mid];
				nums[mid]=nums[high];
				nums[high--]=temp;
			}
			else
				mid++;
		}
		System.out.println(Arrays.toString(nums));
	}
}