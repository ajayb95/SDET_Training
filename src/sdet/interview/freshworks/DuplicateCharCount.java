package sdet.interview.freshworks;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

//Find occurrence count of duplicate characters

public class DuplicateCharCount {
	@Test
	public void example1() {
		System.out.println("Example 1:");
		String input = "Mathematics";
		findDupCharCount(input);
	}

	@Test
	public void example2() {
		System.out.println("Example 2:");
		String input = "Google";
		findDupCharCount(input);
	}

	private void findDupCharCount(String input) {

		Map<Character, Integer> map = new HashMap<>();
		char[] arr = input.toLowerCase().toCharArray();
		for (char ch : arr)
			map.put(ch, map.getOrDefault(ch, 0) + 1);

		for (Map.Entry<Character, Integer> mp : map.entrySet()) {
			if (mp.getValue() > 1)
				System.out.println(mp.getKey() + " Occurred " + mp.getValue() + " times.");
		}
	}
}
