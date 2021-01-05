package sdet.week_17_weekwork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class FindOneDuplicate {
	/*
	 * https://leetcode.com/problems/find-the-duplicate-number/solution/
	 */
	
	@Test
	public void example1() {
		int[] nums= {1,2,2,3,4};
		System.out.println(findDuplicateSet(nums));
		System.out.println(findDuplicateMap(nums));
	}
	
	@Test
	public void example2() {
		int[] nums= {1,6,5,4,8,6};
		System.out.println(findDuplicateSet(nums));
		System.out.println(findDuplicateMap(nums));
	}
	
	//Using set
	//Add each element to set, if the element is present, return that element
	private int findDuplicateSet(int[] nums) {
		Set<Integer> set=new HashSet<>();
		for(int each:nums)
			if(!set.add(each))
				return each;
		return -1;
	}
	
	//Using Map by finding occurrences
	private int findDuplicateMap(int[] nums) {
		Map<Integer, Integer> map=new HashMap<>();
		for(int each:nums)
			map.put(each, map.getOrDefault(each, 0)+1);
		List<Integer> collect = map.entrySet().stream().filter(mp->mp.getValue()==2).flatMap(fm->Stream.of(fm.getKey())).collect(Collectors.toList());
		return collect.get(0);
	}
	
	private void findDuplicate(int[] nums) {
		//Required: space: o[1] and time:o[n]
		
		
	}
}
