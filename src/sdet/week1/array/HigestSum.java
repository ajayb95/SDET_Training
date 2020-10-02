package sdet.week1.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.junit.Test;

public class HigestSum {

	@Test
	public void eg1() {
		int[] arr = { 2, 4, 1, 3, 5, 6, 0, 1, 3 };
		int number = 2;
		Entry<String, Integer> higestSum = getHigestSum(arr, number);
		System.out.println("Higest sum of " + number + " consecutive elements in the array (" + higestSum.getKey()
				+ ") is " + higestSum.getValue());
	}

	@Test
	public void eg2() {
		int[] arr = { 2, 4, 1, 3, 5, 6, 0, 1, 3, 1 };
		int number = 3;
		Entry<String, Integer> higestSum = getHigestSum(arr, number);
		System.out.println("Higest sum of " + number + " consecutive elements in the array (" + higestSum.getKey()
				+ ") is " + higestSum.getValue());
	}

	private Entry<String, Integer> getHigestSum(int[] arr, int number) {
		int len = (arr.length % number == 0) ? arr.length - (number - 1) : arr.length / number * number - (number - 2); //o[1]
		Map<String, Integer> map = new HashMap<>(); //o[1]
		for (int i = 0; i < len; i++) {
			String seq = "";	//o[N]
			int sum = 0;		//o[N]
			for (int j = i; j < i + number; j++) {
				seq += arr[j] + " ";	//o[M]
				sum += arr[j];		//o[M]
			}
			map.put(seq.trim(), sum);	//o[N]
		}

		return map.entrySet().stream().max(Map.Entry.comparingByValue()).get(); //o[1]
		
		//o[1]+o[1]+o[N]+o[N]+o[M]+o[M]+o[N]+o[1]=o[3]+o[3N]+o[2M]=o[N]+o[M]=o[N]
	}
}
