package sdet.interview.freshworks;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

//Given an array of integers, find second largest prime number

public class SecLargestPrime {

	@Test
	public void example1() {
		int[] nums = { 17, 37, 61, 11, 13, 2 };
		Assert.assertEquals(37, findSecLargestPrime(nums));
	}

	@Test
	public void example2() {
		int[] nums = { 8, 15, -7, 19, 17, 46 };
		Assert.assertEquals(17, findSecLargestPrime(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 9, 4, 12, 11, 36, 21 };
		Assert.assertEquals(0, findSecLargestPrime(nums));
	}

	@Test
	public void example4() {
		int[] nums = { -5, -11, -3, -1 };
		Assert.assertEquals(0, findSecLargestPrime(nums));
	}

	private int findSecLargestPrime(int[] nums) {

		int fMax = 0, sMax = 0;

		for (int each : nums) {
			if (each > 0 && isPrime(each)) {
				if (each > fMax) {
					sMax = fMax;
					fMax = each;
				} else if (each > sMax)
					sMax = each;
			}
		}

		if (fMax == sMax || sMax == 0)
			throw new RuntimeException("No second max found");

		return sMax;
	}

	private boolean isPrime(int num) {
		if (num < 3)
			return true;

		return (num % 2 != 0) && IntStream.rangeClosed(3, (int) Math.sqrt(num)).filter(n -> (n % 2 != 0))
				.noneMatch(n -> (num % n == 0));
	}
}
