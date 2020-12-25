package sdet.week_11.classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
/*
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Input: pattern = "abc", s = "hello world world"
Output: false
Algorithm: HashMap 
*/

/*
 * add unique pattern chars to list
 * iterate through each element in string s
 * if it is in map then add to map assign the value as first char in list then remove it from list
 * if list is empty, don't add it to map
 * each time when key is added to map, create a format
 * if generated format equal to given format return true else false
 */

/*
 * iterate through each element in both string parallely
 * if the map contains the word but doesn't contains the pattern character return false
 * if map doesn't contains the word but contains the pattern character return false
 * else add both word and pattern character to map
 * finally return true (as it matches pattern)
 */
public class FindPattern {

	@Test
	public void example1() {
		String pattern = "abba";
		String s = "dog cat cat dog";
		System.out.println(findPattern(pattern, s));
	}

	@Test
	public void example2() {
		String pattern = "abba";
		String s = "dog cat cat fish";
		System.out.println(findPattern(pattern, s));
	}

	@Test
	public void example3() {
		String pattern = "abc";
		String s = "hello world world";
		System.out.println(findPattern(pattern, s));
	}

	@Test
	public void example4() {
		String pattern = "abc";
		String s = "hello world World";
		System.out.println(findPattern(pattern, s));
	}

	@Test
	public void example5() {
		String pattern = "abc";
		String s = "a b c";
		System.out.println(findPattern(pattern, s));
	}

	private boolean findPattern(String pattern, String s) {
		Map<String, Character> map = new HashMap<>();

		String[] split = s.split(" ");

		if (split.length != pattern.length())
			return false;

		int ind = 0;

		while (ind < split.length) {
			if (map.containsKey(split[ind]) && map.get(split[ind]) != pattern.charAt(ind))
				return false;
			else if (!map.containsKey(split[ind]) && map.containsValue(pattern.charAt(ind)))
				return false;
			else
				map.put(split[ind], pattern.charAt(ind));
			ind++;
		}

		return true;
	}

	private boolean findPattern1(String pattern, String s) {
		List<Character> list = new ArrayList<>();
		for (char c : pattern.toCharArray())
			if (!list.contains(c))
				list.add(c);

		Map<String, Character> map = new HashMap<>();
		String op = "";
		for (String sp : s.split(" ")) {
			if (map.containsKey(sp))
				op += map.get(sp);
			else if (!map.containsKey(sp) && list.size() > 0) {
				map.put(sp, list.get(0));
				op += map.get(sp);
				list.remove(0);
			}
		}

		return op.equals(pattern);
	}
}
