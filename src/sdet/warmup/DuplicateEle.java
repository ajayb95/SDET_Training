package sdet.warmup;

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
		Map<Character, Integer> map = new LinkedHashMap<>();

		for (char c : ch)
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);

		Stream<Character> flatMap = map.entrySet().stream().filter(mp -> mp.getValue() > 1)
				.collect(Collectors.toList()).stream().flatMap(m -> Stream.of(m.getKey()));
		flatMap.forEach(n->System.out.println(n));

	}

}
