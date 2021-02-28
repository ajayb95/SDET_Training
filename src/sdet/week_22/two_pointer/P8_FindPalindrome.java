package sdet.week_22.two_pointer;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
Given a string with ?, where ? can be replaced with any characters, find whether the given string can form palindrome
if yes, return any combination of the string 
else return "NO"

"a?b" -> "NO"
"ba?ab" -> "baaab"
"b?b" -> "bab"
"???" -> "aaa"
"?bba" -> "abba"
*/

public class P8_FindPalindrome {
	@Test
	public void example1() {
		String inp = "a?b";
		Assert.assertEquals("NO", findPalindrome(inp));
	}

	@Test
	public void example2() {
		String inp = "ba?ab";
		Assert.assertEquals("baaab", findPalindrome(inp));
	}

	@Test
	public void example3() {
		String inp = "b?b";
		Assert.assertEquals("bab", findPalindrome(inp));
	}

	@Test
	public void example4() {
		String inp = "???";
		Assert.assertEquals("aaa", findPalindrome(inp));
	}

	@Test
	public void example5() {
		String inp = "?bba";
		Assert.assertEquals("abba", findPalindrome(inp));
	}

	private String findPalindrome(String inp) {
		char[] arr = inp.toCharArray();
		int left = 0, right = arr.length - 1;

		while (left <= right) {
			if (left == right && arr[left] == '?')
				arr[left++] = 'a';
			else if (arr[left] == '?' && arr[right] != '?')
				arr[left++] = arr[right--];
			else if (arr[left] != '?' && arr[right] == '?')
				arr[right--] = arr[left++];
			else if (arr[left] == '?' && arr[right] == '?') {
				arr[left++] = 'a';
				arr[right--] = 'a';
			} else if (arr[left] == arr[right]) {
				left++;
				right--;
			} else
				return "NO";
		}

		return String.valueOf(arr);
	}
}
