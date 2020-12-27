package sdet.week_15.classwork;

import org.junit.Test;

/*
Find the maximum possible value by inserting '5'
Examples:
input: 1234 -> output: 51234
input: 7643 -> output 76543
input: 0 -> output 50
input: -661 -> output -5661
*/

public class MaxPossibleValue {

	@Test
	public void example1() {
		int inp=1234;
		System.out.println(findMaxValue(inp));
	}
	
	@Test
	public void example2() {
		int inp=7643;
		System.out.println(findMaxValue(inp));
	}
	
	@Test
	public void example3() {
		int inp=0;
		System.out.println(findMaxValue(inp));
	}
	
	@Test
	public void example4() {
		int inp=-661;
		System.out.println(findMaxValue(inp));
	}
	
	@Test
	public void example5() {
		int inp=-1;
		System.out.println(findMaxValue(inp));
	}
	
	private String findMaxValue(int inp) {
		
		int mul=1;
		if(inp<0)
			mul=-1;
		
		int cnt=1;
		int temp=Math.abs(inp);
		while(temp>0) {
			cnt*=10;
			temp/=10;
		}
		cnt/=10;
		
		
		return "";

	}
}
