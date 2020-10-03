package sdet.week3.array_string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Test;

public class P3_LongestPalindrome {

	@Test
	public void example1() {
		String input = "ababcacbab";
		longestPalindrome(input);
	}
	
	@Test
	public void example2() {
		String input = "aabaa";
		longestPalindrome(input);
	}
	
	@Test
	public void example3() {
		String input = "aa";
		longestPalindrome(input);
	}
	
	@Test
	public void example4() {
		String input = "abcd";  //expected output for this?
		longestPalindrome(input);
	}

	private void longestPalindrome1(String input) {
		int maxlen = 0;
		String finalString = "";
		for (int i = 0; i < input.length(); i++) {
			for (int j = i; j <= input.length(); j++) {
				String result = input.substring(i, j);
				if (result.equals(new StringBuilder(result).reverse().toString()) && result.length() > maxlen) {
					maxlen = result.length();
					finalString = result;
				}

			}
		}
		System.out.println(finalString);
	}
	
	private void longestPalindrome2(String input) {
		Map<String, Integer> map=new HashMap<>();
		
		for (int i = 0; i < input.length(); i++) {
			for (int j = i; j <= input.length(); j++) {
				String str=input.substring(i, j);
				if(str.equals(new StringBuilder(str).reverse().toString()))
					map.put(str, str.length());
			}
		}
		
		String key = map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
		System.out.println(key);
		
	}

	private void longestPalindrome(String input) {

		int left = 0, right = input.length() - 1;
		String[] split = input.split("");
		while (left < right) {
			String temp = split[left];
			split[left++] = split[right];
			split[right--] = temp;
		}
		String reverseString = String.join("", split);

		int s1start = 0, s1end = s1start + 1, s2start = reverseString.length() - 1, s2end = reverseString.length();
		int maxlen = 0;
		String output = "";
		while (s1start < input.length() && s2end >= 0) {

			if (input.substring(s1start, s1end).equals(reverseString.substring(s2start, s2end))) {
				if (input.substring(s1start, s1end).length() > maxlen) {
					maxlen = input.substring(s1start, s1end).length();
					output = input.substring(s1start, s1end);
				}
			}

			if (s1end == input.length() && s2start == 0) {
				s1start++;
				s1end = s1start + 1;
				s2end--;
				s2start = s2end - 1;
			} else {
				s1end++;
				s2start--;
			}
		}
		System.out.println(output);
	}
}
