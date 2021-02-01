package sdet.week_21.weekwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class SubArrayMaxMin {

	@Test
	public void example1() {
		int[] arr= {1,2,3,4,5};
		int k=2;
		Assert.assertEquals(4, findMaxInSubarray(arr, k));
	}
	
	@Test
	public void example2() {
		int[] arr= {3,6,1,4,2,1,8,5,9,7};
		//[3,6,1],[6,1,4],[1,4,2],[4,2,1],[2,1,8],[1,8,5],[8,5,9],[5,9,7]
		//[1,1,1,1,1,1,5,5]
		//5
		int k=3;
		Assert.assertEquals(5, findMaxInSubarray(arr, k));
	}
	
	private int findMaxInSubarray(int[] arr,int k) {
		List<Integer> minEl=new ArrayList<>();
		int start=0,end=0;
		int min=Integer.MAX_VALUE;
		Map<Integer, Integer> map=new HashMap<>();
		while(end<arr.length) {
			map.put(arr[end], map.getOrDefault(arr[end], 0)+1);
			
			if(end>=k) {
				map.put(arr[start], map.get(arr[start])-1);
				
				if(map.get(arr[start])==0)
					map.remove(arr[start]);
				start++;
			}
			min=Collections.min(map.keySet());
			minEl.add(min);
			end++;
		}
		//int[] array = minEl.stream().mapToInt(i->i).toArray();
		return Collections.max(minEl);
	}
}
