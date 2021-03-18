package sdet.interview.freshworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given of lists with K lists, find intersection between them
 */

public class ArrayIntersection {

	List<Integer> temp = new ArrayList<>();

	@Test
	public void example1() {
		List<List<Integer>> input = new ArrayList<>();
		input.add(Arrays.asList(8, 5, 6, 9, 3, 2));
		input.add(Arrays.asList(5, 8, 2, 1, 4));
		input.add(Arrays.asList(6, 9, 3, 5, 8));
		input.add(Arrays.asList(6, 2, 7, 8, 9, 1));
		Assert.assertEquals(Arrays.asList(8), findIntersection(input));
	}

	@Test
	public void example2() {
		List<List<Integer>> input = new ArrayList<>();
		input.add(Arrays.asList(1, 2, 3, 4));
		input.add(Arrays.asList(5, 8, 9, 10));
		input.add(Arrays.asList(6, 7));
		Assert.assertEquals(Arrays.asList(), findIntersection(input));
	}

	@Test
	public void example3() {
		List<List<Integer>> input = new ArrayList<>();
		input.add(Arrays.asList(-5, -4, 1, 6, 2));
		input.add(Arrays.asList(1, 2, 5, -5, 4));
		input.add(Arrays.asList(-4, -5, 10, 1, 2));
		Assert.assertEquals(Arrays.asList(-5, 1, 2), findIntersection(input));
	}

	@Test
	public void example4() {
		List<List<Integer>> input = new ArrayList<>();
		input.add(Arrays.asList(1, 2, 3, 4));
		input.add(Arrays.asList(3, 4, 2, 1));
		input.add(Arrays.asList(1, 4, 3, 2));
		Assert.assertEquals(Arrays.asList(1, 2, 3, 4), findIntersection(input));
	}

	@Test
	public void example5() {
		List<List<Integer>> input = new ArrayList<>();
		input.add(Arrays.asList(10, 2, 9, 2, 1));
		input.add(Arrays.asList(2, 2, 5, 6, 7));
		input.add(Arrays.asList(2, 5, 8, 2));
		Assert.assertEquals(Arrays.asList(2, 2), findIntersection(input));
	}

	private List<Integer> findIntersection(List<List<Integer>> input) {
		temp.addAll(input.get(0));
		for (int i = 1; i < input.size(); i++) {
			compareLists(input.get(i));
		}

		return temp;
	}

	private void compareLists(List<Integer> list) {
		Iterator<Integer> itr = temp.iterator();

		while (itr.hasNext()) {
			Integer temp = itr.next();
			if (!list.contains(temp)) {
				itr.remove();
				list.remove(temp);
			}
		}
	}
}
