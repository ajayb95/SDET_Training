package sdet.week_19.weekwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/*
Given an array of string, group the strings that are composed by the same character, returning an array of arrays.
For example, given:
["124", "412", "425", "241", "524", "324", "2141"],
Return:
[
   ["241", "124","412"],
   ["524","425"],
   ["324"],
   ["2141"]
]
*/

public class GroupAnagrams {

	@Test
	public void example1() {
		String[] input= {"124", "412", "425", "241", "524", "324", "2141"};
		groupAnagrams(input);
	}
	
	@Test
	public void example2() {
		String[] input= {"7","4"};
		groupAnagrams(input);
	}
	
	/*
	 * convert each element to char array
	 * sort it and convert it to a string
	 * check if the string is present in the map
	 	* if present, add the current element to list of corresponding string key in the map
	 	* else, add a new entry with sorted string as key and list with current element as value
	 * after looping through each element, collect the map values as list and return the list 
	 */
	//time: O[N^3 log N]
	//Space: O[N]
	private void groupAnagrams(String[] input) {
		Map<String, List<String>> map=new HashMap<>();
		
		for (int i = 0; i < input.length; i++) {
			char[] carr = input[i].toCharArray();
			Arrays.sort(carr);
			String val = String.valueOf(carr);
			map.putIfAbsent(val, new ArrayList<>());
			map.get(val).add(input[i]);
			/*if(map.containsKey(val)) {
				List<String> list = map.get(val);
				list.add(input[i]);
				map.put(val, list);
			}else {
				List<String> temp=new ArrayList<>();
				temp.add(input[i]);
				map.put(val, temp);
			}*/
		}
		
		List<List<String>> output = map.entrySet().stream().flatMap(fm->Stream.of(fm.getValue())).collect(Collectors.toList());
		System.out.println(output);
	}
	
	private void groupAnagrams1(String[] input) {
		Map<String, List<String>> map=new HashMap<>();
		
		for (int i = 0; i < input.length; i++) {
			int[] ascii=new int[10];	
			for(char c:input[i].toCharArray())
				ascii[Character.getNumericValue(c)]++;
			String arr = Arrays.toString(ascii);
			if(map.containsKey(arr)) {
				List<String> temp = map.get(arr);
				temp.add(input[i]);
				map.put(arr, temp);
			}else {
				List<String> temp=new ArrayList<>();
				temp.add(input[i]);
				map.put(arr, temp);
			}
		}
		
		List<List<String>> output = map.entrySet().stream().flatMap(fm->Stream.of(fm.getValue())).collect(Collectors.toList());
		System.out.println(output);
	}
}
