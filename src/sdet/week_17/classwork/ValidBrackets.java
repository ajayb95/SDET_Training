package sdet.week_17.classwork;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
(()) -> true
({}) -> true
()) -> false
*/

public class ValidBrackets {

	@Test
	public void example1() {
		String input = "(())";
		Assert.assertEquals(true, isBracketsValid(input));
	}

	@Test
	public void example2() {
		String input = "({})";
		Assert.assertEquals(true, isBracketsValid(input));
	}

	@Test
	public void example3() {
		String input = "())";
		Assert.assertEquals(false, isBracketsValid(input));
	}

	@Test
	public void example4() {
		String input = "({[]})";
		Assert.assertEquals(true, isBracketsValid(input));
	}

	private boolean isBracketsValid(String input) {
		Map<Character, Character> brackets = new HashMap<Character, Character>() {
			{
				put('}', '{');
				put(')', '(');
				put(']', '[');
			}
		};

		Stack<Character> stack = new Stack<>();

		for (char c : input.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == brackets.get(c))
				stack.pop();
			else
				stack.add(c);
		}

		return stack.isEmpty();
	}

	private boolean validate(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
