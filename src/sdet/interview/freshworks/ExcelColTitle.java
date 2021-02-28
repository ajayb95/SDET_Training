package sdet.interview.freshworks;

import org.junit.Assert;
import org.junit.Test;

/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
*/

public class ExcelColTitle {
	@Test
	public void example1() {
		int n = 1;
		Assert.assertEquals("A", getCellTitle(n));
	}

	@Test
	public void example2() {
		int n = 28;
		Assert.assertEquals("AB", getCellTitle(n));
	}

	@Test
	public void example3() {
		int n = 701;
		Assert.assertEquals("ZY", getCellTitle(n));
	}

	@Test
	public void example4() {
		int n = 704;
		Assert.assertEquals("AAB", getCellTitle(n));
	}

	private String getCellTitle(int n) {
		StringBuilder sb = new StringBuilder();

		char[] alpha = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		while (n > 26) {

			if (n % 26 == 0) {
				sb.append('Z');
				n = (n / 26) - 1;
			} else {
				sb.append(alpha[(n % 26) - 1]);
				n /= 26;
			}
		}

		sb.append(alpha[n - 1]);

		return sb.reverse().toString();
	}
}
