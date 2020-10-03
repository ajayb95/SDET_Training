package sdet.week2.homework;
/*
2) Rotate an image

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
*/

import java.util.Arrays;

import org.junit.Test;

public class P2_RotateImage {

	@Test
	public void example1() {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotateImage(matrix);
	}

	@Test
	public void example2() {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		rotateImage(matrix);
	}

	@Test
	public void example3() {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		rotateImage(matrix);
	}

	private void rotateImage(int[][] matrix) {
		int[][] output = new int[matrix.length][matrix.length];
		int a = 0, b = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = matrix.length - 1; j >= 0; j--) {
				// System.out.print(matrix[j][i]);
				output[a][b++] = matrix[j][i];
			}
			a++;
			b = 0;
		}
		System.out.println(Arrays.deepToString(output));
	}

	private void rotateImage1(int[][] matrix) {

		int start = 0;
		int end = 0;
		int temp;
		while (start < matrix.length && end < matrix.length) {
			temp = matrix[start][end];
			matrix[start][end] = matrix[end][start];
			matrix[end++][start] = temp;
			if (end == matrix.length) {
				start++;
				end = start;
			}
		}
		//System.out.println(Arrays.deepToString(matrix));
		start = 0;
		end = matrix.length - 1;
		int s1 = 0;
		while (start < matrix.length) {
			temp = matrix[start][s1];
			matrix[start][s1++] = matrix[start][end];
			matrix[start][end--] = temp;

			if (s1 == end) {
				start++;
				s1 = 0;
				end = matrix.length - 1;
			}
		}
		System.out.println(Arrays.deepToString(matrix));
	}

}
