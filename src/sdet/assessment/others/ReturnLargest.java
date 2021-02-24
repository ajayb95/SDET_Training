package sdet.assessment.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

import org.junit.Test;

public class ReturnLargest {

	@Test
	public void example1() {
		int n = 213;
		findLargest(n);
	}

	@Test
	public void example2() {
		int n = 553;
		findLargest(n);
	}

	private void findLargest(int n) {
		List<Integer> list = new ArrayList<>();

		while (n > 0) {
			list.add(n % 10);
			n /= 10;
		}
		Collections.sort(list, Collections.reverseOrder());

		int output = 0;

		for (int i = 0; i < list.size(); i++) {
			output = output * 10 + list.get(i);
		}
		System.out.println(output);
	}
}
