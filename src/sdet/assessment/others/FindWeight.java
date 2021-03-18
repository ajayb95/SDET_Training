package sdet.assessment.others;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
Given an integer array and weight, find all the pairs or element whose sum or element value matches the weight

Input:
nums=[5,2,1,3,4], weight 5

Output=3
[5],[2,3],[1,4]
*/

public class FindWeight {

	@Test
	public void example1() {
		int[] nums = { 5, 2, 1, 3, 4 };
		int target = 5;
		Assert.assertEquals(3, findWeight(nums, target));
	}

	private int findWeight(int[] nums, int target) {
		Set<Integer> set = new HashSet<>();
		int cnt = 0;
		for (int each : nums) {
			if (set.contains(target - each) || each==target) {
				cnt++;
				set.remove(target - each);
			} else
				set.add(each);
		}

		return cnt;
	}
}
