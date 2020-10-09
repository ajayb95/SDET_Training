package sdet.week1_2.recap;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FindSubarray {

	@Test
	public void example1() {
		int[] input = { 1, 7, 4, 3, 4, 1, 2, 5, 1 };
		int k = 7;
		System.out.println("Sliding window");
		findSubarray(input, k);
		System.out.println("Hashmap");
		hashMap(input, k);
	}
	
	@Test
	public void example2() {
		int[] input = { 1,2,2,1,2 };
		int k = 3;
		System.out.println("Sliding window");
		//findSubarray(input, k);
		System.out.println("Hashmap");
		hashMap(input, k);
	}

	private void findSubarray(int[] input, int k) {
		int start = 0, end = 1, sum = input[0];

		while (end < input.length) {
			if (sum < k) {
				sum += input[end++];
			} else if (sum == k) {
				System.out.println(start + "," + (end - 1));
				sum += (input[end++] - input[start++]);
			} else {
				sum -= input[start++];
			}
		}
	}
	
	private void hashMap(int[] input, int k) {
		Map<Integer, Integer> map=new HashMap<>();
		map.put(0,-1);
		int sum=0;
		for (int i = 0; i < input.length; i++) {
			sum+=input[i];
			map.put(sum, i);
			
			if(map.containsKey(sum-k))
				System.out.println(map.get(sum-k)+1+","+i);
		}
		
	}
}