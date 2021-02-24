package sdet.assessment.others;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given an array of 0's and 1's, find the minimum flips required to make array having alternative sequence of coins.
 * [1,0,1,0,1,1] -> reverse/flip 6th coin -> [1,0,1,0,1,0] -> min step = 1
 */
public class ChangeCoins {

	@Test
	public void example1() {
		int[] nums = { 1, 0, 1, 0, 1, 1 };
		Assert.assertEquals(1, findMaxFlips(nums));
	}

	@Test
	public void example2() {
		int[] nums = { 1, 1, 0, 1, 1 };
		Assert.assertEquals(2, findMaxFlips(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 0, 1, 0 };
		Assert.assertEquals(0, findMaxFlips(nums));
	}

	@Test
	public void example4() {
		int[] nums = { 0, 1, 1, 0 };
		Assert.assertEquals(2, findMaxFlips(nums));
	}

	private int findMaxFlips(int[] arr) {
		int p = 0;
		int exp1 = 0, exp2 = 1;
		int cnt1 = 0, cnt2 = 0;

		while (p < arr.length) {
			if (arr[p] != exp1)
				cnt1++;

			if (arr[p] != exp2)
				cnt2++;

			if (p % 2 == 0) {
				exp1++;
				exp2--;
			} else {
				exp1--;
				exp2++;
			}

			p++;
		}

		return Math.min(cnt1, cnt2);
	}

	private int findMaxFlips1(int[] arr) {
		int exp = 0;
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != exp)
				cnt1++;

			if (i % 2 == 0)
				exp++;
			else
				exp--;
		}

		exp = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != exp)
				cnt2++;

			if (i % 2 == 0)
				exp--;
			else
				exp++;
		}

		return Math.min(cnt1, cnt2);
	}
}
