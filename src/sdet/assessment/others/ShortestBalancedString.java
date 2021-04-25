package sdet.assessment.others;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class ShortestBalancedString {

	@Test
	public void example1() {
		String input = "CATattac";
		Assert.assertEquals(4, getShortLength(input));
	}

	@Test
	public void example2() {
		String input = "Madam";
		Assert.assertEquals(-1, getShortLength(input));
	}

	@Test
	public void example3() {
		String input = "azABaabza";
		Assert.assertEquals(5, getShortLength(input));
	}

	@Test
	public void example4() {
		String input = "TacoCat";
		Assert.assertEquals(-1, getShortLength(input));
	}

	@Test
	public void example5() {
		String input = "AcZCbaBz";
		Assert.assertEquals(8, getShortLength(input));
	}

	private int getShortLength(String input) {
		int len = input.length();
		Set<Character> upper, lower;
		int minLen = Integer.MAX_VALUE;
		for (int i = 0, j = 0; i < len; i++) {
			upper = new HashSet<>();
			lower = new HashSet<>();
			for (j = i; j < len; j++) {
				if (Character.isUpperCase(input.charAt(j)))
					upper.add(Character.toLowerCase(input.charAt(j)));
				else
					lower.add(input.charAt(j));

				if (upper.size() == lower.size() && upper.equals(lower))
					minLen = Math.min(minLen, j - i + 1);

				if (i - j + 1 >= minLen)
					break;
			}
		}

		if (minLen == Integer.MAX_VALUE)
			return -1;

		return minLen;
	}
}
