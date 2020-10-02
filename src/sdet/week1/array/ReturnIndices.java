package sdet.week1.array;

import java.util.Arrays;

import org.junit.Test;

public class ReturnIndices {

	@Test
	public void example1() {
		int[] number = {2,3,1,4,7,8};
		int target=5;
		int[] sumIndices = sumIndices(number, target);
		System.out.println(Arrays.toString(sumIndices));
	}
	
	@Test
	public void example2() {
		int[] number = {1,3,7,8,-4,-1};
		int target=5;
		int[] sumIndices = sumIndices(number, target);
		System.out.println(Arrays.toString(sumIndices));
	}
	
	@Test
	public void example3() {
		int[] number = {3,1,4,7,8,2,3,8};
		int target=5;
		int[] sumIndices = sumIndices(number, target);
		System.out.println(Arrays.toString(sumIndices));
	}
	
	@Test
	public void example4() {
		int[] number = {2,6,2,4,0,7,8,5};
		int target=5;
		int[] sumIndices = sumIndices(number, target);
		System.out.println(Arrays.toString(sumIndices));
	}
	
	public int[] sumIndices(int[] number, int target) {
		for (int i = 0; i < number.length; i++) {
			for (int j = i+1; j < number.length; j++) {
				if((number[i]+number[j])==target) {
					System.out.println("Indices are "+i+" & "+j);
					return new int[] {i,j};
				}
			}
		}
		
		throw new RuntimeException("There are no matching target");
	}
}
