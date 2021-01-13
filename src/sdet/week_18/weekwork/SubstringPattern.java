package sdet.week_18.weekwork;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"
Output: False
Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/

public class SubstringPattern {

	@Test
	public void example1() {
		String inp = "abab";
		Assert.assertEquals(true, isPatternAvailable(inp));
	}

	@Test
	public void example2() {
		String inp = "aba";
		Assert.assertEquals(false, isPatternAvailable(inp));
	}

	@Test
	public void example3() {
		String inp = "abcabcabcabc";
		Assert.assertEquals(true, isPatternAvailable(inp));
	}
	
	@Test
	public void example4() {
		String inp = "abaababaab";
		Assert.assertEquals(true, isPatternAvailable(inp));
	}

	private boolean isPatternAvailable(String inp) {
		int ptr=inp.length();
		String pat="";
		for (int i = inp.length()-1; i >=0; i--) {
			pat=inp.substring(i, ptr);
			if(inp.startsWith(pat))
				break;
		}
		if(ptr%pat.length()!=0)
			return false;
		
		for (int i = pat.length(); i < ptr; i++) {
			if(!inp.substring(i, i+pat.length()).equals(pat))
				return false;
			i+=pat.length()-1;
		}
		return true;
	}
}
