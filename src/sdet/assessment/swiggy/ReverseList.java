package sdet.assessment.swiggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ReverseList {

	@Test
	public void example1() {
		List<Integer> list = new ArrayList<>(Arrays.asList(5, 7, 1, 3, 4, 9, 6));
		reverseList(list);
	}

	@Test
	public void example2() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		reverseList(list);
	}

	private void reverseList(List<Integer> list) {
		int left = 0, right = list.size() - 1;

		while (left < right) {
			int temp = list.get(right);
			list.set(right--, list.get(left));
			list.set(left++, temp);
		}

		System.out.println(list);
	}
}
