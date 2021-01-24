package sdet.week_19.classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/*
Facebook
 Given a list of unique words, return all pairs of distinct indices that can form the palindrome
Example 1:
Input: {“bat”, “ball”, “tab”}
Output: {{0,2}. {2,0}}
 Example 2:
Input: {“hey", "lehe”, "l”, “eh"}
Output: {{0,3}. {1,2}}
 Example 3:
Input: {“aba", "”}
Output: {{0,1}. {1,0)}
Example 4:
Input: {“abc", “def”}
Output: {}
*/

//Pseudo code
//Brute force
/*
 * Create a list to store indices
 * create 2 for loop
 	* one for first word and another one for second word
 * inside the second loop, combine in a way like input[first]+input[second] and input[second]+input[first]
 * call a method to check whether the given string is palindrome or not
 * add the 2 index whose combined string is a palindrome
 * finally return the list
 * 
 *  Space: O[N]
 *  Time: O[N^2]
 */

//Backtracking
/*
 * 
 */

public class FindPalindromePairs {
	@Test
	public void example1() {
		String[] input = { "bat", "ball", "tab" };
		bruteForce(input);
	}

	@Test
	public void example2() {
		String[] input = { "hey", "lehe", "l", "eh" };
		bruteForce(input);
	}

	@Test
	public void example3() {
		String[] input = { "aba", "" };
		bruteForce(input);
	}

	@Test
	public void example4() {
		String[] input = { "abc", "def" };
		bruteForce(input);
	}

	@Test
	public void example5() {
		String[] input = { "ba", "", "ab" };
		bruteForce(input);
	}
	
	@Test
	public void example6() {
		String[] input = { "a", "", "a" };
		bruteForce(input);
	}

	private void bruteForce(String[] input) {
		List<String> output = new ArrayList<>();
		for (int first = 0; first < input.length - 1; first++) {
			for (int second = first + 1; second < input.length; second++) {
				if (isPalindrome(input[first] + input[second]))
					output.add(Arrays.toString(new int[] { first, second }));
				if (isPalindrome(input[second] + input[first]))
					output.add(Arrays.toString(new int[] { second, first }));
			}
		}

		System.out.println(output);
	}

	private boolean isPalindrome(String input) {
		int left = 0, right = input.length() - 1;

		while (left < right)
			if (input.charAt(left++) != input.charAt(right--))
				return false;

		return true;
	}
}
