package sdet.string;

import org.junit.Test;

/*
1) Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Input:  "I am doing great"
Output: "I ma gniod taerg"
*/

public class P1_ReverseSentenceWord {

	@Test
	public void example1() {
		System.out.println("Example 1");
		String input = "I am doing great";
		// reverseSentence(input);
		reverseString(input);

	}

	@Test
	public void example2() {
		System.out.println("Example 1");
		String input = "Let’s take LeetCode contest";
		// reverseSentence(input);
		reverseString(input);

	}

	private void reverseSentence(String input) {
		String[] split = input.split(" ");
		String output = "";
		for (String str : split) {
			char[] cArray = str.toCharArray();
			int left = 0;
			int right = cArray.length - 1;
			while (left < right) {
				char temp = cArray[left];
				cArray[left++] = cArray[right];
				cArray[right--] = temp;

			}
			String inter = "";
			for (char c : cArray)
				inter += c;
			output += inter + " ";
		}
		System.out.println(output.trim());
	}

	private void reverseString(String input) {
		// char[] charArray = input.toCharArray();
		StringBuilder sb = new StringBuilder(input);

		// sb.reverse();
		int left = 0;
		int right = input.length() - 1;
		for (int i = 0; i < input.length(); i++) {
			if (left < right) {
				char temp = sb.charAt(left);
				sb.setCharAt(left++, sb.charAt(right));
				sb.setCharAt(right--, temp);
			} else
				break;
		}

		String[] split = sb.toString().split(" ");
		String output = "";
		for (int i = split.length - 1; i >= 0; i--)
			output += split[i] + " ";
		// System.out.println(String.join(" ", split));
		System.out.println(output.trim());
	}
}
