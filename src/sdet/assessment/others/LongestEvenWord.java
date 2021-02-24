package sdet.assessment.others;

import org.junit.Assert;
import org.junit.Test;

//Morgan Stanley
/*
 * Find the first word in the sentence having length as even and largest compared to other even length string
 * if multiple match found, return first occur string
 * if no match, return "No Words"
 */
public class LongestEvenWord {

	@Test
	public void example1() {
		String input = "Time to write code";
		Assert.assertEquals("Time", findLongEvenWord(input));
	}

	@Test
	public void example2() {
		String input = "It is a pleasant day today";
		Assert.assertEquals("pleasant", findLongEvenWord(input));
	}

	@Test
	public void example3() {
		String input = "There was balls";
		Assert.assertEquals("No Words", findLongEvenWord(input));
	}

	private String findLongEvenWord(String input) {
		String[] split = input.split("\\s+");
		int maxLen = 0;
		String evenString = "";
		int len = 0;
		for (String str : split) {
			len = str.length();
			if (len % 2 == 0 && len > maxLen) {
				maxLen = len;
				evenString = str;
			}
		}

		if (evenString.equals(""))
			return "No Words";

		return evenString;
	}
}
