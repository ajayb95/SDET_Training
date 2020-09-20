package sdet.warmup;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr= {50,3,10,7,40,80};
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		String seq = "";
		int cnt, high;
		Map<String, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < arr.length - 1; i++) {
			seq = String.valueOf(arr[i]) + " ";
			high = arr[i];
			cnt = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > high) {
					high = arr[j];
					seq += String.valueOf(high) + " ";
					cnt++;
				}
			}
			map.put(seq, cnt);
		}

		Entry<String, Integer> entry = map.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println("Length of LIS: " + entry.getValue());
		System.out.println("The longest increasing subsequence is " + entry.getKey().trim().replace(" ", ", "));
	}
}
