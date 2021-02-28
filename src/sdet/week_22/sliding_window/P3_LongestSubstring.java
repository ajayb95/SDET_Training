package sdet.week_22.sliding_window;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*
Given a string s that consists of only upper case letters, you can perform at most k operations on that string.
In one operation, you can choose any character of the string and change it to any other upper case character.
Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
Example 1:
Input:
s = "ABAB", k = 2
Output:
4
Explanation:
Replace the two 'A's with two 'B's or vice versa.
Example 2:
Input:
s = "AABABBA", k = 1
Output:
4
Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
*/

public class P3_LongestSubstring {
	@Test
	public void example1() {
		String input = "ABAB";
		int k = 2;
		Assert.assertEquals(4, findSubstringLen(input, k));

	}

	@Test
	public void example2() {
		String input = "ABBACCA";
		int k = 2;
		Assert.assertEquals(4, findSubstringLen(input, k));
	}

	@Test
	public void example3() {
		String input = "ABCCC";
		int k = 2;
		Assert.assertEquals(5, findSubstringLen(input, k));
	}

	@Test
	public void example4() {
		String input = "AABBAACC";
		int k = 2;
		Assert.assertEquals(6, findSubstringLen(input, k));
	}

	@Test
	public void example5() {
		String input = "AABABBA";
		int k = 1;
		Assert.assertEquals(4, findSubstringLen(input, k));
	}

	@Test
	public void example6() {
		String input = "AABCBB";
		int k = 2;
		Assert.assertEquals(5, findSubstringLen(input, k));
	}

	private int findSubstringLen(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		char[] carr = s.toCharArray();
		int len = carr.length;
		int start = 0, end = 0;
		int maxOcc = 0, maxLen = Integer.MIN_VALUE;

		while (end < len) {
			map.put(carr[end], map.getOrDefault(carr[end], 0) + 1);
			maxOcc = Math.max(maxOcc, map.get(carr[end++]));

			if (end - start - maxOcc > k)
				map.put(carr[start], map.get(carr[start++]) - 1);

			maxLen = Math.max(maxLen, end - start);
		}

		return maxLen;
	}
}
