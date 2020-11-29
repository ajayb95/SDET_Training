package sdet.week11.classwork;
/*
Given 2 strings, find all the start indices of second string anagrams in first string.
Note:
Strings consists of lowercase letters only 
The order of output does not matter.
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]
Input:
s: "testetr" p: "te"
Output:
[0, 3, 4]
Sliding Window + HashMap 
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

//Pseudocode
/*
 * add all characters in p including its occuerances in a map
 * slide through each element in s and add it another map  and compare both maps
 * if matches, return the start index  
 */

/*
 * take 2 pointers where one starts with 0 and another starts with length of second string
 * take the substring of range start to end from s and replace characters from p in the substring as null
 * if the output string returns 0 size then add start index to list
 * increment both the pointers
 * finally return the list with all the indexes
 */
public class ReturnIndicies {

	@Test
	public void example1() {
		String s = "abab";
		String p = "ab";
		returnIndex(s, p);
	}

	@Test
	public void example2() {
		String s = "testetr";
		String p = "te";
		returnIndex(s, p);
	}
	
	@Test
	public void example3() {
		String s = "ab";
		String p = "ba";
		returnIndex(s, p);
	}

	private void returnIndex(String s, String p) {
		List<Integer> list = new ArrayList<>();
		int start=0,end=p.length();
		while(end<=s.length()) {
			String re = s.substring(start, end).replaceAll("["+p+"]+", "");
			if(re.length()==0)
				list.add(start);
			start++;
			end++;
		}
		System.out.println(list);
	}
	
	private void returnIndex1(String s, String p) {
		List<Integer> list = new ArrayList<>();
		Map<Character, Integer> smap = new HashMap<>();
		Map<Character, Integer> pmap = new HashMap<>();

		for (char c : p.toCharArray())
			pmap.put(c, pmap.getOrDefault(c, 0) + 1);

		int k = p.length();
		int start = 0, end = 0;

		while (end < s.length()) {
			smap.put(s.charAt(end), smap.getOrDefault(s.charAt(end), 0) + 1);

			if (end >= k) {
				if (smap.get(s.charAt(start)) > 1)
					smap.put(s.charAt(start), smap.get(s.charAt(start)) - 1);
				else
					smap.remove(s.charAt(start));
				start++;
			}

			if (smap.equals(pmap))
				list.add(start);

			end++;
		}
		System.out.println(list);
	}
}
