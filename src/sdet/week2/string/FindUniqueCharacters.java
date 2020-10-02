package sdet.week2.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class FindUniqueCharacters {

	
	@Test
	public void example1() {
		String input="Testleaf";
		findUnique1(input.toLowerCase());
		
	}
	
	private void findUnique(String input) {
		
		for (int i = 0; i < input.length(); i++) {
			if(input.lastIndexOf(input.charAt(i))==i && input.indexOf(input.charAt(i))==i)
				System.out.print(input.charAt(i));
		}
		
		
	}
	
private void findUnique1(String input) {
	Map<Character, Integer> map=new HashMap<>();
	
	for (char c : input.toCharArray()) 
		map.put(c, map.getOrDefault(c, 0)+1);
	
	Object[] array = map.entrySet().stream().filter(m->m.getValue()==1).flatMap(s->Stream.of(s.getKey())).collect(Collectors.toList()).toArray();
	System.out.println(Arrays.toString(array));
	}
	
}
