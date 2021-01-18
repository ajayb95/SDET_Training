package sdet.week_18.homework;

import org.junit.Assert;
import org.junit.Test;

/*
https://leetcode.com/problems/number-of-islands/
*/

/*
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/

public class P4_IslandCount {
	@Test
	public void example1() {
		int[][] grid = new int[4][5];
		grid[0][0] = 1;
		grid[0][1] = 1;
		grid[0][2] = 1;
		grid[0][3] = 1;
		grid[0][4] = 0;
		grid[1][0] = 1;
		grid[1][1] = 1;
		grid[1][2] = 0;
		grid[1][3] = 1;
		grid[1][4] = 0;
		grid[2][0] = 1;
		grid[2][1] = 1;
		grid[2][2] = 0;
		grid[2][3] = 0;
		grid[2][4] = 0;
		grid[3][0] = 0;
		grid[3][1] = 0;
		grid[3][2] = 0;
		grid[3][3] = 0;
		grid[3][4] = 0;

		Assert.assertEquals(1, findIslandCount(grid));
	}

	@Test
	public void example2() {
		int[][] grid = new int[4][5];
		grid[0][0] = 1;
		grid[0][1] = 1;
		grid[0][2] = 0;
		grid[0][3] = 0;
		grid[0][4] = 0;
		grid[1][0] = 1;
		grid[1][1] = 1;
		grid[1][2] = 0;
		grid[1][3] = 0;
		grid[1][4] = 0;
		grid[2][0] = 0;
		grid[2][1] = 0;
		grid[2][2] = 1;
		grid[2][3] = 0;
		grid[2][4] = 0;
		grid[3][0] = 0;
		grid[3][1] = 0;
		grid[3][2] = 0;
		grid[3][3] = 1;
		grid[3][4] = 1;

		Assert.assertEquals(3, findIslandCount(grid));
	}
	
	//Pseudo code
	/*
	 * iterate through each element in the grid
	 * if the current element in the grid is 1 then,
	 	* call the helper function for recursion
	 	* from current node move through left, right, up and bottom
	 	* set the visited area as 0
	 	* stop the recursion when indices goes outside the grid or the current visited value of the grid is 0
	 * increase the counter
	 * finally return the counter
	 */
	//Space complexity: O[1]
	private int findIslandCount(int[][] grid) {
		int numberOfIslands = 0;
		for (int horizontal = 0; horizontal < grid.length; horizontal++) {
			for (int vertical = 0; vertical < grid[horizontal].length; vertical++) {
				if (grid[horizontal][vertical] == 1) {
					numberOfIslands++;
					helperFunc(grid, horizontal, vertical);
				}
			}
		}
		return numberOfIslands;
	}

	private void helperFunc(int[][] grid, int horizontal, int vertical) {
		if (horizontal < 0 || horizontal >= grid.length || vertical < 0 || vertical >= grid[horizontal].length
				|| grid[horizontal][vertical] == 0)
			return;
		grid[horizontal][vertical] = 0;
		helperFunc(grid, horizontal + 1, vertical);
		helperFunc(grid, horizontal - 1, vertical);
		helperFunc(grid, horizontal, vertical + 1);
		helperFunc(grid, horizontal, vertical - 1);
	}
}
