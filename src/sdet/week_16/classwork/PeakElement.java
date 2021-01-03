package sdet.week_16.classwork;

import org.junit.Test;

/*
A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
*/

public class PeakElement {

	@Test
	public void example1() {
		int[] nums= {1,2,3,1};
		System.out.println(returnPeakElement(nums));
	}
	
	@Test
	public void example2() {
		int[] nums= {1,2,1,3,5,6,4};
		System.out.println(returnPeakElement(nums));
	}
	
	@Test
	public void example3() {
		int[] nums= {1,2};
		System.out.println(returnPeakElement(nums));
	}
	
	private int returnPeakElement(int[] nums) {
		int left=0,right=nums.length-1;
		int mid=0;
		
		while(left<right) {
			mid=(left+right)/2;
			if(nums[mid]>nums[mid+1])
				right=mid;
			else
				left=mid+1;
		}
		return left;
	}
	
	private int returnPeakElement1(int[] nums) {
		if (nums.length == 1)
			return 0;

		int left = 0, right = nums.length - 1;
		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			if (mid == 0) {
				if (nums[mid + 1] < nums[mid])
					return 0;
				else if (nums[mid + 1] > nums[mid])
					return 1;
			} else if (mid == right) {
				if (nums[mid - 1] < nums[mid])
					return mid;
				else if (nums[mid - 1] > nums[mid])
					return mid - 1;
			}

			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
				return mid;
			if (nums[mid] < nums[mid + 1])
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}
}
