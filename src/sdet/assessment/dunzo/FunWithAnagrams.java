package sdet.assessment.dunzo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class FunWithAnagrams {

	@Test
	public void example1() {
		String[] input = { "celo", "belo", "lobe", "ecol", "loce" };
		getUniqueList(input);
	}

	@Test
	public void example2() {
		String[] input = { "bacd", "abcd", "cdab" };
		getUniqueList(input);
	}

	@Test
	public void example3() {
		String[] input = { "dace", "cfgh", "bxyv" };
		getUniqueList(input);
	}

	@Test
	public void example4() {
		String[] input = { "testing", "tester", "testgin" };
		getUniqueList(input);
	}

	private void getUniqueList(String[] input) {
		Map<String, String> map = new HashMap<>();

		for (String str : input)
			map.putIfAbsent(getAsciiFormat(str), str);

		Set<String> output = new TreeSet<>();
		output.addAll(map.values());

		System.out.println(output);
	}

	private String getAsciiFormat(String str) {
		int[] ascii = new int[26];
		char[] carr = str.toCharArray();

		for (char ch : carr)
			ascii[ch - 'a']++;

		return Arrays.toString(ascii);
	}
}
