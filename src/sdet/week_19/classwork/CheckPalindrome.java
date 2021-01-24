package sdet.week_19.classwork;

import java.util.ArrayDeque;

import org.junit.Assert;
import org.junit.Test;

//Check if the given String is palindrome or not
/*
 * Constraints:
 * String should be alphanumeric
 * ignore cases
 */

//Pseudo code
//Using string
/*
 * Create another string
 * traverse the input string from reverse and add each character to the string
 * finally check whether this string and input string matches
 * 
 * Space: O[N]
 * Time:
 * Best: O[1]
 * Worst: O[N]
 * Average: O[N]
 */

//Using string builder
/*
 * create a string builder initialized as the input string
 * reverse the string using .reverse() method
 * compare both reversed and input string
 * 
 * Space: O[N]
 * Time:
 * Best: O[1]
 * Worst: O[N]
 * Average: O[N]
 */

//Array dequeue
/*
* add all characters to the array dequeue
* pop and poll the queue and check if both the characters are equal
	* if not equal, then return as false
* if the queue is empty or in size of 1 then return as true
* 
* Space: O[N]
* Time:
* Best: O[1]
* Worst: O[N]
* Average: O[N]
*/

//Two pointer
/*
 * create 2 pointers left and right
 * traverse left from 0 and right from end of the string
 * compare the left and right characters
 	* if the character doesn't match, return false
 * if the loop completed, then the given string is a palindrome
 * 
 * Space: O[1]
 * Time: 
 * Best: O[1]
 * Worst: O[N/2]
 * Average: O[N/2]
 */

public class CheckPalindrome {

	@Test
	public void example1() {
		String input = "abcba";
		Assert.assertEquals(true, stringMethod(input));
		Assert.assertEquals(true, stringBuilderMethod(input));
		Assert.assertEquals(true, usingQueue(input));
		Assert.assertEquals(true, twoPointer(input));
	}

	@Test
	public void example2() {
		String input = "AazXXzaA";
		Assert.assertEquals(true, stringMethod(input));
		Assert.assertEquals(true, stringBuilderMethod(input));
		Assert.assertEquals(true, usingQueue(input));
		Assert.assertEquals(true, twoPointer(input));
	}

	@Test
	public void example3() {
		String input = "12321";
		Assert.assertEquals(true, stringMethod(input));
		Assert.assertEquals(true, stringBuilderMethod(input));
		Assert.assertEquals(true, usingQueue(input));
		Assert.assertEquals(true, twoPointer(input));
	}

	@Test
	public void example4() {
		String input = "Aa";
		Assert.assertEquals(true, stringMethod(input));
		Assert.assertEquals(true, stringBuilderMethod(input));
		Assert.assertEquals(true, usingQueue(input));
		Assert.assertEquals(true, twoPointer(input));
	}

	@Test
	public void example5() {
		String input = "a";
		Assert.assertEquals(true, stringMethod(input));
		Assert.assertEquals(true, stringBuilderMethod(input));
		Assert.assertEquals(true, usingQueue(input));
		Assert.assertEquals(true, twoPointer(input));
	}

	@Test
	public void example6() {
		String input = "abc";
		Assert.assertEquals(false, stringMethod(input));
		Assert.assertEquals(false, stringBuilderMethod(input));
		Assert.assertEquals(false, usingQueue(input));
		Assert.assertEquals(false, twoPointer(input));
	}

	private boolean stringMethod(String input) {
		input = input.toLowerCase();
		String reversed = "";

		for (int i = input.length() - 1; i >= 0; i--)
			reversed += input.charAt(i);

		return input.equals(reversed);
	}

	private boolean stringBuilderMethod(String input) {
		input = input.toLowerCase();
		return new StringBuilder(input).reverse().toString().equals(input);
	}

	private boolean usingQueue(String input) {
		input = input.toLowerCase();
		ArrayDeque<Character> queue = new ArrayDeque<>();
		char[] carr = input.toCharArray();

		for (char ch : carr)
			queue.offer(ch);

		while (queue.size() > 2)
			if (queue.poll() != queue.pollLast())
				return false;

		return true;
	}

	private boolean twoPointer(String input) {
		input = input.toLowerCase();
		int left = 0, right = input.length() - 1;

		while (left < right)
			if (input.charAt(left++) != input.charAt(right--))
				return false;

		return true;
	}
}
