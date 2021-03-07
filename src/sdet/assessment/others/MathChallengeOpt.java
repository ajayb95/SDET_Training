package sdet.assessment.others;

import org.junit.Assert;
import org.junit.Test;

public class MathChallengeOpt {

	@Test
	public void example1() {
		String input = "4 - 2 = x";
		Assert.assertEquals("2", solveMath(input));
	}

	@Test
	public void example2() {
		String input = "1x0 * 12 = 1200";
		Assert.assertEquals("0", solveMath(input));
	}

	@Test
	public void example3() {
		String input = "126 / 3 = x2";
		Assert.assertEquals("4", solveMath(input));
	}

	@Test
	public void example4() {
		String input = "10 - x = 10";
		Assert.assertEquals("0", solveMath(input));
	}

	@Test
	public void example5() {
		String input = "24 / x = 12";
		Assert.assertEquals("2", solveMath(input));
	}

	@Test
	public void example6() {
		String input = "12 * x = 36";
		Assert.assertEquals("3", solveMath(input));
	}

	private String solveMath(String input) {

		String[] split = input.split("\\s+");

		int ind = 0;

		for (int i = 0; i < 5; i += 2)
			if (split[i].contains("x"))
				ind = i;

		for (int i = 0; i < 10; i++) {
			if (ind == 0 && calculate(split[1], Integer.parseInt(split[0].replace('x', (char) (i + '0'))),
					Integer.parseInt(split[2]), Integer.parseInt(split[4])))
				return "" + i;
			else if (ind == 2 && calculate(split[1], Integer.parseInt(split[0]),
					Integer.parseInt(split[2].replace('x', (char) (i + '0'))), Integer.parseInt(split[4])))
				return "" + i;
			else if (ind == 4 && calculate(split[1], Integer.parseInt(split[0]), Integer.parseInt(split[2]),
					Integer.parseInt(split[4].replace('x', (char) (i + '0')))))
				return "" + i;
		}

		return "";
	}

	private boolean calculate(String cal, int a, int b, int c) {
		switch (cal) {
		case "+":
			return a + b == c;
		case "-":
			return a - b == c;
		case "/":
			if (b == 0)
				return false;
			return a / b == c;
		case "*":
			return a * b == c;
		default:
			return false;
		}
	}
}
