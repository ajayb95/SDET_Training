package sdet.week_22.two_pointer;

import java.util.Arrays;

import org.junit.Test;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
*/

public class P1_MinSubarray {

	@Test
	public void example1() {
		int[] nums= {2,3,1,2,4,3};
		int target=7;
		System.out.println(Arrays.toString(findMinSubarray(nums,target)));
	}

	private int[] findMinSubarray(int[] nums, int target) {
		int start=0,end=0,minStart=0;
		int sum=0;
		int minLen=0;
		while(end<nums.length) {
			sum+=nums[end++];
			while(sum>=target) {
				if(sum==target && end-start<minLen) {
					minLen=end-start;
					minStart=start;
				}
				sum-=nums[start++];
			}
			
		}
		
		return Arrays.copyOfRange(nums, minStart, minStart+minLen-1);
		
	}
}
