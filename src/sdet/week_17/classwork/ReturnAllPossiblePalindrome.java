package sdet.week_17.classwork;

import org.junit.Assert;
import org.junit.Test;

public class ReturnAllPossiblePalindrome {

	@Test
	public void example1() {
		String input="aaa";
		Assert.assertEquals(6, findPalindromeSubstringCount(input));
	}
	
	@Test
	public void example2() {
		String input="abc";
		Assert.assertEquals(3, findPalindromeSubstringCount(input));
	}
	
	@Test
	public void example3() {
		String input="z";
		Assert.assertEquals(1, findPalindromeSubstringCount(input));
	}
	
	@Test
	public void example4() {
		String input="aab";
		Assert.assertEquals(4, findPalindromeSubstringCount(input));
	}
	
	@Test
	public void example5() {
		String input="dacad";
		Assert.assertEquals(7, findPalindromeSubstringCount(input));
	}
	
	@Test
	public void example6() {
		String input="baababb";
		Assert.assertEquals(12, findPalindromeSubstringCount(input));
	}
	
	//Pseudo code
	/*
	 * initialize 2 variables left and right to expand from center
	 * initialize count variable
	 * from each character as center, check its left character and right character is equal, then increase the count
	 * finally return the count of palindrome substrings in the input string
	 */
	//Space: O[1]
	//Time: O[N^2]
	private int findPalindromeSubstringCount(String input) {
		int cnt = 0, left = 0, right = 0;
		int len = input.length();
		for (int mid = 0; mid < 2 * len; mid++) {
			left = mid / 2;
			right = left + mid % 2;
			while (left >= 0 && right < len && input.charAt(left--) == input.charAt(right++))
				cnt++;
		}
		return cnt;
	}
}
