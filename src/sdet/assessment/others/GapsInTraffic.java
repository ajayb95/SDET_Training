package sdet.assessment.others;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
Given a 2 lane road with n positions and a total number of m cars moving from left to right, 
from a start position to finish, determine the largest gap in positions of all cars, without regard to lanes.

Example:
n=10
start=[1,2,5,8]
finish=[2,2,6,10]

This above depicts a road n=10 units in length with cars m=4 cars:
1.The first car spans from position start[0]=1 to position finish[0]=2
2.The second car spans from position start[1]=2 to position finish[1]=2
3.The third car spans from position start[2]=5 to position finish[1]=6
4.The fourth car spans from position start[3]=8 to position finish[3]=10
5.There are gaps at positions 3-4 and 7. The largest gap between cars is 2.

sample input
start = [3,8]
finish = [4,9]

sample output
3

Explanation This above depicts a road n=10 units in length with cars m=2 cars:
1.The first car spans from position start[0]=3 to position finish[0]=4
2.The second car spans from position start[1]=8 to position finish[1]=9

NO cars in positions[1,2], positions [5,6,7] or position [10].The largest gap between cars is 3.

constraints:
-> 1<=n<=10^9
-> 1<=m<=10^5
-> 1<=start[i]<=finish[i]<=n, where 0<=i<m
*/

public class GapsInTraffic {

	@Test
	public void example1() {
		int n = 10;
		int[] start = { 1, 2, 5, 8 };
		int[] finish = { 2, 2, 6, 10 };
		Assert.assertEquals(2, findLargestGap(n, start, finish));
	}

	@Test
	public void example2() {
		int n = 10;
		int[] start = { 3, 8 };
		int[] finish = { 4, 9 };
		Assert.assertEquals(3, findLargestGap(n, start, finish));
	}

	private int findLargestGap(int n, int[] start, int[] finish) {
		int sSize = start.length;
		int fSize = finish.length;
		int total = sSize + fSize;
		int[] merge = new int[total];
		int p1 = 0, p2 = 0;
		int ind = 0;
		while (p1 < sSize && p2 < fSize) {
			if (start[p1] < finish[p2])
				merge[ind++] = start[p1++];
			else if (start[p1] > finish[p2])
				merge[ind++] = finish[p2++];
			else {
				merge[ind++] = start[p1++];
				merge[ind++] = finish[p2++];
			}
		}

		if (p1 < sSize)
			merge[ind++] = start[p1++];
		else if (p2 < fSize)
			merge[ind++] = finish[p2++];

		int maxGap = 0;

		maxGap = Math.max(maxGap, Math.max(merge[0] - 1, n - merge[total - 1]));

		for (int i = 0; i < total - 1; i++) {
			maxGap = Math.max(maxGap, merge[i + 1] - merge[i]);
		}

		return maxGap-1;
	}
}
