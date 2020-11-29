package sdet.week11.classwork;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
Write a solution to reverse only the vowels of a string.
Input: "hello"
Output: "holle"
"aeiou"
"uoiea"
"testliaaf"
"tastlaief"
*/
public class ReverseVowels {

	@Test
	public void example1() {
		String s = "TestLeaf"; // TastLeef
		reverseVowels(s);
	}

	@Test
	public void example2() {
		String s = "hello"; // TastLeef
		reverseVowels(s);
	}

	@Test
	public void example3() {
		String s = "aeiou"; // TastLeef
		reverseVowels(s);
	}

	private void reverseVowels(String s) {
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		String[] split = s.split("");
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (!vowels.contains(Character.toLowerCase(s.charAt(left))))
				left++;
			if (!vowels.contains(Character.toLowerCase(s.charAt(right))))
				right--;

			if (vowels.contains(Character.toLowerCase(s.charAt(left)))
					&& vowels.contains(Character.toLowerCase(s.charAt(right)))) {
				String temp = split[left];
				split[left++] = split[right];
				split[right--] = temp;
			}
		}
		System.out.println(String.join("", split));

	}
}
