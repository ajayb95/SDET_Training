package sdet.assessment.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
Have the function ArrayChallenge take the array of strings, which will contain pairs of integers in the following format: 
(i1,i2), where i1 represents a child node in a tree and the second integer i2 signifies that it si the parent of i1. 
For example: if ["(1,2)","(2,4)","(7,2)"], then this forms the following tree,

4
|
2-7
|
1

which you can see forms a proper binary tree. Your program should in this case return the string true because a valid 
binary tree can be formed. if a proper binary tree cannot be formed with the integer pairs. then return the string false. 
All of the integers wihthin the tree will be unique, which means there can be one node in the tree with the 
given integer value.

Example 1:
Input: ["(1,2)","(2,4)","(5,7)","(7,2)","(9,5)"]
Output: true

Example 2:
Input: ["(1,2)","(3,2)","(2,12)","(5,2)"]
Output: false

Example 3:
Input: ["(2,5)","(2,6)"]
Output: false

Example 4:
Input: ["(2,3)","(1,2)","(4,9)","(9,3)","(12,9)","(6,4)","(1,9)"]
Output: false
*/

public class ArrayChallenge {

	@Test
	public void example1() {
		String[] input = { "(1,2)", "(2,4)", "(7,2)" };
		Assert.assertEquals(true, isValidBinaryTree(input));
	}

	@Test
	public void example2() {
		String[] input = { "(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)" };
		Assert.assertEquals(true, isValidBinaryTree(input));
	}

	@Test
	public void example3() {
		String[] input = { "(1,2)", "(3,2)", "(2,12)", "(5,2)" };
		Assert.assertEquals(false, isValidBinaryTree(input));
	}

	@Test
	public void example4() {
		String[] input = { "(2,5)", "(2,6)" };
		Assert.assertEquals(false, isValidBinaryTree(input));
	}

	@Test
	public void example5() {
		String[] input = { "(2,3)", "(1,2)", "(4,9)", "(9,3)", "(12,9)", "(6,4)", "(1,9)" };
		Assert.assertEquals(false, isValidBinaryTree(input));
	}

	@Test
	public void example6() {
		String[] input = { "(2,3)", "(1,2)", "(4,9)", "(9,3)", "(12,9)", "(6,4)" };
		Assert.assertEquals(true, isValidBinaryTree(input));
	}

	private boolean isValidBinaryTree(String[] input) {

		Map<String, Integer> parent = new HashMap<>();
		Set<String> child = new HashSet<>();

		for (String each : input) {
			String[] temp = each.substring(1, each.length() - 1).split(",");
			parent.put(temp[1], parent.getOrDefault(temp[1], 0) + 1);

			if (!child.add(temp[0]) || parent.get(temp[1]) > 2)
				return false;
		}
		
		return true;
	}
}
