package sdet.week2.homework;

import org.junit.Test;

/*5) Given a matrix, print it in Reverse Wave Form.

Input :  1  2  3  4
         5  6  7  8
         9  10 11 12
         13 14 15 16
		 
Output : 4 8 12 16 15 11 7 3 2 6 10 14 13 9 5 1
*/

public class P5_ReverseWave {

	@Test
	public void example1() {
		int[][] input = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		reverseMatrix(input);
	}
	@Test
	public void example2() {
		System.out.println("");
		int[][] input = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		reverseMatrix(input);
	}

	private void reverseMatrix(int[][] input) {
		//System.out.println(input.length);
		int i = 0;
		int j = input[0].length - 1;
		int flow = 1;
		while (j >= 0) {
			if (flow == 1)
				System.out.print(input[i++][j]+" ");
			else
				System.out.print(input[i--][j]+" ");

			if (i == input.length) {
				i--;
				j--;
				flow = flow>0?-1:1;
			} else if (i < 0) {
				i++;
				j--;
				flow = flow<0?1:-1;
			}
		}
	}
}
