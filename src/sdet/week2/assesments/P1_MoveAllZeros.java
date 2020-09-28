package sdet.week2.assesments;

import java.util.Arrays;

import org.junit.Test;

/*
 Write a program to move all zeros to end
 Input: [1,0,5,9,0,0,6,8]
 Output: [1,5,9,6,8,0,0,0]
*/

public class P1_MoveAllZeros {

	@Test
	public void example1() {
		int[] input= {1,0,5,9,0,0,6,8};
		moveZeros(input);
	}
	
	@Test
	public void example2() {
		int[] input= {1,-5,-6,0,0,7,7,2,0,-1};
		moveZeros(input);
	}
	
	@Test
	public void example3() {
		int[] input= {1,2,3,6,5,4,7,8};
		moveZeros(input);
	}
	
	private void moveZeros(int[] input) {
		int[] output=new int[input.length];
		int count=0;
		for (int i = 0; i < input.length; i++) {
			if(input[i]!=0)
				output[count++]=input[i];
		}
		System.out.println(Arrays.toString(output));
	}
	
	private void moveZeros2(int[] input) {
		int count=0;
		for (int i = 0; i < input.length; i++) {
			if(input[i]!=0)
				input[count++]=input[i];
		}
		for (int i = count; i < input.length; i++) {
			input[i]=0;
		}
	}
	
	private void moveZeros3(int[] input) {

	}
}