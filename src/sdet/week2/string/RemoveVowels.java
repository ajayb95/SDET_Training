package sdet.week2.string;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class RemoveVowels {

	
	@Test
	public void example1() {
		String input="Testleaf";
		removeVowels(input);
		for (int i = 0; i < input.length(); i++) {
			if(input.lastIndexOf(input.charAt(i))==i)
				System.out.println(input.charAt(i));
		}
	}
	
	private void removeVowels(String input) {
		
		char[] vow= {'a','e','i','o','u'};
		Map<Character, Integer> map=new HashMap<>();
		
		for (char c:input.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		/*
		 * for (char c : vow) { if(map.containsKey(c)) map.remove(c); }
		 */
		
		for (int i = 0; i < vow.length; i++) {
	//		if(map.containsKey(vow[i]))
				//input.replace(oldChar, newChar)
		}
		
		
	}
	
	private void removeVowels1(String input) {
	StringBuilder sb=new StringBuilder(input);
	int[] vowels= {'a','e','i','o','u'};
	
	for (int i = 0; i < vowels.length; i++) {
		//sb.deleteCharAt(i)
	}
	
	}
	}
