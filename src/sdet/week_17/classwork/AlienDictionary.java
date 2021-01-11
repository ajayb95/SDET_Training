package sdet.week_17.classwork;

import org.junit.Assert;
import org.junit.Test;

public class AlienDictionary {

	@Test
	public void example1() {
		String[] words = { "hello", "leetcode" };
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		Assert.assertEquals(true, isLexicographicalySorted(words, order));
	}

	@Test
	public void example2() {
		String[] words = { "word", "world", "row" };
		String order = "worldabcefghijkmnpqstuvxyz";
		Assert.assertEquals(false, isLexicographicalySorted(words, order));
	}

	@Test
	public void example3() {
		String[] words = { "apple", "app" };
		String order = "abcdefghijklmnopqrstuvwxyz";
		Assert.assertEquals(false, isLexicographicalySorted(words, order));
	}
	
	@Test
	public void example4() {
		String[] words = { "kuvp","q" };
		String order = "ngxlkthsjuoqcpavbfdermiywz";
		Assert.assertEquals(true, isLexicographicalySorted(words, order));
	}

	private boolean isLexicographicalySorted(String[] words, String order) {

		for (int cur = 0; cur < words.length - 1; cur++) {
			int next = cur + 1;
			int minLen = Math.min(words[cur].length(), words[next].length());

			for (int itr = 0; itr < minLen; itr++) {
				char curChar = words[cur].charAt(itr);
				char nextChar = words[next].charAt(itr);

				if (order.indexOf(curChar) < order.indexOf(nextChar))
					break;

				if (order.indexOf(curChar) > order.indexOf(nextChar))
					return false;

				if (itr == minLen - 1 && words[cur].length() > words[next].length())
					return false;
			}
		}
		return true;
	}
}
