package sdet.assessment.others;

import org.junit.Assert;
import org.junit.Test;

public class MathChallenge {

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

		if (split[4].contains("x")) {
			return findX(split[4],
					Integer.toString(calculate(split[1], Integer.parseInt(split[0]), Integer.parseInt(split[2]))));
		} else if (split[0].contains("x")) {
			return findX(split[0],
					Integer.toString(callCalculate(split[1], Integer.parseInt(split[4]), Integer.parseInt(split[2]))));
		} else if (split[2].contains("x")) {
			if (split[1].equals("-"))
				split[1] = "+";
			return findX(split[2],
					Integer.toString(callCalculate(split[1], Integer.parseInt(split[4]), Integer.parseInt(split[0]))));
		}

		return "";
	}

	private String findX(String a, String b) {
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == 'x')
				return "" + b.charAt(i);
		}
		return "";
	}

	private int callCalculate(String op, int a, int b) {
		switch (op) {
		case "+":
			return Math.abs(calculate("-", a, b));
		case "-":
			return calculate("+", a, b);
		case "/":
			return calculate("*", a, b);
		case "*":
			return calculate("/", a, b);
		}
		return 0;
	}

	private int calculate(String op, int a, int b) {
		switch (op) {
		case "+":
			return a + b;
		case "-":
			return a - b;
		case "/":
			return a / b;
		case "*":
			return a * b;
		}
		return 0;
	}
}
