package sdet.assessment.swiggy;

import org.junit.Assert;
import org.junit.Test;

public class FirstUniqueChar {

	@Test
	public void example1() {
		String input = "statistics";
		Assert.assertEquals(3, findOccIndex(input));
	}

	@Test
	public void example2() {
		String input = "ababa";
		Assert.assertEquals(-1, findOccIndex(input));
	}

	@Test
	public void example3() {
		String input = "abcd";
		Assert.assertEquals(1, findOccIndex(input));
	}

	private int findOccIndex(String input) {
		for (int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			if (input.indexOf(temp) == input.lastIndexOf(temp))
				return i + 1;
		}
		return -1;
	}
}
