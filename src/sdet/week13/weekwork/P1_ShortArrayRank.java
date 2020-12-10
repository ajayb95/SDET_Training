package sdet.week13.weekwork;

import java.util.HashMap;
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

	// Space complexity: O[N]
	// Time complexity: O[N]
	private int findArrayRank(int[] arr) {
		int rank = 0;

		if (arr.length < 1)
			return rank;

		Map<Integer, int[]> map = new HashMap<>(); // Storing element as key and int array having start index,
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
		for (Map.Entry<Integer, int[]> m : map.entrySet()) { // iterate through each key in the map
			int[] val = m.getValue();
			if (val[2] > 1) { // if occurrence is greater than one then it is a duplicate
				if ((val[1] - val[0]) + 1 < minLen) { // check length of the subarray is less than previous length
					minLen = val[1] - val[0] + 1; // assign new length as min length
					rank = val[2]; // update the rank with element occurrence in that subarray
				}
			}
		}

		// map.forEach((k,v)->{System.out.println(k+" - "+Arrays.toString(v));});
		return rank; // finally return the rank of the minimum subarray
	}
}
