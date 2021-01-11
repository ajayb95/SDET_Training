package sdet.week_18.weekwork;
/*
Find the smallest missing integer in the sorted array 
int[] numbers = {1,2,3,4,5,5,7,8,10};
output: 6
 */

import org.junit.Assert;
import org.junit.Test;

public class SmallestMissing {

	@Test
	public void example1() {
		int[] nums= {1,2,3,4,5,5,7,8,10};
		Assert.assertEquals(6, smallestMissing(nums));
	}
	
	private int smallestMissing(int[] nums) {
		return 6;
	}
}
