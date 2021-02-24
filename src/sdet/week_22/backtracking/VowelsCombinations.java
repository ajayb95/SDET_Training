package sdet.week_22.backtracking;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
*/
public class VowelsCombinations {
	char[] vowels = { 'a', 'e', 'i', 'o', 'u' }; // Definition of the vowel

	@Test
	public void test1() {
		System.out.println(countVowelStrings(3));
	}

	public int countVowelStrings(int n) {
		List<String> lst = new ArrayList<>();
		recursive(n, 0, lst, new StringBuilder());
		return lst.size();
	}

	private void recursive(int n, int start, List<String> lst, StringBuilder s) {
		if (n == 0) { // Base case or Break point
			lst.add(s.toString());
			return;
		}
		// loop
		for (int i = start; i < vowels.length; i++) {
			s.append(vowels[i]); // track
			recursive(n - 1, i, lst, s); // explore recursively
			s.deleteCharAt(s.length() - 1); // backtrack
		}
	}
}
