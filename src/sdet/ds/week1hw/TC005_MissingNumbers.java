package sdet.ds.week1hw;

import java.util.Arrays;

import org.junit.Test;

/*
 Find all the missing numbers in the given array
 
 Input: [4,3,2,7,8,2,3,1]
 Output: [5,6]
*/

/*ques:
	1. to find the missing numbers between the min and max in the array?
	*/
public class TC005_MissingNumbers {

	@Test
	public void example1() {
		int[] input = { 4, 3, 2, 7, 8, 2, 3, 1 };
		bruteforce_1(input);
		bruteforce_2(input);
	}

	private void bruteforce_1(int[] input) {
		Arrays.sort(input);
		boolean flag;
		for (int i = input[0]; i < input[input.length - 1]; i++) {
			flag = false;
			for (int a : input) {
				if (a == i) {
					flag = true;
					break;
				}
			}
			if (!flag)
				System.out.println(i);
		}
	}

	private void bruteforce_2(int[] input) {
		Arrays.sort(input);
		for (int i = input[0]; i < input[input.length - 1]; i++)
			if (Arrays.binarySearch(input, i) < 0)
				System.out.println(i);
	}

	private void bruteforce_3(int[] input) {
		Arrays.sort(input);
		int index = 0;
		for (int i = input[0]; i < input[input.length - 1]; i++) {
			if (i != input[index])
				System.out.println(index + 1);

			index++;
		}
	}
}