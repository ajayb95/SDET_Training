package sdet.week_18.weekwork;

import org.junit.Assert;
import org.junit.Test;

/*
https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
*/

public class ConvertToAnagram {

	@Test
	public void example1() {
		String s = "bab";
		String t = "aba";
		Assert.assertEquals(1, minSteps(s, t));
	}

	@Test
	public void example2() {
		String s = "leetcode";
		String t = "practice";
		Assert.assertEquals(5, minSteps(s, t));
	}

	@Test
	public void example3() {
		String s = "anagram";
		String t = "mangaar";
		Assert.assertEquals(0, minSteps(s, t));
	}

	@Test
	public void example4() {
		String s = "xxyyzz";
		String t = "xxyyzz";
		Assert.assertEquals(0, minSteps(s, t));
	}

	@Test
	public void example5() {
		String s = "friend";
		String t = "family";
		Assert.assertEquals(4, minSteps(s, t));
	}

	private int minSteps(String s, String t) {
		int[] ascii = new int[26];

		for (char ch : s.toCharArray())
			ascii[ch - 'a']++;

		int cnt = 0;
		for (char ch : t.toCharArray()) {
			if (ascii[ch - 'a'] > 0)
				ascii[ch - 'a']--;
			else
				cnt++;
		}

		return cnt;
	}
}
