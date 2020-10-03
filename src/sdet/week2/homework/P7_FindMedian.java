package sdet.week2.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/*
7) Given two sorted arrays A1, A2. Write a code to find median of the arrays

Example 1:

Input:

A1 = [1,3]
A2 = [2]

Output: 2

Example 2:

Input:

A1 = [1,2]
A2 = [3,4]

Output: 2.5
*/
public class P7_FindMedian {

	@Test
	public void example1() {
		int[] a1 = { 1, 3 };
		int[] a2 = { 2 };
		findMedian(a1, a2);
	}

	@Test
	public void example2() {
		int[] a1 = { 1, 2 };
		int[] a2 = { 3, 4 };
		findMedian(a1, a2);
	}

	@Test
	public void example3() {
		int[] a1 = { 1, 5, 7, 9 };
		int[] a2 = { 2, 4, 6, 8 };
		findMedian(a1, a2);
	}

	private void findMedian(int[] a1, int[] a2) {
		List<Integer> collect = Arrays.stream(a1).boxed().collect(Collectors.toList());
		collect.addAll(Arrays.stream(a2).boxed().collect(Collectors.toList()));
		Collections.sort(collect);
		int med = collect.size() / 2;

		if (collect.size() % 2 == 0)
			System.out.println((collect.get(med - 1) + collect.get(med)) / 2f);
		else
			System.out.println(collect.get((int) Math.ceil(med / 2f)));
	}
	
	private void findMedian1(int[] a1, int[] a2) {
		int sum=0;
		int size=0;
		for (int i : a1) {
			sum+=i;
			size++;
		}
		for (int i : a2) {
			sum+=i;
			size++;
		}
		
		String format = String.format("%.1f", (float)sum/size);
		System.out.println(format);
		
		
	}
}
