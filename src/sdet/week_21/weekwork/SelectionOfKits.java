package sdet.week_21.weekwork;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
Bob and Alice start painting. There are N numbers of painting kits. The ith kit has a strength of A[i].
They need to select these kits. Bob got the first chance to select a kit and he selected a minimum number of kits such that he can make the painting quickly. Now, the remaining kits are selected by Alice.
Bob can finish his painting before Alice, if and only if the total strength of his kits is greater than Alice's.
Find the minimum number of kits that must be selected by Bob.

Input format:
* The first line contains N.
* The second line contains N space-separated integers denoting the strength of kits.

Output format:
Print the minimum number of kits that Bob must select.

Constraints:
1 <= N <= 10^5
0 <= A[i] <= 10^9

Sample input:
A=[5,3,4,1,2]
Output: 2

Explanation: If Bob selects 5 and 3 in as his kits, then the required condition is met.
*/

public class SelectionOfKits {

	@Test
	public void example1() {
		int[] arr = { 5, 3, 4, 1, 2 };
		Assert.assertEquals(2, minKitsForBob(arr));
	}

	@Test
	public void example2() {
		int[] arr = { 2, 2, 2, 2, 2 };
		Assert.assertEquals(3, minKitsForBob(arr));
	}

	private int minKitsForBob(int[] arr) {
		Arrays.sort(arr);
		BigInteger sum = BigInteger.ZERO;

		for (int each : arr)
			sum = sum.add(BigInteger.valueOf(each));

		BigInteger alicesum = BigInteger.ZERO;
		int count = 0;

		for (int each : arr) {
			alicesum = alicesum.add(BigInteger.valueOf(each));
			sum = sum.subtract(BigInteger.valueOf(each));
			if (sum.compareTo(alicesum) > 0)
				count++;
			else
				break;
		}

		return arr.length - count;
	}
}
