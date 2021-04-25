package sdet.week0.warmup;

import org.junit.Assert;
import org.junit.Test;

/*
Given an m x n matrix grid where each cell is either a wall 'W', an enemy 'E' or empty '0', return the maximum enemies you can kill using one bomb. You can only place the bomb in an empty cell.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since it is too strong to be destroyed.
Input: grid = [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
Output: 3
*/

/*
 * Go to each cell
 * if the cell is blank
 	* traverse through the column front and back until it hits a wall and get total enemies
 	* traverse through the row front and back until it hits a wall and get total enemies
 * once traversed, return the total enemies
 * Compare the enemies with the previous total
 * finally return the max enemies killed
 */
//Space: O[1]
//Time: O[N^2]
public class BombEnemy {

	@Test
	public void example1() {
		char[][] grid = { { '0', 'E', '0', '0' }, { 'E', '0', 'W', 'E' }, { '0', 'E', '0', '0' } };
		Assert.assertEquals(3, maxEnemiesKill(grid));
	}

	@Test
	public void example2() {
		char[][] grid = { { 'W', 'W', 'W' }, { '0', '0', '0' }, { 'E', 'E', 'E' } };
		Assert.assertEquals(1, maxEnemiesKill(grid));
	}

	@Test
	public void example3() {
		char[][] grid = { { '0', 'W', 'E', '0' }, { '0', 'W', '0', 'W' }, { 'E', '0', 'E', '0' },
				{ 'W', 'E', '0', 'E' } };
		Assert.assertEquals(4, maxEnemiesKill(grid));
	}
	
	@Test
	public void example4() {
		char[][] grid = { { '0', 'W', 'E', '0' }, { '0', 'W', 'E', 'W' }, { 'E', 'E', '0', 'E' },
				{ 'W', 'E', 'E', 'E' } };
		Assert.assertEquals(6, maxEnemiesKill(grid));
	}
	
	@Test
	public void example5() {
		char[][] grid = { { '0', 'W', 'E', 'W' }, { 'W', 'W', 'W', 'W' }, { 'E', 'E', 'W', 'E' },
				{ 'W', 'E', 'W', 'E' } };
		Assert.assertEquals(0, maxEnemiesKill(grid));
	}

	private int maxEnemiesKill(char[][] grid) {
		
		int count = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == '0')
					count = Math.max(count, countEnemies(grid, row, col));
			}
		}

		return count;
	}

	private int countEnemies(char[][] grid, int row, int col) {
		int cnt = 0;

		int ptr = col;
		while (ptr >= 0 && grid[row][ptr] != 'W')
			if (grid[row][ptr--] == 'E')
				cnt++;

		ptr = col;
		while (ptr < grid[row].length && grid[row][ptr] != 'W')
			if (grid[row][ptr++] == 'E')
				cnt++;

		ptr = row;
		while (ptr >= 0 && grid[ptr][col] != 'W')
			if (grid[ptr--][col] == 'E')
				cnt++;

		ptr = row;
		while (ptr < grid.length && grid[ptr][col] != 'W')
			if (grid[ptr++][col] == 'E')
				cnt++;

		return cnt;
	}
}
