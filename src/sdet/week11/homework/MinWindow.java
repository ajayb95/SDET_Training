package sdet.week11.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
Given 2 input strings, return the minimum window in the first string which will contain all the characters in second string.

Input: str1 = "KSTRKSE", str2 = "KST"
Output: "KST"

Input: str1 = "KASRTRKSE", str2 = "ST"
Output: "SRT"

Algorithm: Sliding Window

Explanation: There are 2 matches "SRT" and "TRKS" and out of this first one is shorter window
*/

public class MinWindow {

	@Test
	public void example1() {
		String str1 = "RKSEKST";
		String str2 = "KST";
		System.out.println(minWindow(str1, str2));
	}

	@Test
	public void example2() {
		String str1 = "KASRTRKSE";
		String str2 = "ST";
		System.out.println(minWindow(str1, str2));
	}

	@Test
	public void example3() {
		String str1 = "ADOBECODEBANC";
		String str2 = "ABC";
		System.out.println(minWindow(str1, str2));
	}

	@Test
	public void example4() {
		String str1 = "bdab";
		String str2 = "ab";
		System.out.println(minWindow(str1, str2));
	}

	@Test
	public void example5() {
		String str1 = "bb";
		String str2 = "a";
		System.out.println(minWindow(str1, str2));
	}

	//Working
	private String minWindow(String str1, String str2) {
		int l1 = str1.length();
		int l2 = str2.length();
		
		//if pattern is greater than actual string then return as no window exists
		if (l2 > l1)
			throw new RuntimeException("No window exists");
		
		//Initialize ASCII arrays for string and pattern
		int[] str = new int[126];
		int[] pat = new int[126];

		//Find character count in pattern
		for (char c : str2.toCharArray())
			pat[c]++;
		
		int start = 0, startInd = -1, minLen = Integer.MAX_VALUE, cnt = 0;
		
		//Slide through string
		for (int j = 0; j < l1; j++) {
			str[str1.charAt(j)]++;	//add count of the character from string

			if (pat[str1.charAt(j)] != 0 && str[str1.charAt(j)] <= pat[str1.charAt(j)]) //if character available in pattern is also available in string
				cnt++;	//increase the count
			
			//increase the window until all character in pattern is available in window 
			if (cnt == l2) {
				// Try to minimize the window i.e., check if any character is occurring more no. of times 
                // than its occurrence in pattern, if yes then remove it from starting and also remove 
                // the useless characters. 
				while (str[str1.charAt(start)] > pat[str1.charAt(start)] || pat[str1.charAt(start)] == 0) {
					if (str[str1.charAt(start)] > pat[str1.charAt(start)])
						str[str1.charAt(start)]--;
					start++;
				}
				int winLen = j - start + 1;
				if (minLen > winLen) {
					minLen = winLen;
					startInd = start;
				}
			}
		}

		if (startInd == -1)
			throw new RuntimeException("No window exists");

		return str1.substring(startInd, startInd + minLen);
	}

	private String minWindow2(String str1, String str2) {
		if (str2.length() > str1.length())
			return "";

		Map<Character, Integer> m1 = new HashMap<>();
		Map<Character, Integer> m2 = new HashMap<>();

		for (char s : str2.toCharArray())
			m2.put(s, m2.getOrDefault(s, 0) + 1);

		m1.putAll(m2);
		int start = 0;
		String op = "";

		for (int i = 0; i < str1.length(); i++) {
			if (m1.containsKey(str1.charAt(i))) {
				if (m1.get(str1.charAt(i)) > 1)
					m1.put(str1.charAt(i), m1.get(str1.charAt(i)) - 1);
				else
					m1.remove(str1.charAt(i));
			} else if (!m1.containsKey(str1.charAt(i)) && m2.containsKey(str1.charAt(i))) {
				start = i;
				m1.putAll(m2);
				if (m1.get(str1.charAt(i)) > 1)
					m1.put(str1.charAt(i), m1.get(str1.charAt(i)) - 1);
				else
					m1.remove(str1.charAt(i));
			}

			if (m1.isEmpty()) {
				if (op == "")
					op = str1.substring(start, i + 1);
				else if (op.length() > str1.substring(start, i + 1).length())
					op = str1.substring(start, i + 1);
			}
		}

		if (op.length() > 0) {
			int minStart = Integer.MAX_VALUE;
			for (Map.Entry<Character, Integer> mp : m2.entrySet())
				minStart = Math.min(minStart, op.indexOf(mp.getKey()));
			return op.substring(minStart);
		} else
			return "";
	}

	/*
	 * Create sets for each string add all characters in string 2 to set2 slide
	 * through the string 1 and continuously check if all characters in set2 is
	 * available in set1 if yes, then shrink the window to get minimum length
	 * containing all characters if shrink window doesn't contain all characters for
	 * str2 then add next element to it traverse till end of the str1 return the
	 * string with min length having all characters of str2
	 */

	private String minWindow1(String str1, String str2) {
		Set<Character> set1 = new HashSet<>();
		Set<Character> set2 = new HashSet<>();
		for (char c : str2.toCharArray())
			set2.add(c);

		int start = 0, end = 0;
		int minLen = Integer.MAX_VALUE;
		String op = "";
		while (end < str1.length()) {
			if (set1.containsAll(set2)) {
				if ((end - start) < minLen) {
					minLen = end - start;
					op = str1.substring(start, end);
				}
				set1.remove(str1.charAt(start++));
				if (end == str1.length() - 1 && end - start < str2.length())
					break;
			} else {
				set1.add(str1.charAt(end++));
			}
		}

		return op;
	}
}
