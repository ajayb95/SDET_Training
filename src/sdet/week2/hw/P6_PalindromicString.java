package sdet.week2.hw;
/*
6) Given a string, how many palindromic substrings in this string.

Example 1:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

Example 2:

Input: "aabc"
Output: 5
Explanation: Three palindromic strings: "a", "a", "b", "c", "aa".
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class P6_PalindromicString {

	@Test
	public void example1() {
		String input = "aaa";
		palindrome(input);
	}

	@Test
	public void example2() {
		String input = "aabc";
		palindrome(input);
	}

	@Test
	public void example3() {
		String input = "abcd";
		palindrome(input);
	}

	@Test
	public void example4() {
		String input = "aa";
		palindrome(input);
	}

	private void palindrome1(String input) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j <= input.length(); j++) {
				String str = input.substring(i, j);
				if (str.equals(new StringBuilder(str).reverse().toString()))
					list.add(str);
			}
		}
		System.out.println(list.size());
		// System.out.println(list);
	}

	private void palindrome2(String input) {
		List<String> list = new ArrayList<String>();
		String reverse = new StringBuilder(input).reverse().toString();
		int count = input.length();

		int start;
		int end = input.length();
		for (int i = 0; i < input.length(); i++) {
			start = input.length() - (i + 2);
			for (int j = i + 2; j <= input.length(); j++) {
				if (input.substring(i, j).equals(reverse.substring(start--, end)))
					count++;
			}
			end--;
		}
		System.out.println(count);
	}

	private void palindrome(String input) {

		int s1 = 0, e1 = s1 + 1, s2 = input.length() - 1, e2 = input.length();
		String reverse = new StringBuilder(input).reverse().toString();
		int count = 0;

		while (s1 < input.length() && e2 >= 0) {
			// System.out.println("1." + input.substring(s1, e1));
			// System.out.println("2." + reverse.substring(s2, e2));

			if (input.substring(s1, e1).equals(reverse.substring(s2, e2)))
				count++;

			if (e1 == input.length() && s2 == 0) {
				s1++;
				e1 = s1 + 1;
				e2--;
				s2 = e2 - 1;
			} else {
				e1++;
				s2--;
			}
		}
		System.out.println(count);
	}
}
