package sdet.week_22.dp;

import org.junit.Assert;
import org.junit.Test;

/*
Given two strings s and t, check if s is a subsequence of t.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not). 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
*/

public class P5_IsSubsequence {

	@Test
	public void example1() {
		String s = "abc";
		String t = "ahbgdc";
		Assert.assertEquals(true, isSubsequence(s, t));
	}

	@Test
	public void example2() {
		String s = "axc";
		String t = "ahbgdc";
		Assert.assertEquals(false, isSubsequence(s, t));
	}

	@Test
	public void example3() {
		String s = "b";
		String t = "abc";
		Assert.assertEquals(true, isSubsequence(s, t));
	}

	@Test
	public void example4() {
		String s = "";
		String t = "abc";
		Assert.assertEquals(true, isSubsequence(s, t));
	}

	private boolean isSubsequence(String s, String t) {
		int slen = s.length(), tlen = t.length();

		if (slen > tlen)
			return false;

		int ind = 0;
		for (int i = 0; i < tlen; i++)
			if (ind < slen && t.charAt(i) == s.charAt(ind))
				ind++;

		return ind == slen;
	}
}
