package sdet.string;

import java.util.Arrays;

import org.junit.Test;

public class ReverseString {

	@Test
	public void example1() {

		String input = "Welcome";

		String reverseString = twoPointerAlgo(input);
		System.out.println(reverseString);

	}

	@Test
	public void example2() {
		String input = "Me";
		String reverseString = twoPointerAlgo(input);
		System.out.println(reverseString);
	}

	@Test
	public void example3() {
		String input = "insert";
		String reverseString = twoPointerAlgo(input);
		System.out.println(reverseString);
	}

	@Test
	public void example4() {
		String input = "M";
		String reverseString = twoPointerAlgo(input);
		System.out.println(reverseString);
	}

	private String reverseString(String input) {
		String output = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			output += input.charAt(i);
		}
		return output;
	}

	private String reverseString1(String input) {

		StringBuilder st = new StringBuilder(input);
		return st.reverse().toString();
	}

	private void reverseString3(String input) {

		String output = "";
		char[] charArray = input.toCharArray();
		for (char a : charArray)
			output += a;

	}

	private String twoPointerAlgo(String input) {
		char[] charArray = input.toCharArray();
		int left = 0, right = charArray.length - 1;
		char temp;
		while (left < right) {
			temp = charArray[left];
			charArray[left++] = charArray[right];
			charArray[right--] = temp;
		}

		return Arrays.toString(charArray);
	}
}
