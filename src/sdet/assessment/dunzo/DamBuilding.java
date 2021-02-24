package sdet.assessment.dunzo;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * Your company is designing a dam to be built across a stream to create a small lake. To reduce materials cost,
 * it will be made of one or more concrete walls with mud packed in between them. Determine the maximum height of the mud segments
 * in the dam with  the following restrictions:
 * 
 * One unit width of the gap between walls will contain one segment of packed mud
 * The height of mud in segment cannot exceed 1 unit more than an adjacent  wall or mud segment.
 * 
 *  Given the placement of  a number  of walls and their heights, determine  the maximum height of mud segment that can be
 *  built. If no mud segment can be built, return 0.
 *  
 *  e.g.1:
 *  wall position=[1,2,4,7]
 *  height=[4,6,8,11]
 *  op=10
 *  
 *  [1,2,3,4,5,6,7]
 *  [4,6,7,8,9,10,11]
 *  
 *  between 2 and 4, max height of mud can be 6+1=7
 *  between 4 and 7, wall height is 8 and 11
 		* Max mud height at 5 is 8+1=9
 		* Max mud height at 6 is 9+1=10
 * Max mud segments are 7,9,10 and max of it is 10
 * 
 * e.g.2:
 * wall position=[1,3,7]
 * height=[4,3,3]
 * op=5
 * 
 * [1,2,3,4,5,6,7]
 * [4,4,3,4,5,4,3]
 * between 1 and 3, max height of mud can be 3+1=4
 * between 3 and 7, 4 at position 4 and 6 & 5 at position 5
 * 
 * e.g.3:
 * wall position=[1,10]
 * height=[1,5]
 * op=7
 * 
 * [1,2,3,4,5,6,7,8,9,10]
 * [1,2,3,4,5,6,7,7,6,5]
 */

public class DamBuilding {

	@Test
	public void example1() {
		int[] pos = { 1, 2, 4, 7 };
		int[] height = { 4, 6, 8, 11 };
		Assert.assertEquals(10, numberOfWalls(pos, height));
	}

	@Test
	public void example2() {
		int[] pos = { 1, 3, 7 };
		int[] height = { 4, 3, 3 };
		Assert.assertEquals(5, numberOfWalls(pos, height));
	}

	@Test
	public void example3() {
		int[] pos = { 1, 10 };
		int[] height = { 1, 5 };
		Assert.assertEquals(7, numberOfWalls(pos, height));
	}

	@Test
	public void example4() {
		int[] pos = { 1, 2, 3, 4, 5 };
		int[] height = { 1, 2, 3, 4, 5 };
		Assert.assertEquals(0, numberOfWalls(pos, height));
	}

	@Test
	public void example5() {
		int[] pos = { 1 };
		int[] height = { 2 };
		Assert.assertEquals(0, numberOfWalls(pos, height));
	}

	private int numberOfWalls(int[] pos, int[] height) {
		int len = pos.length - 1;
		int[] dam = new int[pos[len]];
		int maxHeight = 0;

		for (int i = 0, ptr = 0; i < len; i++) {
			ptr = pos[i];

			dam[ptr - 1] = height[i];
			while (ptr < pos[i + 1] - 1) {
				dam[ptr] = dam[ptr - 1] + 1;
				ptr++;
			}

			dam[ptr--] = height[i + 1];
			while (ptr >= pos[i]) {
				dam[ptr] = Math.min(dam[ptr], dam[ptr + 1] + 1);
				maxHeight = Math.max(maxHeight, dam[ptr]);
				ptr--;
			}
		}

		// System.out.println(Arrays.toString(dam));
		return maxHeight;
	}
}
