package sdet.assessment.swiggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.junit.Test;

public class FindMinDebts {

	@Test
	public void example1() {
		// Borrower-Lender-Amount
		String[] debts = { "Alex Blake 2", "Blake Alex 2", "Casey Alex 5", "Blake Casey 7", "Alex Blake 4",
				"Alex Casey 4" };
		List<List<String>> input = new ArrayList<>();

		for (String str : debts)
			input.add(Arrays.stream(str.split("\\s+")).collect(Collectors.toList()));

		findMinDebt(input);
	}

	private void findMinDebt(List<List<String>> input) {
		Map<String, Integer> debtCalc = new TreeMap<>();

		for (List<String> list : input) {
			debtCalc.put(list.get(0), debtCalc.getOrDefault(list.get(0), 0) - Integer.parseInt(list.get(2)));
			debtCalc.put(list.get(1), debtCalc.getOrDefault(list.get(1), 0) + Integer.parseInt(list.get(2)));
		}

		int minVal = Collections.min(debtCalc.values());
		
		if(minVal>=0)
			System.out.println("Nobody has a negative balance");
		
		List<String> output = new ArrayList<>();

		for (Map.Entry<String, Integer> mp : debtCalc.entrySet())
			if (mp.getValue() == minVal)
				output.add(mp.getKey());
		
		
		System.out.println(output);
	}
}
