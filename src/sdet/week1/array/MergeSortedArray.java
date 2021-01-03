package sdet.week1.array;

import java.util.Arrays;

import org.junit.Test;

/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 

Constraints:

-10^9 <= nums1[i], nums2[i] <= 10^9
nums1.length == m + n
nums2.length == n
*/

public class MergeSortedArray {

	@Test
	public void example1() {
		int[] num1 = { 1, 2, 3, 0, 0, 0 };
		int[] num2 = { 2, 5, 6 };
		int m = 3, n = 3;
		merge(num1, m, num2, n);
	}

	@Test
	public void example2() {
		int[] num1 = { 4, 5, 6, 0, 0, 0 };
		int[] num2 = { 1, 2, 3 };
		int m = 3, n = 3;
		merge(num1, m, num2, n);
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
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
}
