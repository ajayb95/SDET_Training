package sdet.week13.weekwork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*Given a string, find the length of the longest substring T that contains at most k distinct characters.
e.g.:
Input: s="eceba", k=2
Output: 3
Explanation: T is "ece" which its length is 3

e.g.:2
Input: s="aa", k=1
Output: 2
Explanation: T is "aa" which its length is 2*/

public class P1_LongSubstring {

	@Test
	public void example1() {
		String s = "eceba";
		int k = 2;
		System.out.println(longSubstring(s, k));
		System.out.println(bruteForce(s, k));
	}

	@Test
	public void example2() {
		String s = "Aa";
		int k = 1;
		System.out.println(longSubstring(s, k));
		System.out.println(bruteForce(s, k));
	}

	@Test
	public void example3() {
		String s = "abcd";
		int k = 1;
		System.out.println(longSubstring(s, k));
		System.out.println(bruteForce(s, k));
	}

	@Test
	public void example4() {
		String s = "";
		int k = 1;
		System.out.println(longSubstring(s, k));
		System.out.println(bruteForce(s, k));
	}

	@Test
	public void example5() {
		String s = "abcd";
		int k = -1;
		System.out.println(longSubstring(s, k));
		System.out.println(bruteForce(s, k));
	}

	// Pseudo Code
	// Space Complexity: O[N]
	// Time Complexity: O[N]
	// Window+Hashing
	/*
	 * add each element to a hashmap with its occurance count for each iteration
	 * check if the map keyset matches k if yes, get the max length if keyset
	 * doesn't matches k, remove start element from the map when iterated through
	 * each element from the string, return the max length
	 */
	private int longSubstring(String s, int k) {
		if (s.length() == 0 || k <= 0)
			throw new RuntimeException("Invalid input");

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0, end = 0, maxLen = Integer.MIN_VALUE;

		while (end < s.length()) {
			char c = s.charAt(end++);
			map.put(c, map.getOrDefault(c, 0) + 1);

			if (map.keySet().size() <= k)
				maxLen = Math.max(end - start, maxLen);
			else {
				if (map.get(s.charAt(start)) == 1)
					map.remove(s.charAt(start++));
				else
					map.put(s.charAt(start), map.get(s.charAt(start++)) - 1);
			}
		}
		return maxLen;
	}

	// Pseudo Code
	// Space complexity: O[N]
	// Time complexity: O[N^2]
	/*
	 * Start from first character in the string add corresponding characters to a
	 * set until it becomes greater than k if set size becomes greater than k, then
	 * set max length if current length is greater than previous one break the loop
	 * again start from second character iterate till end of the string finally
	 * return the max length
	 */
	private int bruteForce(String s, int k) {

		if (s.length() == 0 || k <= 0)
			throw new RuntimeException("Invalid input");

		Set<Character> set = new HashSet<Character>();
		int maxLen = Integer.MIN_VALUE;
		char[] carr = s.toCharArray();

		for (int i = 0; i < carr.length; i++) {
			for (int j = i; j < carr.length; j++) {
				set.add(carr[j]);
				if (set.size() > k) {
					maxLen = Math.max(maxLen, j - i);
					break;
				}
			}
			set.clear();
		}
		return maxLen;
	}
}
