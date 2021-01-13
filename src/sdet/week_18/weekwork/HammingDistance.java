package sdet.week_18.weekwork;

import org.junit.Assert;
import org.junit.Test;

/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2
Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
*/

public class HammingDistance {

	@Test
	public void example1() {
		int[] nums = { 4, 14, 2 };
		Assert.assertEquals(6, findTotalHammingDistance(nums));
	}

	/*
	 * 1.count no. of 1's , subtract no. of 1's from total length of the array, which gives total no. of integers with 0 at that position,i.e., count of 0's at that specific position. 
	 * 2.multiply count of 0's and count of 1's at specific postion, to get hamming distance of that particular position. 
	 * 3.now repeat the above 2 steps and sum all of the hamming distances, to obtain total hamming distance
	 */
	
	/*
	 * Vertically take a look at the bits at a given position across all the numbers.
	 * Every bit is either one or zero, let`s say we have x set bits and y unset bits, the total pairs that can generate a distance of 1 at this position is x*y.
	 * Apply the above calculation to all bits and sum up the total distance.
	 */
	private int findTotalHammingDistance(int[] nums) {
		if (nums == null)
			return 0;
		int distance = 0;
		for (int i = 0; i < 32; i++) {
			int one_count = 0;
			for (int j = 0; j < nums.length; j++) {
				one_count += (nums[j] >> i) & 1;
			}
			distance += one_count * (nums.length - one_count);
		}
		return distance;
	}
}
