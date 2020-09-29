package sdet.week2.hw;
/*
9) Write a program that tells all the words containing same letters(anagram)
Input  : "Stale are there in tesla and you can steal the pears"
Output : [Stale, tesla, steal]
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class P9_Anagrams {

	@Test
	public void example1() {
		String input = "Stale are there in tesla and you can steal the pears";
		findAnagrams(input);
	}

	private void findAnagrams(String input) {
		String[] split = input.toLowerCase().split(" ");

		for (int i = 0; i < split.length; i++) {
			String[] spt = split[i].split("");
			Arrays.sort(spt);
			split[i] = String.join("", spt);
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < split.length; i++) {
			if (map.containsKey(split[i])) {
				set.add(input.split(" ")[map.get(split[i])]);
				set.add(input.split(" ")[i]);
			} else
				map.put(split[i], i);

		}

		System.out.println(set);
	}
}
