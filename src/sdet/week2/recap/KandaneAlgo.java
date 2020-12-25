package sdet.week2.recap;

import org.junit.Test;

public class KandaneAlgo {

	@Test
	public void example1() {
		int[] input = { 1, -5, 2, -3, 7, 1 };
		highestSum(input);
	}

	@Test
	public void example2() {
		int[] input = { 1, -5, -2, -3, 7, -1 };
		highestSum(input);
	}

	private void highestSum(int[] input) {
		int sum = 0;
		int max = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
			if (sum > 0)
				max = Math.max(max, sum);
			else
				sum = 0;
		}
		System.out.println(max);
	}
}
