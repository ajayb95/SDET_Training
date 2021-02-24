package sdet.assessment.others;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

//2,-2,3,0,4,-7
//4

//if 100,000 -> return -1
public class FindSubArrayCount {

	@Test
	public void example1() {
		int[] arr= {2,-2,3,0,4,-7};
		Assert.assertEquals(4, findSubArrayCount(arr));
	}
	
	private int findSubArrayCount(int[] arr) {
		Map<Integer, Integer> map=new HashMap<>();
		int cnt = 0, sum = 0;

		map.put(0, 1);

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (map.containsKey(sum))
				cnt += map.get(sum);

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return cnt;
		
	}
}
