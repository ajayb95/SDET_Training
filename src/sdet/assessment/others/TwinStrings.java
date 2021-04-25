package sdet.assessment.others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*
Two strings are called twin if they can be made equivalent by performing some number of operations in one or both strings.
There are two possible operations:
SwapEven: Swap a character at an even-numbered index with the character at another even-numbered index
SwapOdd: Swap a character at an odd-numbered index with the character at another odd-numbered index

There will be two string arrays. At each index of two array, compare a string from each array, aligned by index, 
and store the result in final string array. The return array should consist of string either "Yes" or "No", based on whether
the strings compared are twins or not

firstString = { "abcd", "abcd" }
secondString = { "cbad", "adbc" }

* Compare the two strings firstString[0] and secondString[0]. One swap even operation allows us to swap the characters a and c of the string abcd and 
make it equivalent to cbad. The answer is "Yes".
* Compare the two strings firstString[1] and secondString[1]. No swap odd or even operations can make the strings twins. The answer is "No".

*/

public class TwinStrings {

	@Test
	public void example1() {
		String[] a = { "abcd", "abcd" };
		String[] b = { "cbad", "adbc" };
		twinStrings(a, b);
	}

	@Test
	public void example2() {
		String[] a = { "cdab", "dcba", "abcd" };
		String[] b = { "abcd", "abcd", "abcdcd" };
		twinStrings(a, b);
	}

	@Test
	public void example3() {
		String[] a = { "abbc", "abbdd" };
		String[] b = { "abbc", "ddbba" };
		twinStrings(a, b);
	}

	@Test
	public void example4() {
		String[] a = { "av", "zbmweyy", "d", "yfwu", "v" };
		String[] b = { "bv", "zbmweyya", "da", "yuwf", "v" };
		twinStrings(a, b);
	}

	private void twinStrings(String[] a, String[] b) {
		List<String> output = new ArrayList<>();
		Set<Character> oddA, oddB, evenA, evenB;
		int aLen = 0, bLen = 0;
		for (int i = 0; i < a.length; i++) {
			oddA = new HashSet<>();
			oddB = new HashSet<>();
			evenA = new HashSet<>();
			evenB = new HashSet<>();
			aLen = a[i].length();
			bLen = b[i].length();
			if (aLen == bLen) {
				for (int j = 0; j < aLen; j++) {
					if (j % 2 == 0) {
						evenA.add(a[i].charAt(j));
						evenB.add(b[i].charAt(j));
					} else {
						oddA.add(a[i].charAt(j));
						oddB.add(b[i].charAt(j));
					}
				}
			} else {
				output.add("No");
				continue;
			}

			if (oddA.equals(oddB) && evenA.equals(evenB))
				output.add("Yes");
			else
				output.add("No");
		}

		System.out.println(output);
	}
}
