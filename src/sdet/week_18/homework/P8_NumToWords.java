package sdet.week_18.homework;

import org.junit.Assert;
import org.junit.Test;

/*
https://leetcode.com/problems/integer-to-english-words/
*/

/*
Convert a non-negative integer num to its English words representation.

Example 1:
Input: num = 123
Output: "One Hundred Twenty Three"

Example 2:
Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:
Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:
Input: num = 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 
Constraints:
0 <= num <= 231 - 1
*/
public class P8_NumToWords {
	String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	@Test
	public void example1() {
		int num = 123;
		Assert.assertEquals("One Hundred Twenty Three", convertToWords(num));
	}

	@Test
	public void example2() {
		int num = 12345;
		Assert.assertEquals("Twelve Thousand Three Hundred Forty Five", convertToWords(num));
	}

	@Test
	public void example3() {
		int num = 1234567;
		Assert.assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
				convertToWords(num));
	}

	@Test
	public void example4() {
		int num = 1234567891;
		Assert.assertEquals(
				"One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",
				convertToWords(num));
	}

	@Test
	public void example5() {
		int num = 10000011;
		Assert.assertEquals("Ten Million Eleven", convertToWords(num));
	}

	private String convertToWords(int num) {
		if (num > Integer.MAX_VALUE || num < 1)
			throw new RuntimeException("Invalid number");

		return helperFunc(num);
	}

	private String helperFunc(int num) {
		if (num >= 1000000000)
			return helperFunc(num / 1000000000) + " Billion " + helperFunc(num % 1000000000);
		else if (num >= 1000000)
			return helperFunc(num / 1000000) + " Million " + helperFunc(num % 1000000);
		else if (num >= 1000)
			return helperFunc(num / 1000) + " Thousand " + helperFunc(num % 1000);
		else if (num >= 100)
			return helperFunc(num / 100) + " Hundred " + helperFunc(num % 100);
		else if (num >= 20)
			return tens[num / 10] + " " + helperFunc(num % 10);
		else
			return ones[num];
	}
}
