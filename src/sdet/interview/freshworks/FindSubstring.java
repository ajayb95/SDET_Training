package sdet.interview.freshworks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
 * input_string ="aabbcfba" distinct_array=[a,b,c,f] -> cfba
 * "abbccfa" -> "bccfa"
 * "abbcfaab" -> "bcfa"
 * "AabB" -> "AabB"
 * "abcab" -> "abc"
 * "" -> throw exception
 */
public class FindSubstring {

	@Test
	public void example1() {
		String input = "aabbcfba";
		Assert.assertEquals("cfba", findMinSubstring(input));
	}

	@Test
	public void example2() {
		String input = "abbccfa";
		Assert.assertEquals("bccfa", findMinSubstring(input));
	}

	@Test
	public void example3() {
		String input = "abbcfaab";
		Assert.assertEquals("bcfa", findMinSubstring(input));
	}

	@Test
	public void example4() {
		String input = "AabB";
		Assert.assertEquals("AabB", findMinSubstring(input));
	}

	@Test
	public void example5() {
		String input = "";
		Assert.assertEquals("cfba", findMinSubstring(input));
	}

	@Test
	public void example6() {
		String input = "abcba";
		Assert.assertEquals("abc", findMinSubstring(input));
	}

	private Object findMinSubstring(String input) {
		int len = input.length();
		if (len == 0)
			throw new RuntimeException("String is empty");

		Set<Character> set = new HashSet<>();
		char[] arr = input.toCharArray();
		for (char ch : arr)
			set.add(ch);
		int size = set.size();
		Map<Character, Integer> map = new HashMap<>();

		int end = 0, start = 0;
		int minLen = Integer.MAX_VALUE;
		int minStart = 0;
		while (end < len) {
			map.put(arr[end], map.getOrDefault(arr[end++], 0) + 1);

			while (map.size() == size) {
				if (end - start < minLen) {
					minLen = end - start;
					minStart = start;
				}

				if (map.get(arr[start]) > 1)
					map.put(arr[start], map.get(arr[start]) - 1);
				else
					map.remove(arr[start]);

				start++;
			}
		}

		return input.substring(minStart, minStart + minLen);

	}
}
