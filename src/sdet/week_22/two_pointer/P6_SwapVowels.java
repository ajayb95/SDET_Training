package sdet.week_22.two_pointer;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/*
Write a function that takes a string as input and reverse only the vowels of a string.
Example 1:
Input: "hello"
Output: "holle"
*/

public class P6_SwapVowels {

	@Test
	public void example1() {
		String inp = "hello";
		Assert.assertEquals("holle", swapVowels(inp));
	}

	@Test
	public void example2() {
		String inp = "welcome";
		Assert.assertEquals("welcome", swapVowels(inp));
	}

	@Test
	public void example3() {
		String inp = "leetcode";
		Assert.assertEquals("leotcede", swapVowels(inp));
	}

	private String swapVowels(String inp) {
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');

		char[] arr = inp.toCharArray();
		char temp;

		int left = 0, right = arr.length - 1;

		while (left < right) {
			if (vowels.contains(Character.toLowerCase(arr[left]))
					&& vowels.contains(Character.toLowerCase(arr[right]))) {
				temp = arr[right];
				arr[right--] = arr[left];
				arr[left++] = temp;
			} else if (!vowels.contains(Character.toLowerCase(arr[left])))
				left++;
			else
				right--;
		}
		
		return String.valueOf(arr);
	}

	private String swapVowels1(String inp) {
		Set<Character> vowels = "aeiou".chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet());
		char[] arr = inp.toCharArray();
		int left = 0, right = arr.length - 1;

		while (left < right) {
			while (!vowels.contains(arr[left]))
				left++;

			while (!vowels.contains(arr[right]))
				right--;

			if (left < right && vowels.contains(arr[left]) && vowels.contains(arr[right])) {
				char temp = arr[right];
				arr[right--] = arr[left];
				arr[left++] = temp;
			}
		}

		return String.valueOf(arr);
	}
}
