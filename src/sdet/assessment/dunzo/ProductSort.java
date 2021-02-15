package sdet.assessment.dunzo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.Test;

public class ProductSort {

	@Test
	public void example1() {
		int[] nums= {4,5,6,5,4,3};
		productSort(nums);
	}
	
	private void productSort(int[] nums) {
		Map<Integer, Integer> map=new TreeMap<>();
		for(int each:nums)
			map.put(each, map.getOrDefault(each, 0)+1);
		
		//List<Entry<Integer, Integer>> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
		List<Entry<Integer,Integer>> collect=new ArrayList<>(map.entrySet());
		Collections.sort(collect,Map.Entry.comparingByValue());
		List<Integer> output=new ArrayList<>();
		for (Entry<Integer, Integer> ent : collect) {
			for (int i = 0; i < ent.getValue(); i++) {
				output.add(ent.getKey());
			}
		}
		
		System.out.println(output);
	}
}
