package sdet.assessment.week_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.Test;

import javafx.scene.layout.Priority;

public class AncestralNames {
	
	@Test
	public void example1() {
		List<String> names= Arrays.asList(new String[] {"Steven XL","Steven XVI","David IX","Mary XV","Mary XIII","Mary XX"});
		System.out.println(sortNames(names));
	}
	
	@Test
	public void example2() {
		List<String> names= Arrays.asList(new String[] {"Zack XL","Steven XVI","Rachel L","Rachel II","Zack IX"});
		System.out.println(sortNames(names));
	}
	
	@Test
	public void example3() {
		List<String> names = Arrays.asList(new String[] { "Bruce XVIII", "Bruce XXVII", "Bruce XXVI", "Bruce XLI",
				"Francois VI", "Francois XL", "Francois XX", "Francois XXIII", "Francois XXIV", "Francois XXV", "Louis XLI",
				"Louis XLIII", "Louis XV", "Louis XXIX", "Luka I", "Luka XLII", "Luka XVII", "Luka XXII", "Luka XXXVII",
				"Maru XLI", "Maru XVIII", "Maru XXXIV", "Maru XXXV", "Mary XLII", "Mary XXIV", "Mary XXVIII", "Mary XXX",
				"Mary XXXV", "Mimino XXXVIII", "Paul VI", "Paul VIII", "Paul XLIX", "Paul XVII", "Paul XX", "Petrzlen I",
				"Petrzlen XVI", "Petrzlen XX", "Petrzlen XXXIV", "Petrzlen XXXVII", "Philippe L", "Philippe VII",
				"Philippe XV", "Philippe XXXVIII", "Rasto XV", "Tomek IX", "Tomek V", "Tomek VIII" });
		System.out.println(sortNames(names));
	}
	
	private List<String> sortNames(List<String> names) {
		Map<String, List<String>> map = new TreeMap<>();

		for (String str : names) {
			String[] split = str.split(" ");

			map.putIfAbsent(split[0], new ArrayList<>());
			map.get(split[0]).add(split[1]);
		}

		List<String> output = new ArrayList<>();

		for (Map.Entry<String, List<String>> mp : map.entrySet()) {
			List<String> temp = mp.getValue();
			Collections.sort(temp,(a,b)->convertRoman(a)-convertRoman(b));

			for (String str : temp)
				output.add(mp.getKey() + " " + str);
		}

		return output;
	}
	
	private List<String> sortNames1(List<String> names) {
		Map<String, Integer> map=new TreeMap<>();
		
		for(String str:names)
			map.put(str, convertRoman(str.split(" ")[1]));
		System.out.println(map);
		//PriorityQueue<String> pq = new PriorityQueue<>(
			//	(entA, entB) -> entA.split(" ")[0].equals(entB.split(" ")[0]) ? map.get(entA) - map.get(entB)
				//		: entA.split(" ")[0].compareTo(entB.split(" ")[0]));
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
				(a, b) -> a.getKey().split(" ")[0].equals(b.getKey().split(" ")[0]) ? a.getValue() - b.getValue()
						: a.getKey().split(" ")[0].compareTo(b.getKey().split(" ")[0]));
		
		for(Map.Entry<String, Integer> mp:map.entrySet())
			pq.offer(mp);
		System.out.println(pq);
		return new ArrayList<>();
	}
	
	private int convertRoman(String str) {
		Map<Character, Integer> map=new HashMap<Character, Integer>() {{
			put('I', 1); put('V', 5); put('X', 10); put('L', 50);
		}};
		int output=0;
		for(int i=0;i<str.length();i++) {
			if(i+1<str.length() && str.charAt(i)=='I' && (str.charAt(i+1)=='V' || str.charAt(i+1)=='X')) {
				output+=map.get(str.charAt(i+1))-1;
				i++;
			} else if(i+1<str.length() && str.charAt(i)=='L' && str.charAt(i+1)=='C') {
				output+=map.get(str.charAt(i+1))-10;
				i++;
			} else
				output+=map.get(str.charAt(i));
		}
		
		return output;
	}
}
