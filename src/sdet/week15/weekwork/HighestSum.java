package sdet.week15.weekwork;
//https://leetcode.com/problems/maximum-subarray/discuss/981146/Java-approach-Recursive-DP-Kadane-Divide-and-Conquer
import java.util.Arrays;

import org.junit.Test;

public class HighestSum {

	private int maxsum=Integer.MIN_VALUE;
	
	@Test
	public void example1() {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(divideAndConquer(nums));
		System.out.println(kandaneAlgorithm(nums));
	}

	@Test
	public void example2() {
		int[] nums = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println(divideAndConquer(nums));
		//System.out.println(kandaneAlgorithm(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 1, -5, 2, -3, 7, 1 };
		System.out.println(divideAndConquer(nums));
		//System.out.println(kandaneAlgorithm(nums));
	}

	@Test
	public void example4() {
		int[] nums = { -2, -1 };
		System.out.println(divideAndConquer(nums));
		//System.out.println(kandaneAlgorithm(nums));
	}
	
	private int divideAndConquer(int[] nums) {
		return recursion(nums, 0, nums.length-1);
	}
	
	private int recursion(int[] num,int l,int r) {
		
		if(l==r)
			return num[l];
		int mid=l+(r-l)/2;
		int left=recursion(num, l, mid);
		int right=recursion(num, mid+1, r);
		
		return Math.max(maxsum, left+right);
	
	}

	private int kandaneAlgorithm(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		int sum = 0, maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			maxSum = Math.max(sum, maxSum);
			if (sum < 0)
				sum = 0;
		}

		return maxSum;
	}
}
