package sdet.week12.homework;

import org.junit.Test;

/*
Problem 1)

Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.


Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Example 2:

Input: s = "a", t = "a"
Output: "a"
*/

public class P1_MinimumWindow {

	@Test
	public void example1() {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s, t));
	}

	@Test
	public void example2() {
		String s = "a";
		String t = "a";
		System.out.println(minWindow(s, t));
	}

	private String minWindow(String s, String t) {
		int slen = s.length();
		int tlen = t.length();

		if (tlen > slen)
			return "";

		int[] sarr = new int[126];
		int[] tarr = new int[126];

		for (char c : t.toCharArray())
			tarr[c]++;

		int start = 0, startind = -1, minLen = Integer.MAX_VALUE, cnt = 0;
		for (int end = 0; end < slen; end++) {
			sarr[s.charAt(end)]++;

			if (sarr[s.charAt(end)] <= tarr[s.charAt(end)])
				cnt++;

			if (cnt == tlen) {
				while (sarr[s.charAt(start)] > tarr[s.charAt(start)] || tarr[s.charAt(start)] == 0) {
					if (sarr[s.charAt(start)] > tarr[s.charAt(start)])
						sarr[s.charAt(start)]--;
					start++;
				}
				int winLen = end - start + 1;
				if (winLen < minLen) {
					minLen = winLen;
					startind = start;
				}
			}
		}

		if (startind == -1)
			return "";

		return s.substring(startind, startind + minLen);
	}
}
