package sdet.week_22.two_pointer;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
*/

public class P2_LongestSubstring {

	@Test
	public void example1() {
		String input = "abcabcbb";
		Assert.assertEquals(3, findLongSubstring(input));
	}

	@Test
	public void example2() {
		String input = "bbbbb";
		Assert.assertEquals(1, findLongSubstring(input));
	}

	@Test
	public void example3() {
		String input = "pwwkew";
		Assert.assertEquals(3, findLongSubstring(input));
	}

	@Test
	public void example4() {
		String input = "";
		Assert.assertEquals(0, findLongSubstring(input));
	}

	private int findLongSubstring(String input) {
		int start = 0, end = 0;
		int maxLen = Integer.MIN_VALUE;
		Set<Character> set = new HashSet<>();
		while (end < input.length()) {
			if (!set.add(input.charAt(end)))
				set.remove(input.charAt(start++));
			else {
				end++;
				maxLen = Math.max(maxLen, end - start);
			}
		}
		return (maxLen == Integer.MIN_VALUE) ? 0 : maxLen;
	}
}
