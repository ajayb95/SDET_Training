package sdet.week0.warmup;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateEle {

	public static void main(String[] args) {
		String input = "abccdddefghh";
		char[] ch = input.toCharArray();
		Map<String, Integer> map = new LinkedHashMap<>();

		// for (char c : ch)
		/*
		 * if (map.containsKey(c)) map.put(c, map.get(c) + 1); else map.put(c, 1);
		 */
		// map.put(c,map.getOrDefault(c, 0)+1);

		Arrays.stream(input.split("")).forEach(m -> map.put(m, map.getOrDefault(m, 0) + 1));

		// Stream<Character> flatMap = map.entrySet().stream().filter(mp ->
		// mp.getValue() > 1)
		// .collect(Collectors.toList()).stream().flatMap(m -> Stream.of(m.getKey()));
		// flatMap.forEach(n->System.out.println(n));

		List<String> collect = map.entrySet().stream().filter(mp -> mp.getValue() > 1)
				.flatMap(m -> Stream.of(m.getKey())).collect(Collectors.toList());
		System.out.println(collect);
		
		for (int i = 0; i < ch.length; i++) {
			if(i!=input.lastIndexOf(ch[i]))
				System.out.println(ch[i]);
		}
	}

}
