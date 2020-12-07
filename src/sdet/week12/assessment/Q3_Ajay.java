package sdet.week12.assessment;

import org.junit.Test;

public class Q3_Ajay {

	@Test
	public void example1() {
		String inp = "There is no Test";
		System.out.println(reverseText(inp));
	}

	@Test
	public void example2() {
		String inp = "May the force be with you";
		System.out.println(reverseText(inp));
	}

	@Test
	public void example3() {
		String inp = "Testing";
		System.out.println(reverseText(inp));
	}

	// Pseudo code
	// Space complexity: O[N]
	// Time complexity: O[N]
	/*
	 * Split the input string with separator as space go from reverse word and
	 * reverse it using stringbuilder or 2 pointer append it to a new string return
	 * the string
	 */

	private String reverseText(String inp) {
		String[] split = inp.split(" ");
		if (split.length < 2)
			return inp;

		String op = "";
		for (int i = split.length - 1; i >= 0; i--)
			op = op.concat(new StringBuilder(split[i--]).reverse().toString()).concat(" ").concat(split[i]).concat(" ");

		return op.trim();
	}

}
