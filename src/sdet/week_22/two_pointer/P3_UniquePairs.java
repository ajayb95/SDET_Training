package sdet.week_22.two_pointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array. A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
•	0 <= i, j < nums.length
•	i != j
•	|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.
 Example 1:
Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
*/

public class P3_UniquePairs {

	@Test
	public void example1() {
		int[] nums = { 3, 1, 4, 1, 5 };
		int k = 2;
		Assert.assertEquals(2, findUniquePairs(nums, k));
	}

	@Test
	public void example2() {
		int[] nums = { 1, 2, 3, 4, 5 };
		int k = 1;
		Assert.assertEquals(4, findUniquePairs(nums, k));
	}

	@Test
	public void example3() {
		int[] nums = { 1, 3, 1, 5, 4 };
		int k = 0;
		Assert.assertEquals(1, findUniquePairs(nums, k));
	}

	@Test
	public void example4() {
		int[] nums = { 1, 2, 4, 4, 3, 3, 0, 9, 2, 3 };
		int k = 3;
		Assert.assertEquals(2, findUniquePairs(nums, k));
	}

	@Test
	public void example5() {
		int[] nums = { -1, -2, -3 };
		int k = 1;
		Assert.assertEquals(2, findUniquePairs(nums, k));
	}

	private int findUniquePairs(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;

		int result = 0;
		Arrays.sort(nums);
		int low = 0;
		int high = 1;

		while (low < nums.length && high < nums.length) {

			if (low == high || nums[high] - nums[low] < k) {
				high++;
			} else if (nums[high] - nums[low] == k) {
				low++;
				result++;
				while (low < nums.length && nums[low] == nums[low - 1]) {
					low++;
				}
			} else {
				low++;
			}

		}

		return result;
	}

	private int findUniquePairs1(int[] nums, int k) {
		int result = 0;

		HashMap<Integer, Integer> counter = new HashMap<>();

		for (int n : nums)
			counter.put(n, counter.getOrDefault(n, 0) + 1);

		for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
			int x = entry.getKey();
			int val = entry.getValue();
			if (k > 0 && counter.containsKey(x + k)) {
				result++;
			} else if (k == 0 && val > 1) {
				result++;
			}
		}
		return result;
	}

	private int findUniquePairs2(int[] nums, int k) {
		if (nums.length == 1 || k < 0) {
			return 0;
		}
		int l = nums.length;
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				if (bs(nums, i + 1, l - 1, k + nums[i])) {
					count++;
				}
			}
		}
		return count;
	}

	public boolean bs(int[] nums, int start, int end, int k) {
		int left = start, right = end;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == k) {
				return true;
			}
			if (nums[mid] > k) {
				right = mid;
			} else {
				left = mid;
			}
		}
		if (nums[left] == k || nums[right] == k) {
			return true;
		}
		return false;
	}
}
