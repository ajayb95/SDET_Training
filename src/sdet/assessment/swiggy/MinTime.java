package sdet.assessment.swiggy;

import org.junit.Assert;
import org.junit.Test;

/*
 * Z -> A -> B -> C -> D -> E -> F -> G -> H -> I -> J -> K -> L -> M -> N -> O -> P -> Q -> R -> S -> T -> U -> V -> W -> X -> Y -> Z -> A
 * It is a circular printer wheel with the letters A through Z in sequence. It wraps so A and Z are adjacent.
 * The printer has a pointer that is initially at 'A'. Moving from any character takes 1 sec. It can move in either direction
 * Given a string of letters, What is the min time needed to print the string.
 * 
 * "BZA" -> 1+2+1=4 sec.
 * First move the pointer from A to B (1 sec), then from B to Z (2 sec) and finally from Z to A (1 sec).
 */

public class MinTime {

	@Test
	public void example1() {
		String input = "BZA";
		Assert.assertEquals(4, findMinTime(input));
	}

	@Test
	public void example2() {
		String input = "AZGB"; // 0+1+7+5=13 sec
		Assert.assertEquals(13, findMinTime(input));
	}

	private int findMinTime(String input) {
		int total = 0;
		char temp = 'A';
		for (int i = 0; i < input.length(); i++) {
			int diff = Math.abs(input.charAt(i) - temp);
			total += Math.min(diff, 26 - diff);
			temp = input.charAt(i);
		}
		return total;
	}
}

/*
if(s.length() ==0) return 0;
int sum = Math.min(s.charAt(0)-'A', Math.abs('Z'-s.charAt(0)+1));
char currentChar  = s.charAt(0);
for(int i = 1 ; i<s.length(); i++) {
	if(s.charAt(i)>currentChar) {
		sum += Math.min(Math.abs(s.charAt(i)-currentChar), Math.abs((currentChar-'A')+('Z'-s.charAt(i)+1)));
	}else {
		sum += Math.min(Math.abs(s.charAt(i)-currentChar), Math.abs((s.charAt(i)-'A')+('Z'-currentChar)+1));
	}
	currentChar = s.charAt(i);
}

return sum;
*/