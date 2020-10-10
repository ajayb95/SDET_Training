package sdet.week2.homework;
/*
8) Given 2 Strings with length n and (n+1) respectively. 
The second String contains all the characters of first but with an extra char. Write the code to find the extra char

Example 1:

Input:

A1 = "Test"
A2 = "Test$"

Output: '$'

Example 2:

Input:

A1 = "Hello"
A2 = "lloreH"

Output: 'r'
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class P8_ExtraChar {

	@Test
	public void example1() {
		String s1 = "Tester";
		String s2 = "Testerr$";
		extraChar(s1, s2);
	}

	@Test
	public void example2() {
		String s1 = "Hello";
		String s2 = "lloreH";
		extraChar(s1, s2);
	}

	private void extraChar2(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		String concat = s1.concat(s2);
		for (char c : concat.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);

		Object[] array = map.entrySet().stream().filter(m -> m.getValue() == 1).flatMap(mp -> Stream.of(mp.getKey()))
				.collect(Collectors.toList()).toArray();
		System.out.println(Arrays.toString(array));

	}

	private void extraChar(String s1, String s2) {
		StringBuilder sb = new StringBuilder(s2);

		for (int i = 0; i < s1.length(); i++)
			sb.deleteCharAt(sb.indexOf(String.valueOf(s1.charAt(i))));

		System.out.println(sb);
		
		/*
		 * Set<Integer> set=new HashSet<Integer>(Arrays.asList(1,4,5,3,2)); Set<Integer>
		 * set1=new HashSet<Integer>(Arrays.asList(1,5,6,7,8));
		 * 
		 * set.retainAll(set1); System.out.println(set);
		 */
	}
}
