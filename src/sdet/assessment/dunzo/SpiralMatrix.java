package sdet.assessment.dunzo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

public class SpiralMatrix {

	@Test
	public void example1() {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		spiralMatrix(matrix);
	}

	@Test
	public void example2() {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		spiralMatrix(matrix);
	}

	private void spiralMatrix(int[][] matrix) {
		List<Integer> output = new ArrayList<>();

		int rowStart = 0, rowEnd = matrix.length - 1;
		int colStart = 0, colEnd = matrix[0].length - 1;

		while (rowStart <= rowEnd && colStart <= colEnd) {
			for (int i = colStart; i <= colEnd; i++) {
				output.add(matrix[rowStart][i]);
			}

			rowStart++;

			for (int i = rowStart; i <= rowEnd; i++) {
				output.add(matrix[i][colEnd]);
			}
			colEnd--;

			if (rowStart <= rowEnd) {
				for (int i = colEnd; i >= colStart; i--) {
					output.add(matrix[rowEnd][i]);
				}
				rowEnd--;
			}

			if (colStart <= colEnd) {
				for (int i = rowEnd; i >= rowStart; i--) {
					output.add(matrix[i][colStart]);
				}
				colStart++;
			}
		}

		System.out.println(output);
	}
}
