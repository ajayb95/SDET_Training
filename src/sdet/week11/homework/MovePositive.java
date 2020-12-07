package sdet.week11.homework;

import java.util.Arrays;

import org.junit.Test;

/*
Write a program to move all the positive numbers to end. 

Input: [4, -1, 9, 0, 2, -4, 5]
Output: [-1, 0, -4, 4, 9, 2, 5]

Algorithm: Use 2 Pointer
*/

//Pseudo code
/*
create 2 pointer p and n and both in same position
if negative, swap elements in pth and nth position and increment both
else increment n
loop till n reaches end of the array
 */

public class MovePositive {

	@Test
	public void example1() {
		int[] arr = { 4, -1, 9, 0, 2, -4, 5 };
		movePositive(arr);
	}

	@Test
	public void example2() {
		int[] arr = { 4, 1, 9, 1, 2, 4, -5 };
		movePositive(arr);
	}

	@Test
	public void example3() {
		int[] arr = { 1, 3, 5, 7, 8, 9, 7 };
		movePositive(arr);
	}

	@Test
	public void example4() {
		int[] arr = { -1, -3, -5, 7, -8 };
		movePositive(arr);
	}
	
	private void movePositive(int[] arr) {
		int start=0,left=0;
		int end=arr.length-1,right=arr.length-1;
		int[] op=new int[arr.length];
		
		while(start<arr.length) {
			if(arr[start++]<1)
				op[left++]=arr[start-1];
			if(arr[end--]>0)
				op[right--]=arr[end+1];
		}
		System.out.println(Arrays.toString(op));
	}
	
	private void movePositive1(int[] arr) {
		int p = 0, n = 0;

		while (n < arr.length) {
			if (arr[n] <= 0) {
				int temp = arr[p];
				arr[p++] = arr[n];
				arr[n++] = temp;
			} else
				n++;
		}

		System.out.println(Arrays.toString(arr));
	}
}
