package sdet.assessment.others;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/*
A salesperson must sell n items in a bag with random Ids. The salesperson can remove as many as m items from the bag.
Determine the minimum number of different Ids, the final bag can contain, after performing atmost m deletions.

Example
n=6
ids=[1,1,1,2,3,2]
m=2

Two possible actions that give minimum 2 different Ids:
	1. Remove 2 items with ID=2 and final bag will contain ids=[1,1,1,3]
	2. Remove 1 item with ID=2 and 1 item with ID=3 and final bag will contain ids=[1,1,1,2]
The minimum number of distinct ids is 2.
*/

public class SellingProducts {

	@Test
	public void example1() {
		int[] ids = { 1, 1, 1, 2, 3, 2 };
		int m = 2;
		Assert.assertEquals(2, getMinDistinctIds(ids, m));
	}

	@Test
	public void example2() {
		int[] ids = { 1, 1, 5, 5 };
		int m = 2;
		Assert.assertEquals(1, getMinDistinctIds(ids, m));
	}

	@Test
	public void example3() {
		int[] ids = { 1, 2, 3, 1, 2, 2, 1 };
		int m = 3;
		Assert.assertEquals(2, getMinDistinctIds(ids, m));
	}

	private int getMinDistinctIds(int[] ids, int m) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int each : ids)
			map.put(each, map.getOrDefault(each, 0) + 1);

		LinkedHashMap<Integer, Integer> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new));
		int count = map.size();
		for (Map.Entry<Integer, Integer> mp : collect.entrySet()) {
			if (mp.getValue() == 1) {
				count--;
				m--;
			} else if (mp.getValue() - m >= 0) {
				if (mp.getValue() - m == 0)
					count--;
				break;
			}
		}

		return count;
	}
}
