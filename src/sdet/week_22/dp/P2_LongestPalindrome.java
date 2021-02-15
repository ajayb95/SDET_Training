package sdet.week_22.dp;

import org.junit.Assert;
import org.junit.Test;

/*
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Constraint: Use expand around center with O(n^2)
*/

public class P2_LongestPalindrome {

	@Test
	public void example1() {
		String s = "babad";
		Assert.assertEquals("bab", longestPalindrome(s));
	}

	@Test
	public void example2() {
		String s = "abcd";
		Assert.assertEquals("a", longestPalindrome(s));
	}

	@Test
	public void example3() {
		String s = "bbbbb";
		Assert.assertEquals("bbbbb", longestPalindrome(s));
	}

	private String longestPalindrome(String s) {
		int len = s.length();

		if (len == 0)
			return "";

		int maxLen = -1;
		String subString = "";
		for (int mid = 0; mid < 2 * len; mid++) {
			int left = mid / 2;
			int right = left + mid % 2;

			while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			if (right - left > maxLen) {
				subString = s.substring(left + 1, right);
				maxLen=right-left;
			}
		}

		return subString;
	}
}
