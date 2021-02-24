package sdet.assessment.others;

import java.util.Stack;

import org.junit.Test;

/*
 * String with only ABCD
 	* if A is adjacent to B, remove it
 	* if C is adjacent to D, remove it
 * CBACD -> C
 * CABABD -> ""
 */
public class RemoveAdjacent {

	@Test
	public void example1() {
		String input = "CBACD";
		removeAdjacent(input);
	}

	@Test
	public void example2() {
		String input = "CABABD";
		removeAdjacent(input);
	}
	
	@Test
	public void example3() {
		String input = "ACBDACBD";
		removeAdjacent(input);
	}

	private void removeAdjacent(String input) {
		Stack<Character> stack = new Stack<>();
		char[] arr = input.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (char ch : arr) {
			if (!stack.isEmpty() && ((stack.peek() == 'A' && ch == 'B') || (stack.peek() == 'B' && ch == 'A')
					|| (stack.peek() == 'C' && ch == 'D') || (stack.peek() == 'D' && ch == 'C')))
				stack.pop();
			else
				stack.push(ch);
		}

		while (!stack.isEmpty())
			sb.append(stack.pop());
		
		System.out.println(sb.reverse().toString());
	}
}
