package sdet.assessment.swiggy;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class FirstUniqueChar {

	@Test
	public void example1() {
		String input = "statistics";
		Assert.assertEquals(3, findOccIndex(input));
	}

	@Test
	public void example2() {
		String input = "ababa";
		Assert.assertEquals(-1, findOccIndex(input));
	}

	@Test
	public void example3() {
		String input = "abcd";
		Assert.assertEquals(1, findOccIndex(input));
	}
	
	private int findOccIndex(String input) {
		Map<Character, Integer> map=new LinkedHashMap<>();
		
		for(char c:input.toCharArray())
			map.put(c, map.getOrDefault(c, 0)+1);
		
		List<Character> collect = map.entrySet().stream().filter(m->m.getValue()==1).flatMap(m->Stream.of(m.getKey())).collect(Collectors.toList());
		
		if(collect.size()==0)
			return -1;
		
		return input.indexOf(collect.get(0))+1;
	}
	
	private int findOccIndex1(String input) {
		for (int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			if (input.indexOf(temp) == input.lastIndexOf(temp))
				return i + 1;
		}
		return -1;
	}
}
