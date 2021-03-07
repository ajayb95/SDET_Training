package sdet.interview.freshworks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class FindCombinations {

	@Test
	public void example1() {
		String inp = "god";
		System.out.println(findCombo(inp));
	}

	private List<String> findCombo(String inp) {
		List<String> output = new ArrayList<>();
		helperFunc(inp.toCharArray(), output, 0);
		return output;
	}

	private void helperFunc(char[] arr, List<String> output, int start) {
		if (start == arr.length) {
			output.add(String.valueOf(arr));
			return;
		}

		for (int i = start; i < arr.length; i++) {
			swap(arr, start, i);
			helperFunc(arr, output, start+1);
			swap(arr, start, i);
		}
	}

	private void swap(char[] arr, int left, int right) {
		char temp = arr[right];
		arr[right] = arr[left];
		arr[left] = temp;
	}
}
