package sdet.week12.classwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/*
Given an integer array nums, return all possible subsets .
The solution set must not contain duplicate subsets.
 
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:
Input: nums = [0]
Output: [[],[0]]
*/

//Pseudo code
/*
call recursive function with arguments, input array,result list,combo list and start index
in the recursive function, 
if start ind is gt and eq len, 
sort combo list and check whether it is available in output list
if no,then add combo to result list and return
iterate through each element in the input array,
keep adding to combo list
call recursion function (move start index to next)
remove last element from list
*/

public class AllPossibleCombo {

	int i = 0;

	@Test
	public void example1() {
		int[] nums = { 1, 2, 3 };
		System.out.println(possibleCombo(nums));
	}

	private List<List<Integer>> possibleCombo(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		for (; i <= nums.length; i++) {
			findCombo(nums, result, new ArrayList<>(), 0);
		}
		return result;
	}

	private void findCombo(int[] nums, List<List<Integer>> result, List<Integer> combo, int start) {
		if (combo.size() == i) {
			List<Integer> temp = new ArrayList<>(combo);
			if (!result.contains(temp))
				result.add(temp);
			return;
		}

		for (int j = start; j < nums.length; j++) {
			combo.add(nums[j]);
			findCombo(nums, result, combo, j + 1);
			combo.remove(combo.size() - 1);
		}
	}
}
