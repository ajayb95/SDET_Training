package sdet.week_16.classwork;

import org.junit.Test;

public class FindOddOneOut {

	@Test
	public void example1() {
		int[] nums= {3,3,7,7,11};
		System.out.println(oddOut(nums));
	}
	
	@Test
	public void example2() {
		int[] nums= {3,3,7,7,10,11,11};
		System.out.println(oddOut(nums));
	}
	
	@Test
	public void example3() {
		int[] nums= {3,3,7,11,11};
		System.out.println(oddOut(nums));
	}
	
	private int oddOut(int[] nums) {
		int len=nums.length;
		if(len%2==0)
			return -1;
		int left=0,right=len-1;
		while(left<right) {
			int mid=(left+right)/2;
			
			if(mid%2==1) mid--;
			
			if(nums[mid]!=nums[mid+1]) right=mid;
			else left=mid+2;
		}
		return nums[left];
	}
	
	private int oddOut1(int[] nums) {
		int left=0,right=nums.length-1;
		int mid=0;
		while(left<right) {
			mid=(left+right)/2;
			if(nums[mid+1]==nums[mid] && (right-mid+1)%2==0)
				left=mid+2;
			else if(nums[mid-1]==nums[mid] && (mid-left+1)%2==0)
				right=mid-2;
			else
				return nums[mid];
		}
		mid=(left+right)/2;
		return nums[mid];
	}
}
