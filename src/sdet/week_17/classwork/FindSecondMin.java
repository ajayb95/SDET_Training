package sdet.week_17.classwork;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class FindSecondMin {

	@Test
	public void example1() {
		int[] nums = { 2, 4, 1, 3, 7, 11, -1 };
		Assert.assertEquals(1, bruteForce(nums));
		Assert.assertEquals(1, twoVariables(nums));
		Assert.assertEquals(1, treeSet(nums));
	}

	@Test
	public void example2() {
		int[] nums = { 2, 4, 1, 3, -1, 11, -1 };
		Assert.assertEquals(1, bruteForce(nums));
		Assert.assertEquals(1, twoVariables(nums));
		Assert.assertEquals(1, treeSet(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 6, 4, 2, 8, -5, -4, 1 };
		Assert.assertEquals(-4, bruteForce(nums));
		Assert.assertEquals(-4, twoVariables(nums));
		Assert.assertEquals(-4, treeSet(nums));
	}

	@Test
	public void example4() {
		int[] nums = { 1, 1, 1, 1, 1 };
		Assert.assertEquals(0, bruteForce(nums));
		Assert.assertEquals(0, twoVariables(nums));
		Assert.assertEquals(0, treeSet(nums));
	}

	// O[n log n]
	private int bruteForce(int[] nums) {
		Arrays.sort(nums);
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > min)
				return nums[i];
		}

		throw new RuntimeException("No second minimum found");
	}

	// O[N]
	private int twoVariables(int[] nums) {
		int firstmin = Integer.MAX_VALUE, secmin = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < firstmin) {
				secmin = firstmin;
				firstmin = nums[i];
			} else if (nums[i] < secmin && nums[i] > firstmin)
				secmin = nums[i];
		}

		if (secmin == Integer.MAX_VALUE)
			throw new RuntimeException("No second minimum found");

		return secmin;
	}

	// O[N]
	private int treeSet(int[] nums) {
		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(TreeSet::new));

		int cnt = 2;
		int secMin = 0;

		Iterator<Integer> itr = set.iterator();
		while (itr.hasNext() && --cnt >= 0)
			secMin = itr.next();

		if (cnt > 0)
			throw new RuntimeException("No second minimum found");

		return secMin;
	}
}
