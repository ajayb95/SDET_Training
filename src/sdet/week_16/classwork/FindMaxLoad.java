package sdet.week_16.classwork;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/*
mobileTypes=[type of mobile,number of mobile]
Input: mobileTypes = [[1,3],[2,2],[3,1]], truckSize = 4 mobileSizes
Output: 8

1*3=3 (4-1=3)
2*2=4 (3-2=1)
1*1=1 (1-1=0)
Output: 3+4+1=8

int[][] mobileTypes, int truckSize
int -> maxNumberOfMobiles
*/

public class FindMaxLoad {

	@Test
	public void example1() {
		int[][] mobileTypes = { { 1, 3 }, { 2, 2 }, { 3, 1 } };
		int truckSize = 4;
		System.out.println(CalculateMaxMobileNum(mobileTypes, truckSize));
	}

	@Test
	public void example2() {
		int[][] mobileTypes = { { 1, 3 }, { 2, 2 }, { 3, 1 }, { 4, 5 } };
		int truckSize = 4;
		System.out.println(CalculateMaxMobileNum(mobileTypes, truckSize));
	}
	
	@Test
	public void example3() {
		int[][] mobileTypes = { { 5, 10 }, { 2, 5 }, { 4, 7 }, { 3, 9 } };
		int truckSize = 10;
		System.out.println(CalculateMaxMobileNum(mobileTypes, truckSize));
	}

	private int CalculateMaxMobileNum(int[][] mobileTypes, int truckSize) {
		//Arrays.sort(mobileTypes, (a1,a2)->a2[1]-a1[1]);
		Arrays.sort(mobileTypes, new Comparator<int[]>() {
			public int compare(int[] a1,int[] a2) {
				return a2[1]-a1[1];
			}
		});
		System.out.println(Arrays.deepToString(mobileTypes));
		int max=0;
		
		for (int[] every : mobileTypes) {
			int mobCount=Math.min(truckSize, every[0]);
			max+=mobCount*every[1];
			truckSize-=mobCount;
			
			if(truckSize==0)
				break;
		}
		
		return max;
	}
	
	// Pseudo Code
	/*
	 * Create a map and add type of mobile as key and its size as occurrence sort
	 * the map by its value iterate through the map check if the remaining truck
	 * size is less than or equal to current key if so, then add product of type of
	 * mobile and its size to max size else, add the product of remaining truck size
	 * and current value to max size finally return the max size
	 */
	// Space: O[N]
	// Time: O[N log N]
	private int CalculateMaxMobileNum1(int[][] mobileTypes, int truckSize) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < mobileTypes.length; i++)
			map.put(mobileTypes[i][0], mobileTypes[i][1]);

		LinkedHashMap<Integer, Integer> collect = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		int max = 0;
		for (Map.Entry<Integer, Integer> mp : collect.entrySet()) {
			if (truckSize >= mp.getKey()) {
				max += mp.getKey() * mp.getValue();
				truckSize -= mp.getKey();
			} else {
				max += truckSize * mp.getValue();
				break;
			}
		}
		return max;
	}
}
