package sdet.week2.hw;
/*
6) Given a string, how many palindromic substrings in this string.

Example 1:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

Example 2:

Input: "aabc"
Output: 4
Explanation: Three palindromic strings: "a", "b", "c", "aa".
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
		//System.out.println(list);
	}
	
	private void palindrome(String input) {
		List<String> list = new ArrayList<String>();
		String reverse=new StringBuilder(input).reverse().toString();
		int count=input.length();
		
		for (int i = 0; i < input.length(); i++) {
			for (int j = i+2; j <= input.length(); j++) {
				System.out.println(input.substring(i, j));
				System.out.println("--");
				System.out.println(reverse.substring(i,j ));
			}
		}
	}
}
