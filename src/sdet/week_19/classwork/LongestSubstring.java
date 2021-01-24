package sdet.week_19.classwork;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

//Longest substring without repeating characters

//Assumptions:
/*
 * String can have set of lower and upper alphabets
 * String will not have special characters
 * Substring with both lower and upper case of same character is considered as unique (going with ascii)
 * Return the first match
 */

//Pseudo code
//Brute force
/*
 * Convert the string into a character array
 * Add each character to the set
 * if the set already has the character then find the length of the current substring which has unique characters
 * iterate till end of the array
 * finally return the longest substring without repeating characters
 * 
 * Space: O[N]
 * Time:O[N2] -> worst
 * 		O[N] -> best
 * 		O[N*M] -> Average
 */

//ASCII+Sliding
/*
* create an ascii array of length 128 (considering both upper and lower case)
* convert the input string to character array
* add the characters to ascii array (increment the count of the character occurrence)
	* if the character count is 1 i.e. character is already present in the substring, 
	* then shrink the substring until the current character is unique in the substring
* simultaneously calculate the substring without having any duplicate characters
* finally return the substring
* 
* Space: O[N]
* Time: O[N] -> worst
* 		O[N] -> Best
* 		O[N] -> Average
*/

//Hashing+Sliding
/*
 * Convert the string into character array
 * add characters to set
 	* if a character is already present, remove the existing value until the set has only unique values
 * find the max length simultaneously and finally return the max length substring without any repeating characters
 * 
 * Space: O[N]
 * Time:O[N] -> worst
 *		O[N] -> Best
 *		O[N] -> Average
 */

public class LongestSubstring {

	@Test
	public void example1() {
		System.out.println("Test 1");
		String input = "abccddcab";
		System.out.println(bruteForce(input));
		System.out.println(asciiTech(input));
		System.out.println(hashingTech(input));
	}

	@Test
	public void example2() {
		System.out.println("Test 2");
		String input = "abACdccde";
		System.out.println(bruteForce(input));
		System.out.println(asciiTech(input));
		System.out.println(hashingTech(input));
	}

	@Test
	public void example3() {
		System.out.println("Test 3");
		String input = "ab";
		System.out.println(bruteForce(input));
		System.out.println(asciiTech(input));
		System.out.println(hashingTech(input));
	}

	@Test
	public void example4() {
		System.out.println("Test 4");
		String input = "abcdcab";
		System.out.println(bruteForce(input));
		System.out.println(asciiTech(input));
		System.out.println(hashingTech(input));
	}

	@Test
	public void example5() {
		System.out.println("Test 5");
		String input = "";
		System.out.println(bruteForce(input));
		System.out.println(asciiTech(input));
		System.out.println(hashingTech(input));
	}

	private String bruteForce(String input) {
		if (input.length() < 2)
			return input;

		char[] carr = input.toCharArray();
		int start = 0, maxLen = Integer.MIN_VALUE;
		for (int i = 0; i < carr.length; i++) {
			Set<Character> set = new HashSet<>();
			int len = 0;
			for (int j = i; j < carr.length; j++) {
				if (!set.add(carr[j]))
					break;
				len++;
			}
			if (len > maxLen) {
				maxLen = len;
				start = i;
			}
		}
		return input.substring(start, start + maxLen);
	}

	private String asciiTech(String input) {
		if (input.length() < 2)
			return input;

		char[] carr = input.toCharArray();
		int[] ascii = new int[128];

		int start = 0, end = 0;
		int maxLen = Integer.MIN_VALUE, strt = 0;

		while (end < carr.length) {
			if (ascii[carr[end]] == 1)
				ascii[carr[start++]]--;
			else {
				ascii[carr[end++]]++;
				if (end - start > maxLen) {
					maxLen = end - start;
					strt = start;
				}
			}
		}

		return input.substring(strt, strt + maxLen);
	}

	private String hashingTech(String input) {
		if (input.length() < 2)
			return input;
		char[] carr = input.toCharArray();
		Set<Character> set = new HashSet<>();
		int start = 0, end = 0;
		int maxLen = Integer.MIN_VALUE, strt = 0;

		while (end < carr.length) {
			if (!set.add(carr[end]))
				set.remove(carr[start++]);
			else {
				set.add(carr[end++]);
				if (end - start > maxLen) {
					maxLen = end - start;
					strt = start;
				}
			}
		}

		return input.substring(strt, strt + maxLen);
	}

}
