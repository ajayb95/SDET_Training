package sdet.week8.assignments;

import org.junit.Test;

public class LuhnAlgorithm {
	// @Test
	public void example1() {
		String BIN = "512340";
		generateCard(BIN);
	}

	@Test
	public void example() {
		String BIN = "502002";
		generateCard(BIN);
	}

	private void generateCard(String BIN) {
		int[] dig = new int[16]; // create an array of size 16 i.e. 16 digit card number

		for (int i = 0; i < BIN.length(); i++)
			dig[i] = Character.getNumericValue(BIN.charAt(i)); // add bin to array

		for (int i = BIN.length(); i < 15; i++)
			dig[i] = (int) Math.floor(Math.random() * 10);

		int sum = 0;
		for (int i = dig.length - 2; i >= 0; i--) {
			if (i % 2 == 0) {
				// iterate from right most digit (here we start from last from 2 as we are finding
				// check digit at the end) and double every alternate
				int temp = dig[i] * 2; // if number is greater than 9, sum both digit and add final single digit to sum
				sum += temp % 10 + temp / 10;
			} else // else add the number directly
				sum += dig[i];
		}

		if (sum % 10 != 0) // if final sum is divisible by 10 return the array as it is
			dig[dig.length - 1] = (((sum / 10) + 1) * 10) - sum; // else add check digit as difference between
		// final sum and near value divisible by 10

		String op = "";

		for (int i : dig)
			op += Integer.toString(i);
		// convert it to a single string and return it
		System.out.println(op);
	}
}
