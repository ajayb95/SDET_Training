package sdet.week_18.weekwork;

import org.junit.Assert;
import org.junit.Test;

public class NumberPalindrome {

	@Test
	public void example1() {
		int num = 121;
		Assert.assertEquals(true, isPalindrome(num));
	}

	@Test
	public void example2() {
		int num = -121;
		Assert.assertEquals(false, isPalindrome(num));
	}

	@Test
	public void example3() {
		int num = 10;
		Assert.assertEquals(false, isPalindrome(num));
	}

	@Test
	public void example4() {
		int num = 0;
		Assert.assertEquals(true, isPalindrome(num));
	}

	private boolean isPalindrome(int num) {
		if (num < 0 || (num != 0 && num % 10 == 0))
			return false;
		int op = 0;
		int temp = num;
		while (temp > 0) {
			op = (op * 10) + temp % 10;
			temp /= 10;
		}

		return op == num;
	}
}
