package sdet.week11.assessment;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/*
2) Find the second least character in a given string
  Example:
  Input: "tesla-service" Output: s 
     a) If there are more than one match, return the last match "aabbccc" -> 'b'
     b) If there are no second match, return ''
*/

public class Q2_Ajay {

//Pseudo code
//Brute force:
//Space complexity: O[1]
//Time complexity: O[N^2]
	/*
	 * iterate through each element and find the count if count is greater than 1
	 * and less than previous minimum then add it to a variable if no repeating
	 * characters found in the string then return empty character else return the
	 * actual character
	 */

//Efficient method: Using Map
//Space complexity: O[N]
//Time complexity: O[N]
	/*
	 * add each element and its corresponding occurance count to a map loop through
	 * the map and find the key with value greater than 1 but less than other
	 * character count
	 */

	@Test
	public void example1() {
		String inp = "tesla-service";
		System.out.println(leastRepeating(inp));
	}

	@Test
	public void example2() {
		String inp = "paypal";
		System.out.println(leastRepeating(inp));
	}

	@Test
	public void example3() {
		String inp = "abcd";
		System.out.println(leastRepeating(inp));
	}
	
	@Test
	public void example4() {
		String inp = "aabbccc";
		System.out.println(leastRepeating(inp));
	}

	private String leastRepeating(String inp) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : inp.toCharArray())
			if (inp.indexOf(c) != inp.lastIndexOf(c))
				map.put(c, map.getOrDefault(c, 0) + 1);
		if(map.isEmpty())
			return "";
		
		Object[] array = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).flatMap(m->Stream.of(m.getKey())).toArray();
		//Object[] array2 = map.entrySet().stream().filter(m->m.getValue()==(map.get(array[0]))).toArray();
		return Character.toString((char) array[0]);
	}
}
