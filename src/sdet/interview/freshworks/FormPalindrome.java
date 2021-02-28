package sdet.interview.freshworks;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

//given a string, find whether it can be rearranged to form a palindrome

public class FormPalindrome {

	@Test
	public void example1() {
		String inp = "aba";
		Assert.assertEquals(true, isPalindromeFormed(inp));
	}

	@Test
	public void example2() {
		String inp = "abababa";
		Assert.assertEquals(true, isPalindromeFormed(inp));
	}

	@Test
	public void example3() {
		String inp = "bbcd";
		Assert.assertEquals(false, isPalindromeFormed(inp));
	}

	@Test
	public void example4() {
		String inp = "abcd";
		Assert.assertEquals(false, isPalindromeFormed(inp));
	}

	@Test
	public void example5() {
		String inp = "";
		Assert.assertEquals(true, isPalindromeFormed(inp));
	}

	private boolean isPalindromeFormed(String s) {
		if (s.length() < 2)
			return true;

		Set<Character> set = new HashSet<>();

		for (int i = 0; i < s.length(); i++)
			if (!set.add(s.charAt(i)))
				set.remove(s.charAt(i));

		if (set.size() > 1)
			return false;

		return true;
	}
}
