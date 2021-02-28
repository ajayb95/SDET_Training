package sdet.week_22.two_pointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
Given two arrays, write a function to compute their intersection.
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
*/

public class P5_ArrayIntersection {

	@Test
	public void example1() {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		System.out.println(findIntersection(nums1, nums2));
	}

	@Test
	public void example2() {
		int[] nums1 = { 1, 2, 3, 4 };
		int[] nums2 = { 5, 6, 7, 8 };
		System.out.println(findIntersection(nums1, nums2));
	}

	@Test
	public void example3() {
		int[] nums1 = { 1, 2, 3 };
		int[] nums2 = { 1, 2, 3 };
		System.out.println(findIntersection(nums1, nums2));
	}

	@Test
	public void example4() {
		int[] nums1 = { 9, 9, 9 };
		int[] nums2 = { 9, 9, 9 };
		System.out.println(findIntersection(nums1, nums2));
	}

	private Set<Integer> findIntersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int p1 = 0, p2 = 0;
		Set<Integer> set = new HashSet<>();

		while (p1 < nums1.length && p2 < nums2.length) {
			if (nums1[p1] == nums2[p2]) {
				set.add(nums1[p1++]);
				p2++;
			} else if (nums1[p1] < nums2[p2])
				p1++;
			else
				p2++;
		}

		return set;
	}
}
