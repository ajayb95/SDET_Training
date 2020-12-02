package sdet.week12.homework;

import java.util.Arrays;

import org.junit.Test;

/*
Given two sorted integer arrays nums2 and nums2, merge nums2 into nums1 as one sorted array.

Note:
The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m+n) to hold additional elements for nums2.

Example:
nums1=[1,2,3,0,0,0], m=3
nums2=[2,5,6],n=3
Output=[1,2,2,3,5,6]
*/

public class P2_MergeArray {

	@Test
	public void example1() {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		sortArray(nums1, nums2);
	}

	@Test
	public void example2() {
		int[] nums1 = { 4, 5, 6, 0, 0, 0 };
		int[] nums2 = { 1, 2, 3 };
		sortArray(nums1, nums2);
	}

	@Test
	public void example3() {
		int[] nums1 = { -6, -5, -1, 0, 0, 0 };
		int[] nums2 = { -4, -2, 3 };
		sortArray(nums1, nums2);
	}

	@Test
	public void example4() {
		int[] nums1 = { 1, 2, 3, 7, 8, 0, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6, 7 };
		sortArray(nums1, nums2);
	}
	
	@Test
	public void example5() {
		int[] nums1 = { 0 };
		int[] nums2 = { 1 };
		sortArray(nums1, nums2);
	}
	
	private void sortArray(int[] nums1, int[] nums2) {
		int i=nums1.length-1;
		int f=(nums1.length-nums2.length)-1;
		int s=nums2.length-1;
		
		while(f>=0 || s>=0) {
			int n1=f>=0?nums1[f]:Integer.MIN_VALUE;
			int n2=s>=0?nums2[s]:Integer.MIN_VALUE;
			
			if(n1>n2) {
				nums1[i--]=n1;
				f--;
			}else {
				nums1[i--]=n2;
				s--;
			}
		}
		System.out.println(Arrays.toString(nums1));
	}
	
	private void sortArray1(int[] nums1, int[] nums2) {
		int len1 = nums1.length - 1;
		int len2 = nums2.length - 1;
		int p1 = len1 - len2 - 1, p2 = len2;
		while (p2 >= 0) {
			if (p1 < 0 && p2 >= 0)
				nums1[p2] = nums2[p2--];
			else if (nums1[p1] > nums2[p2])
				nums1[len1--] = nums1[p1--];
			else
				nums1[len1--] = nums2[p2--];
		}
		System.out.println(Arrays.toString(nums1));
	}

	// Two pointer
	// O[N]
	private void sortArray2(int[] nums1, int[] nums2) {
		int j = 0;
		int len1 = nums1.length;
		int len2 = nums2.length;
		int diff = len1 - len2;
		for (int i = 0; i < len1; i++) {
			if (i >= diff)
				nums1[i] = nums2[i - diff];
			else if (nums2[j] < nums1[i]) {
				int t = nums1[i];
				nums1[i] = nums2[j];
				nums2[j++] = t;
			}
		}
		System.out.println(Arrays.toString(nums1));
	}

	// Bruteforce
	// O[N log N]
	private void sortArray3(int[] nums1, int[] nums2) {
		int j=nums1.length - nums2.length;
		for (int i = j; i < nums1.length; i++) 
			nums1[i] = nums2[i - j];

		Arrays.sort(nums1);

		System.out.println(Arrays.toString(nums1));
	}
}
