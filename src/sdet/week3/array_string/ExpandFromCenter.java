package sdet.week3.array_string;

import org.junit.Test;

public class ExpandFromCenter {

	@Test
	public void example1() {
		String input = "abccb";
		System.out.println(countPalindromeStrings(input));
	}
	
	@Test
	public void example2() {
		String input = "abccba";
		System.out.println(countPalindromeStrings(input));
	}
	
	@Test
	public void example3() {
		String input = "forgeeksskeegfor";
		System.out.println(countPalindromeStrings(input));
	}

	private int countPalindromeStrings(String input) {
		int N = input.length(), result = 0;
		for (int center = 0; center <= 2 * N - 1; ++center) {
			int left = center / 2;
			int right = left + center % 2;
			//System.out.println(left);
			//System.out.println(right);
			//System.out.println(center);
			//System.out.println("__________");
			while (left >= 0 && right < N && input.charAt(left) == input.charAt(right)) {
				result++;
				left--;
				right++;
			}
		}
		return result;
	}
}
