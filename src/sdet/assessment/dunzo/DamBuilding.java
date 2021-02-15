package sdet.assessment.dunzo;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

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

	private int numberOfWalls(int[] pos, int[] height) {
		int ind = pos[pos.length - 1];
		int[] output = new int[ind];

		for (int i = 0; i < pos.length; i++) {
			output[pos[i] - 1] = height[i];
		}

		for (int i = 0; i < pos.length - 1; i++) {
			if (pos[i] + 1 == pos[i + 1]) {
				int cur=pos[i];
				output[cur] = Math.min(output[cur - 1], output[cur + 1]) + 1;
			}else {
				int left=pos[i];
				int right=pos[i+1];
				
				if(output[left-1]<output[right-1]) {
					while(left<right) {
						output[left]=output[left-1]+1;
						left++;
					}
				}
			}
		}
		System.out.println(Arrays.toString(output));
		return 1;
	}

	private int numberOfWalls1(int[] pos, int[] height) {
		int ind = pos[pos.length - 1];
		int[] output = new int[ind];

		for (int i = 0; i < pos.length; i++) {
			output[pos[i] - 1] = height[i];
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i < output.length - 1; i++) {
			if (output[i] == 0) {
				if (output[i + 1] == 0)
					output[i] = output[i - 1] + 1;
				else
					output[i] = Math.min(output[i - 1], output[i + 1]) + 1;
				max = Math.max(max, output[i]);
			}
		}
		System.out.println(Arrays.toString(output));
		return max;

	}
}
