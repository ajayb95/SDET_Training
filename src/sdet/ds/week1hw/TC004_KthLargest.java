package sdet.ds.week1hw;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

import javax.sound.sampled.ReverbType;

import org.junit.Test;

public class TC004_KthLargest {

	@Test
	public void example1() {
		System.out.println("Method 1");
		int[] input= {3,2,3,1,2,4,5,5,6};
		int k=4;
		bruteForce_1(input, k);
	}
	
	@Test
	public void example2() {
		System.out.println("Method 2");
		int[] input= {3,2,1,5,6,4};
		int k=2;
		bruteForce_2(input, k);
	}
	
	private void bruteForce_1(int[] input,int k) {
		Object[] array = Arrays.stream(input).boxed().sorted(Comparator.reverseOrder()).toArray();
		System.out.println(array[k-1]);
	}
	
	private void bruteForce_2(int[] input,int k) {
		Arrays.sort(input);
		System.out.println(input[input.length-k]);
	}
}
