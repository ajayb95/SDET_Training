package sdet.week3.array_string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class P2_SecondLeastRepeating {

	@Test
	public void example1() {
		String input="paypal";
		secondLeast(input);
	}
	
	private void secondLeast(String input) {
		Map<Character, Integer> map=new HashMap<>();
		
		for(char c:input.toCharArray())
			map.put(c, map.getOrDefault(c, 0)+1);
		
		List<Character> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).flatMap(mp->Stream.of(mp.getKey())).collect(Collectors.toList());
		System.out.println(collect);
		
		//least repeating
		System.out.println(collect.get(1));
		//second most repeating
		System.out.println(collect.get(collect.size()-2));
		
		
	}
}
