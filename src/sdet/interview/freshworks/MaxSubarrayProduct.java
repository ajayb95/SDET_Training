package sdet.interview.freshworks;

import org.junit.Assert;
import org.junit.Test;

public class MaxSubarrayProduct {

	@Test
	public void example1() {
		int[] input = { 12, 23, 34, -23, 0, 34 };
		Assert.assertEquals(9384, findMaxSubarrayPrdt(input));
	}

	@Test
	public void example2() {
		int[] input = { 2, 3, -2, 4 };
		Assert.assertEquals(6, findMaxSubarrayPrdt(input));
	}

	@Test
	public void example3() {
		int[] input = { -2, 0, -1 };
		Assert.assertEquals(0, findMaxSubarrayPrdt(input));
	}

	@Test
	public void example4() {
		int[] input = { 2, -5, -2, -4, 3 };
		Assert.assertEquals(24, findMaxSubarrayPrdt(input));
	}

	@Test
	public void example5() {
		int[] input = { -3, -1, -1 };
		Assert.assertEquals(3, findMaxSubarrayPrdt(input));
	}

	@Test
	public void example6() {
		int[] input = { 3, -1, 4 };
		Assert.assertEquals(4, findMaxSubarrayPrdt(input));
	}

	private int findMaxSubarrayPrdt(int[] input) {

		int max = input[0], min = input[0], prdtMax = input[0];

		for (int i = 1, tMax = 0, tMin = 0; i < input.length; i++) {
			tMax = max * input[i];
			tMin = min * input[i];
			max = Math.max(Math.max(tMax, tMin), input[i]);
			min = Math.min(Math.min(tMax, tMin), input[i]);
			prdtMax = Math.max(prdtMax, max);
		}
		return prdtMax;
	}
}
