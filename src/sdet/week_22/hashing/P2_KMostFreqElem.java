package sdet.week_22.hashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
*/

public class P2_KMostFreqElem {

	@Test
	public void example1() {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		System.out.println(Arrays.toString(kMostFreq(nums, k)));
	}
	
	@Test
	public void example2() {
		int[] nums = { 1 };
		int k = 1;
		System.out.println(Arrays.toString(kMostFreq(nums, k)));
	}

	private int[] kMostFreq(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        
        /*
        List<Integer> out=map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k).flatMap(fm->Stream.of(fm.getKey())).collect(Collectors.toList());
        int[] op=new int[k];
        
        for(int i=0;i<k;i++)
            op[i]=out.get(i);
        
        return op;
        */

		int[] out = new int[k];

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> map.get(b) - map.get(a));
		pq.addAll(map.keySet());

		int ind = 0;
		while (--k >= 0)
			out[ind++] = pq.poll();

		return out;
		
		//return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k).mapToInt(m->m.getKey()).toArray();
	}
}
