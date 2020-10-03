package sdet.week1_2.recap;

import org.junit.Test;

public class HighestSum {

	@Test
	public void example1() {
		int[] input = { 1, 5, 2, 3, 7, 1 };
		int k = 3;
		highestSum(input, k);
	}

	@Test
	public void example2() {
		int[] input = { 5, 8, 6, 1, 3, 9, 9, 2, 1, 6 };
		int k = 3;
		highestSum(input, k);
	}

	private void highestSum1(int[] input, int k) {
		int max = 0, sum = 0;
		for (int i = 0; i < k; i++) {
			sum += input[i];
		}
		max = sum;

		for (int i = k; i < input.length; i++) {
			sum += input[i] - input[i - k];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

	private void highestSum(int[] input, int k) {
		int i = 0;
		int sum = 0, max = 0;

		while (i < input.length) {
			sum += input[i];
			if (i >= k)
				sum -= input[i - k];
			max = Math.max(max, sum);
			i++;
		}

		System.out.println(max);
	}
}
