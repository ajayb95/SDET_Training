package sdet.assessment.others;

import org.junit.Test;

/*
 * Amazon:
You are given a string made of lower case English letters a,b,c. Your task is to minimize the length of the string by applying the following operation on the string.
1. Divide the string into two non-empty parts, left and right part
2. Without reversing any of the parts, swap them with each other by appending the left part to the end of the right part
3. While appending, if the suffix string of the right part and the prefix string of the left part contain the same character, then you can remove those characters from the suffix and prefix fo the right and left part respectively
4. Repeat the third step until you do not find such prefix and suffix strings
Determine the min length of the string after applying the above operations exactly once on a string
e.g:
"aabcccabba"
Left: aabcc right: cabba
cabbaaabcc -> cabbbcc -> cacc
Output: cacc -> 4
 */
public class StringMinimisation {

	@Test
	public void test1() {
		String s = "aabcccabba";
		System.out.println(minimize(s));
	}
	
	@Test
	public void test2() {
		String s = "ababcacbbc";
		System.out.println(minimize(s));
	}
	
	@Test
	public void test3() {
		String s = "cbaaaaaaabbc";
		System.out.println(minimize(s));
	}

	private int minimize(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right && s.charAt(left) == s.charAt(right)) {
			int c = s.charAt(left);
			while (left <= right && s.charAt(left) == c) left++;
			while (left <= right && s.charAt(right) == c) right--;
		}
		return right - left + 1;

	}
}
