package sdet.assessment.others;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
Digital graphics tools often make available a "bucket fill" tool that will only paint adjacent cells. In one fill,
a modified bucket tool recolors adjacent cells (connected horizontally, vertically but not diagonally) that have the same
color. Given a picture represented as a 2-dimensional array of letters representing colors, find the minimum number of fills
to completely repaint the picture.

Example:
picture=["aabba","aabba","aaacb"]
a	a	b	b	a
a	a	b	b	a
a	a	a	c	b

output=5
Each string represents a row of the picture and each letter represents a cell color. 5 fills need to repaint the picture.
it takes 2 fills each for a and b and one for c.

picture=["aaaba","ababa","aaaca"]
output=5
it takes 2 fills each for a and b and one for c.

*similar to island problem
*/
public class BucketFill {

	@Test
	public void example1() {
		List<String> list=new ArrayList<>();
		list.add("aabba");
		list.add("aabba");
		list.add("aaacb");
		
		char[][] picture=new char[list.size()][];
		for(int i=0;i<list.size();i++)
			picture[i]=list.get(i).toCharArray();
		
		//char[][] picture = { "aabba".toCharArray(), "aabba".toCharArray(), "aaacb".toCharArray() };
		System.out.println(findIslandCount(picture));
	}
	
	@Test
	public void example2() {
		char[][] picture = { "aaaba".toCharArray(), "ababa".toCharArray(), "aaaca".toCharArray() };
		System.out.println(findIslandCount(picture));
	}
	
	@Test
	public void example3() {
		char[][] picture = { "bbba".toCharArray(), "abba".toCharArray(), "acaa".toCharArray(),"aaac".toCharArray() };
		System.out.println(findIslandCount(picture));
	}

	private int findIslandCount(char[][] grid) {
		int minFill = 0;

		for (int horizontal = 0; horizontal < grid.length; horizontal++) {
			for (int vertical = 0; vertical < grid[horizontal].length; vertical++) {
				if (grid[horizontal][vertical] != 'z')
					minFill += islandRecursion(grid, horizontal, vertical, grid[horizontal][vertical]);
			}
		}

		return minFill;
	}

	private int islandRecursion(char[][] grid, int horizontal, int vertical, char ch) {
		if (horizontal < 0 || horizontal >= grid.length || vertical < 0 || vertical >= grid[horizontal].length
				|| grid[horizontal][vertical] != ch)
			return 0;

		grid[horizontal][vertical] = 'z';

		islandRecursion(grid, horizontal - 1, vertical, ch);
		islandRecursion(grid, horizontal + 1, vertical, ch);
		islandRecursion(grid, horizontal, vertical - 1, ch);
		islandRecursion(grid, horizontal, vertical + 1, ch);

		return 1;
	}
}
