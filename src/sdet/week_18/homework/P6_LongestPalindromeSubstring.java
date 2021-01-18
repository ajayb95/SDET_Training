package sdet.week_18.homework;

import org.junit.Assert;
import org.junit.Test;



/*
https://leetcode.com/problems/longest-palindromic-substring/
*/

/*
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Example 3:
Input: s = "a"
Output: "a"

Example 4:
Input: s = "ac"
Output: "a"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),
*/
public class P6_LongestPalindromeSubstring {

	@Test
	public void example1() {
		String s="babad";
		Assert.assertEquals("bab", findLongestPalindrome(s));
		Assert.assertEquals("bab", longPalindrome(s));
	}
	
	@Test
	public void example2() {
		String s="cbbd";
		Assert.assertEquals("bb", findLongestPalindrome(s));
		Assert.assertEquals("bb", longPalindrome(s));
	}
	
	@Test
	public void example3() {
		String s="a";
		Assert.assertEquals("a", findLongestPalindrome(s));
		Assert.assertEquals("a", longPalindrome(s));
	}
	
	@Test
	public void example4() {
		String s="ac";
		Assert.assertEquals("a", findLongestPalindrome(s));
		Assert.assertEquals("a", longPalindrome(s));
	}

	private String findLongestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		int left = 0, right = 0, mid = 0;
		int maxLen = Integer.MIN_VALUE;
		String longPalindrome = "";
		for (; mid < 2 * len; mid++) {
			left = mid / 2;
			right = left + mid % 2;
			while (left >= 0 && right < len && s.charAt(left--) == s.charAt(right++)) {
				if (maxLen < right - left) {
					maxLen = right - left;
					longPalindrome = s.substring(left + 1, right);
				}
			}
		}

		return longPalindrome;
	}

	private int lo, maxlen;

	private String longPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++) {
			extendPalindrome(s, i, i);
			extendPalindrome(s, i, i + 1);
		}
		return s.substring(lo, lo + maxlen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxlen < k - j - 1) {
			lo = j + 1;
			maxlen = k - j - 1;
		}
	}
}
