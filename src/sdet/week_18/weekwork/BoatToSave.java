package sdet.week_18.weekwork;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.
Return the minimum number of boats to carry every given person. (It is guaranteed each person can be carried by a boat.)

Example 1:
Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)

Example 2:
Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)

Example 3:
Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
*/
public class BoatToSave {

	@Test
	public void example1() {
		int[] people = { 1, 2 };
		int limit = 3;
		Assert.assertEquals(1, findBoatCount(people, limit));
	}

	@Test
	public void example2() {
		int[] people = { 3, 2, 2, 1 };
		int limit = 3;
		Assert.assertEquals(3, findBoatCount(people, limit));
	}

	@Test
	public void example3() {
		int[] people = { 3, 5, 3, 4 };
		int limit = 5;
		Assert.assertEquals(4, findBoatCount(people, limit));
	}

	private int findBoatCount(int[] people, int limit) {
		Arrays.sort(people);
		int left = 0, right = people.length - 1;
		int boatNum = 0;
		while (left <= right) {
			if (people[left] + people[right] <= limit)
				left++;
			right--;
			boatNum++;
		}
		return boatNum;
	}
}
