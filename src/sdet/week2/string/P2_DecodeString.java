package sdet.week2.string;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
2) Given an encoded string, return its decoded string.

Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Input: s = "3[a2[c]]"
Output: "accaccacc"
*/

public class P2_DecodeString {

	@Test
	public void example1() {
		String input="3[a]2[bc]";
		decodeString(input);
	}
	
	@Test
	public void example2() {
		String input="3[a2[c]]";
		decodeString(input);
	}
	
	private void decodeString(String input) {
		List<Integer> num=new ArrayList<>();
		List<Character> ch=new ArrayList<Character>();
		
		for (char c:input.toCharArray()) {
			if(Character.isDigit(c))
				num.add(Character.getNumericValue(c));
			else
				ch.add(c);
		}
		
		
	}
}
