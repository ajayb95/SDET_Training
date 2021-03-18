package sdet.assessment.others;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/*
You are given a string, identify all substring by dividing the string from 1 to len. Calculate the number of occurrences of
each substring.

Input: "ababa"
Output:
3 2 2 1 1 

3 ("a" occurs 3 times), 2 ("ab" occurs 2 times), 2 ("aba" occurs 2 times), 1 ("abab" occurs 1 time), 1 ("ababa" occurs 1 time)
*/

public class FindOccurrences {

	@Test
	public void example1() {
		String inp = "ababa";
		findOccurences(inp);
	}

	private void findOccurences(String inp) {
		Map<String, Integer> map = new LinkedHashMap<>();
		int len=inp.length();
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				map.put(inp.substring(i, j), map.getOrDefault(inp.substring(i, j), 0) + 1);
			}
		}

		for (int i = 1; i <= len; i++) {
			System.out.print(map.get(inp.substring(0, i))+" ");
		}
	}
}
