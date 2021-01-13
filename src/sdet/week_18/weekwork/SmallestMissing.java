package sdet.week_18.weekwork;
/*
Find the smallest missing integer in the sorted array 
int[] numbers = {1,2,3,4,5,5,7,8,10};
output: 6
 */

import org.junit.Assert;
import org.junit.Test;

public class SmallestMissing {
int minMiss=Integer.MAX_VALUE;
	@Test
	public void example1() {
		int[] nums= {1,2,3,4,5,5,7,8,10};
		Assert.assertEquals(6, smallestMissing(nums));
	}
	
	private int smallestMissing(int[] nums) {
		helperFunc(nums, 0, nums.length-1);
		return minMiss;
	}
	
	private void helperFunc(int[] nums,int left,int right) {
		if(left==right)
			return;
		
		int mid=(left+right)/2;
		
		if(nums[mid]!=left+mid+1)
			minMiss=Math.min(minMiss, mid);
		
		helperFunc(nums, left, mid);
		helperFunc(nums, mid+1, right);
	}
}
