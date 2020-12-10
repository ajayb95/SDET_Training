package sdet.week13.weekwork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class P1_ShortArrayRank {

	@Test
	public void example1() { // rank: 2 [5,3,5]
		int[] arr = { 10, 2, 1, 4, 10, 2, 5, 13, 5 };
		System.out.println(findArrayRank(arr));
	}

	@Test
	public void example2() { // rank: 2 [2,1,2]
		int[] arr = { 2, 1, 2, 3, 5, 3, 3 };
		System.out.println(findArrayRank(arr));
	}

	@Test
	public void example3() {
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(findArrayRank(arr));
	}

	@Test
	public void example4() {
		int[] arr = { 2 };
		System.out.println(findArrayRank(arr));
	}

	@Test
	public void example5() {
		int[] arr = { 5, 1, 5, 2, 3, 2, 6, 8, 6 };
		System.out.println(findArrayRank(arr));
	}

	@Test
	public void example6() {
		int[] arr = { 10, 1, 2, 3, 2, 10, 5, 3, 6, 5 };
		System.out.println(findArrayRank(arr));
	}

	// Space complexity: O[N]
	// Time complexity: O[N]
	private int findArrayRank(int[] arr) {
		int rank = 0;

		if (arr.length < 1)
			return rank;

		Map<Integer, int[]> map = new LinkedHashMap<>(); // Storing element as key and int array having start index,
		// end index and occurrence as value

		for (int curr = 0; curr < arr.length; curr++) {
			if (map.containsKey(arr[curr])) { // Checking if the element is already present in the Map
				int[] js = map.get(arr[curr]); // get array having previous index and count
				js[1] = curr; // update end index to current index
				js[2]++; // increment the occurrence
				map.put(arr[curr], js); // update the map
			} else {
				map.put(arr[curr], new int[] { curr, curr, 1 }); // if element is not present,
				// add it map with both start and end index as current index and occurrence as 1
			}
		}

		int minLen = Integer.MAX_VALUE;
		int maxOcc = 0;
		int[] copy = null;
		for (Map.Entry<Integer, int[]> m : map.entrySet()) { // iterate through each key in the map
			int[] val = m.getValue();
			if (val[2] > 1) { // if occurrence is greater than one then it is a duplicate
				if (val[2] > maxOcc) { // if the sub array has max number of duplicates, then
					maxOcc = val[2]; // assign new max
					copy = Arrays.copyOfRange(arr, val[0], val[1] + 1); // get copy of the array
					rank = val[2]; // and its rank i.e. max occurrence
				} else if (val[2] == maxOcc && (val[1] - val[0]) + 1 <= minLen) {
					// if occurrence equals max occurrence and also less than or equal to previous
					// minimum array length, then consider this sub array
					minLen = val[1] - val[0] + 1;
					copy = Arrays.copyOfRange(arr, val[0], val[1] + 1);
					rank = val[2];
				}

			}
		}
		System.out.println(Arrays.toString(copy));
		return rank; // finally return the rank of the minimum subarray

		// map.forEach((k,v)->{System.out.println(k+" - "+Arrays.toString(v));});
	}
}
