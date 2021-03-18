package sdet.assessment.others;

import org.junit.Assert;
import org.junit.Test;

/*
 Given starting and ending range (both inclusive), Find sum of all prime numbers between the given range.

 Input:
 Start=1
 End=5
 
 Ouput=10
 2,3,5 are the prime numbers in range 1-5, which sums up to 10
*/

public class SumOfAllPrime {

	@Test
	public void example1() {
		int start = 1;
		int end = 5;
		Assert.assertEquals(10, findSumOfPrime(start, end));
	}

	private int findSumOfPrime(int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			if (isPrime(i))
				sum += i;
		}

		return sum;
	}

	private boolean isPrime(int n) {
		if (n == 1)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++)
			if (n % i == 0)
				return false;

		return true;
	}
}
