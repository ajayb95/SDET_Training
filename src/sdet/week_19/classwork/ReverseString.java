package sdet.week_19.classwork;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/*
Microsoft Question
Given an input of String, reverse the order of the words
Example 1: 
Input: “ the sky is blue ”
Output: “blue is sky the”
Note: Remove the trailing or leading white spaces.
Constraints:
// Mandatory approach: Solve it with recursion
// + 2 approach 
// StringBuffer
Time:
30 Minutes !!
*/

//Pseudocode
//Stack
/*
* split the string using space
* create a new stringbuilder object
* pop out elements from stack and append it to the object
* finally return the object
* 
* Space: O[N]
* Time: O[N]
*/

//Two pointer
/*
 * split the string using space
 * use 2 pointer to swap the elements in string array
 * finally join the elements in array using space and return the string
 * 
 * Space: O[N]
 * Time: O[N]
 */

//Recursion
/*
 * split the string using space
 * call a recursion function having arguments string array, left index and right index
 * repeatively call the function until left==right
 * finally join the elements in the string array and return it as single string
 * 
 * Space: O[1]
 * Time: O[N]
 */

public class ReverseString {

	@Test // +ve
	public void example1() {
		String input = "the sky is blue";
		Assert.assertEquals("blue is sky the", stackMethod(input));
		Assert.assertEquals("blue is sky the", twoPointer(input));
		Assert.assertEquals("blue is sky the", recursiveMethod(input));
	}

	@Test // edge
	public void example2() {
		String input = "One";
		Assert.assertEquals("One", stackMethod(input));
		Assert.assertEquals("One", twoPointer(input));
		Assert.assertEquals("One", recursiveMethod(input));
	}

	@Test // -ve
	public void example3() {
		String input = "";
		Assert.assertEquals("", stackMethod(input));
		Assert.assertEquals("", twoPointer(input));
		Assert.assertEquals("", recursiveMethod(input));
	}

	@Test // +ve
	public void example4() {
		String input = "this is odd count sentance";
		Assert.assertEquals("sentance count odd is this", stackMethod(input));
		Assert.assertEquals("sentance count odd is this", twoPointer(input));
		Assert.assertEquals("sentance count odd is this", recursiveMethod(input));
	}

	private String stackMethod(String input) {
		String[] split = input.trim().split("\\s+");

		if (split.length < 2)
			return input;

		Stack<String> stack = new Stack<>();
		for (String str : split)
			stack.push(str);

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop()).append(" ");

		return sb.toString().trim();
	}

	private String twoPointer(String input) {
		String[] split = input.trim().split("\\s+");

		if (split.length < 2)
			return input;

		int left = 0, right = split.length - 1;
		while (left < right) {
			String temp = split[left];
			split[left++] = split[right];
			split[right--] = temp;
		}

		StringBuilder sb = new StringBuilder();
		for (String str : split)
			sb.append(str).append(" ");

		return sb.toString().trim();
	}

	private String recursiveMethod(String input) {
		String[] split = input.trim().split("\\s+");

		if (split.length < 2)
			return input;

		StringBuilder output = new StringBuilder();

		helperFunc(split, 0, split.length - 1, output, 0);

		return output.toString().trim();
	}

	private void helperFunc(String[] split, int l, int r, StringBuilder output, int lastInd) {
		if (l >= r) {
			if (l == r)
				output.insert(lastInd, split[l] + " ");
			return;
		}

		output.insert(lastInd, split[r] + " " + split[l] + " ");
		helperFunc(split, l + 1, r - 1, output, lastInd + split[r].length() + 1);
	}
}
