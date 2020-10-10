package sdet.week4.assesments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*
A subsequence is a sequence of letters in a string, in order, but with any
number of characters removed. Vowels in order are the letters in the
string aeiou. Given a string, determine the length of the longest
subsequence that contains all of the vowels, in order, and no vowels
out of order.

Examples
s = 'aeeiiouu'
All 5 vowels are present in the correct order, so the length of the
entire string, 8, is returned.

s = 'aeeiiaouu'
Again, all 5 vowels are present in the correct order, though they don't
make the entire string. The 'a' at position 5 must be removed since it is
out of order, leaving 'aeeiiouu' with length 8.
*/

public class P5_FunWithVowels {

	@Test
	public void example1() {
		String input = "aeeiiouu";
		funWithVowels(input);
	}

	@Test
	public void example2() {
		String input = "aeeiiaouu";
		funWithVowels(input);
	}

	@Test
	public void example3() {
		String input = "aeiaaioooaauuaeiu";
		funWithVowels(input);
	}

	@Test
	public void example4() {
		String input = "aeiaaiooaa";
		funWithVowels(input);
	}
	
	@Test
	public void example5() {
		String input = "ueeiiaeiaaioouu";
		funWithVowels(input);
	}

	private void funWithVowels1(String input) {
		int start = input.indexOf('a'), end = input.lastIndexOf('u');
		List<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		int ind = 0, size = end - start + 1, i = start;

		while (i <= end) {
			if (input.charAt(i) == list.get(ind)) {
				i++;
				continue;
			} else if (input.charAt(i) >= list.get(ind) && input.charAt(i) == list.get(ind + 1)) {
				ind++;
			} else {
				size--;
				i++;
			}
		}

		System.out.println(size > 0 ? size : 0);
	}
	
	private void funWithVowels(String input) {
		int start = input.indexOf('a'), end = input.lastIndexOf('u');
		int max=input.charAt(start);
		int count=1;
		for (int i = start+1; i <= end; i++) {
			if(input.charAt(i)>=max) {
				count++;
				max=Math.max(max, input.charAt(i));
			}
		}
		
		System.out.println(count>1?count:0);
		
	}
}
