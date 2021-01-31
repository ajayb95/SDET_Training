package sdet.assessment.week_20;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

public class ConferenceSchedule {

	@Test
	public void example1() {
		int[] start = { 1, 1, 2 };
		int[] end = { 3, 2, 4 };
		Assert.assertEquals(2, findMaxPresentation(start, end));
	}

	@Test
	public void example2() {
		int[] start = { 1, 1, 2, 3 };
		int[] end = { 2, 3, 3, 4 };
		Assert.assertEquals(3, findMaxPresentation(start, end));
	}

	@Test
	public void example3() {
		int[] start = { 6, 1, 2, 3 };
		int[] end = { 8, 9, 4, 7 };
		Assert.assertEquals(2, findMaxPresentation(start, end));
	}

	private int findMaxPresentation(int[] start, int[] end) {
		int len = start.length;
		Arrays.sort(start);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < len; i++) {
			if (i > 0 && start[i] >= pq.peek())
				pq.poll();
			pq.offer(end[i]);
		}

		return pq.size();
	}

	private int findMaxPresentation1(int[] start, int[] end) {
		int maxPresentation = 1;
		Map<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < end.length; i++) {
			map.put(end[i], start[i]);
		}

		int next = map.keySet().iterator().next();

		for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
			if (mp.getValue() >= next) {
				next = mp.getKey();
				maxPresentation++;
			}
		}

		return maxPresentation;
	}
}
