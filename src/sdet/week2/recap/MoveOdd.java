package sdet.week2.recap;

import java.util.Arrays;

import org.junit.Test;

public class MoveOdd {

	@Test
	public void example1() {
		int[] input= {6,2,1,9,4,7,0};
		moveOdd(input);
	}
	
	private void moveOdd(int[] input) {
		
		int even=0,odd=0;
		
		while(even<input.length) {
			if(input[even]%2==0) {
				int temp=input[odd];
				input[odd++]=input[even];
				input[even++]=temp;
			}else {
				even++;
			}
		}
		
		System.out.println(Arrays.toString(input));
	}
}
