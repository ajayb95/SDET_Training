package sdet.interview.others;

import org.junit.Assert;
import org.junit.Test;

//Fivetran
/*
Z -> A -> B -> C -> D -> E -> F -> G -> H -> I -> J -> K -> L -> M -> N -> O -> P -> Q -> R -> S -> T -> U -> V -> W -> X -> Y -> Z -> A
Given an encrypted string consisting of English letters A-Z only, decrypt the string by replacing each character with 
the kth character away on the wheel in the counter clockwise direction.

Input="VTAOG"
k=2
Output: TRYME

Input="CDEF"
k=2
Output: ABCD

Input="DGEO"
k=3
Output: ADBL
*/

public class DecryptString {

	@Test
	public void example1() {
		String input = "VTAOG";
		int k = 2;
		Assert.assertEquals("TRYME", decryptString(input, k));
	}

	@Test
	public void example2() {
		String input = "CDEF";
		int k = 2;
		Assert.assertEquals("ABCD", decryptString(input, k));
	}

	@Test
	public void example3() {
		String input = "DGEO";
		int k = 3;
		Assert.assertEquals("ADBL", decryptString(input, k));
	}

	@Test
	public void example4() {
		String input = "DGEO";
		int k = 28;
		Assert.assertEquals("BECM", decryptString(input, k));
	}

	private String decryptString(String input, int k) {
		char[] carr = input.toCharArray();
		//int temp = 0;
		k %= 26;

		for (int i = 0; i < carr.length; i++) {
//			temp = carr[i] - k;
//			if (temp >= 'A')
//				carr[i] = (char) (temp);
//			else
//				carr[i] = (char) (temp + 26);

			carr[i] -= k;
			if (carr[i] < 'A')
				carr[i] += 26;
		}

		return String.valueOf(carr);
	}
}
