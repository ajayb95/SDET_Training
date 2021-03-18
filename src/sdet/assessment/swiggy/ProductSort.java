package sdet.assessment.swiggy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.Test;

/*
In a warehouse, a manager would like to sort the items in the stock. Given an array of n item values, 
sort the array in ascending order, first by number of items with a certain value, then by values themselves

n=6
items=[4,5,6,5,4,3]

* There are 2 values that occur twice: [4,4,5,5]
* There are 2 values that occur once: [3,6]
* The array of items sorted by quantity ad then by value in ascending order is [3,6,4,4,5,5]

*/
public class ProductSort {

	@Test
	public void example1() {
		int[] nums = { 4, 5, 6, 5, 4, 3 };
		productSort(nums);
	}

	private void productSort(int[] nums) {
		Map<Integer, Integer> map = new TreeMap<>();

		for (int each : nums)
			map.put(each, map.getOrDefault(each, 0) + 1);

		List<Entry<Integer, Integer>> collect = new ArrayList<>(map.entrySet());
		Collections.sort(collect, Map.Entry.comparingByValue());

		List<Integer> output = new ArrayList<>();

		for (Entry<Integer, Integer> ent : collect)
			for (int i = 0; i < ent.getValue(); i++)
				output.add(ent.getKey());

		System.out.println(output);
	}
}
