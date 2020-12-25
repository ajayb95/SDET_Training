package sdet.assessment.week4;
/*
Given a string, construct a new string by rearranging the original string
and deleting characters as needed. Return the alphabetically largest
string that can be constructed respecting a limit as to how many
consecutive characters can be the same.

Example
s = 'baccc'
k = 2

The largest string, alphabetically, is 'cccba' but it is not allowed because
it uses the character 'c' more than 2 times consecutively. Therefore, the
answer is 'ccbca'.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class P3_LargestString {

	@Test
	public void example1() {
		String input = "baccc";
		int k = 2;
		largestString(input, k);
	}

	@Test
	public void example2() {
		String input = "zzzazz";
		int k = 2;
		largestString(input, k);
	}

	@Test
	public void example3() {
		String input = "axxzzx";
		int k = 2;
		largestString(input, k);
	}

	private void largestString(String s, int k) {
		String outputStr = "";
		int i = 255;
		boolean isThere = false;

		int[] count = new int[256];
		for (int j = 0; j < s.length(); j++) {
			count[s.charAt(j)]++;
		}

		while (i >= 0) {
			for (int j = 0; j < Math.min(count[i], k); j++) {
				outputStr += "" + (char) (i);
			}

			count[i] -= Math.min(count[i], k);
			if (count[i] == 0) {
				i -= 1;
				continue;
			}

			isThere = false;

			for (int j = i - 1; j >= 0; j--) {
				if (count[j] > 0) {
					outputStr += "" + (char) (j);
					count[j] -= 1;
					isThere = true;
					break;
				}
			}

			if (isThere == false)
				break;

		}
		// return outputStr;
		System.out.println(outputStr);

	}

	private void largestString2(String input, int k) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (char c : input.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		String op = "";
		for (int i = (int) 'z'; i >= (int) 'a'; i--) {
			char c = (char) i;
			if (map.containsKey(c)) {
				if (map.get(c) >= k) {
					for (int j = 0; j < k; j++) {
						op += c;
					}
					map.put(c, map.get(c) - k);
				} else {
					op += c;
				}
			}
		}

		System.out.println(op);
	}

	private void largestString1(String input, int k) {

		List<Character> unique = new ArrayList<>();
		List<Character> repeat = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			if (input.lastIndexOf(input.charAt(i)) != input.indexOf(input.charAt(i)))
				repeat.add(input.charAt(i));
			else
				unique.add(input.charAt(i));
		}
		Collections.sort(repeat, Collections.reverseOrder());
		Collections.sort(unique, Collections.reverseOrder());

		List<Character> output = new ArrayList<>();
		int cnt = 0, j = 0;
		for (int i = 0; i < repeat.size(); i++) {
			output.add(repeat.get(j++));
			cnt++;
			if (cnt == k && repeat.get(j - 1) != repeat.get(j)) {
				cnt = 0;
			} else if (cnt == k && unique.size() > 0) {
				output.add(unique.get(0));
				unique.remove(0);
				cnt = 0;
			} else if (cnt > k && unique.size() == 0) {
				output.remove(i);
			}
		}
		output.addAll(unique);
		System.out.println(output);
	}

}
