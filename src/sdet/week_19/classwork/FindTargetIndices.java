package sdet.week_19.classwork;
/*
 * Given a sorted integer array, return the first and last occurring index of the target integer
 * input={11,14,19,19,19,19,19,23,24}
 * target=19
 * output=[3,5]
 * 
 * input={11,14,17,18,19,20,23,24}
 * target=19
 * output=[4,4]
 * 
 * input={11,14,17,18,19,20,23,24}
 * target=16
 * output=[-1,-1]
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

//Pseudo code
//Brute force
/*
 * Add all elements to a list
 * use contains method to find element is present in the array, if not found return -1 for both indices
 * use methods indexOf and lastIndexOf and return the indices of first and last occurring indices of the target
 * Space: O[N]
 * Time: O[N]
 */

//Linear search
/*
 * iterate through each element in the array
 * if target found, get the starting index
 * iterate till element ending index
 * finally return both starting and ending index of the target in input
 * if element not found return -1 for both indices
 * Space: O[1]
 * Time: O[N]
 */

//Two pointer
/*
 * start left pointer from 0 and right from end of array
 * parallely iterate array from both sides
 * if left pointer finds target, start right from left
 * if right finds target, start left from right 
 * iterate till both start and end index is found
 * 
 * Space: O[1]
 * Time: O[N]
 */

//Binary search
/*
 * initialize 2 variables left and right where left is 0 and right is end of array
 * find the mid point
 * if the mid element is target expand from mid to find the starting and ending index of target and return the indices
 * if mid value is greater than target move right to mid-1
 * else move left to mid+1
 * iterate till left is less than target
 * if no target found return -1 for both start and end indices
 * 
 * Space: O[1]
 * Time: O[N]
 */

//Binary Search - optimized
/*
 * initialize 2 variables left and right
 * find 
 */

public class FindTargetIndices {

	@Test // +ve
	public void example1() {
		System.out.println("Test 1");
		int[] nums = { 11, 14, 17, 19, 19, 19, 23, 24 };
		int target = 19;
		System.out.println(bruteForce(nums, target));
		System.out.println(linearApproach(nums, target));
		System.out.println(twoPointer(nums, target));
		System.out.println(binarySearch(nums, target));
		System.out.println(optimizedSolution(nums, target));
	}

	@Test // edge
	public void example2() {
		System.out.println("Test 2");
		int[] nums = { 11, 14, 17, 19, 19, 19, 23, 24 };
		int target = 23;
		System.out.println(bruteForce(nums, target));
		System.out.println(linearApproach(nums, target));
		System.out.println(twoPointer(nums, target));
		System.out.println(binarySearch(nums, target));
		System.out.println(optimizedSolution(nums, target));
	}

	@Test // -ve
	public void example3() {
		System.out.println("Test 3");
		int[] nums = { 11, 14, 17, 19, 19, 19, 23, 24 };
		int target = 16;
		System.out.println(bruteForce(nums, target));
		System.out.println(linearApproach(nums, target));
		System.out.println(twoPointer(nums, target));
		System.out.println(binarySearch(nums, target));
		System.out.println(optimizedSolution(nums, target));
	}

	@Test
	public void example4() {
		System.out.println("Test 4");
		int[] nums = { 9, 9, 9, 9, 9 };
		int target = 9;
		System.out.println(bruteForce(nums, target));
		System.out.println(linearApproach(nums, target));
		System.out.println(twoPointer(nums, target));
		System.out.println(binarySearch(nums, target));
		System.out.println(optimizedSolution(nums, target));
	}

	private String bruteForce(int[] nums, int target) {
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		if (!list.contains(target))
			return Arrays.toString(new int[] { -1, -1 });

		return Arrays.toString(new int[] { list.indexOf(target), list.lastIndexOf(target) });
	}

	private String linearApproach(int[] nums, int target) {
		int end = 0;
		for (int i = 0; i < nums.length; i++) {
			end = i;
			if (nums[i] == target) {
				while (end < nums.length && nums[end] == target)
					end++;
				return Arrays.toString(new int[] { i, end - 1 });
			}
		}

		return Arrays.toString(new int[] { -1, -1 });
	}

	private String twoPointer(int[] nums, int target) {
		int left = 0, right = nums.length - 1;

		while (left <= right) {

			if (nums[left] == target && nums[right] == target)
				return Arrays.toString(new int[] { left, right });

			if (nums[left] != target)
				left++;
			else if (nums[right] != target)
				right--;
		}

		return Arrays.toString(new int[] { -1, -1 });

	}

	private String binarySearch(int[] nums, int target) {
		int left = 0, right = nums.length - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (nums[mid] == target) {
				left = mid;
				right = mid;
				while ((left >= 0 && nums[left] == target) || (right < nums.length && nums[right] == target)) {
					if (nums[left] == target)
						left--;
					if (nums[right] == target)
						right++;
				}
				return Arrays.toString(new int[] { left + 1, right - 1 });
			}

			if (nums[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}

		return Arrays.toString(new int[] { -1, -1 });
	}

	private String optimizedSolution(int[] nums, int target) {
		int left = search(nums, target);
		if (left == nums.length || nums[left] != target)
			return Arrays.toString(new int[] { -1, -1 });

		return Arrays.toString(new int[] { left, search(nums, target + 1) - 1 });
	}

	private int search(int[] nums, int target) {
		int left = 0, right = nums.length;

		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target)
				left = mid + 1;
			else
				right = mid;
		}

		return left;
	}
}
