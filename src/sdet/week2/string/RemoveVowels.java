package sdet.week2.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class RemoveVowels {

	@Test
	public void example1() {
		String input = "Testleaf";
		removeVowels(input);
		/*
		 * for (int i = 0; i < input.length(); i++) {
		 * if(input.lastIndexOf(input.charAt(i))==i)
		 * System.out.println(input.charAt(i)); }
		 */
	}

	private void removeVowels1(String input) {

		char[] vow = { 'a', 'e', 'i', 'o', 'u' };
		Map<Character, Integer> map = new HashMap<>();

		for (char c : input.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		/*
		 * for (char c : vow) { if(map.containsKey(c)) map.remove(c); }
		 */

		for (int i = 0; i < vow.length; i++) {
			// if(map.containsKey(vow[i]))
			// input.replace(oldChar, newChar)
		}

	}

	private void removeVowels(String input) {
		StringBuilder sb = new StringBuilder(input);
		List<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		int i = 0;
		while (i < sb.length()) {
			if (list.contains(sb.charAt(i)))
				sb.replace(i, i + 1, "");
			else
				i++;
		}

		System.out.println(sb.toString());
	}
}
