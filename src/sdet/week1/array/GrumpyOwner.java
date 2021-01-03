package sdet.week1.array;

import org.junit.Test;

/*
Today, the bookstore owner has a store open for customers.length minutes.  
Every minute, some number of customers (customers[i]) enter the store, 
and all those customers leave after the end of that minute.
On some minutes, the bookstore owner is grumpy.  
If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  
When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight,
but can only use it once.
Return the maximum number of customers that can be satisfied throughout the day.

Example 1:
Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.

Note:
1 <= X <= customers.length == grumpy.length <= 20000
0 <= customers[i] <= 1000
0 <= grumpy[i] <= 1
*/

public class GrumpyOwner {

	@Test
	public void example1() {
		int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
		int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
		int X = 3;
		System.out.println(maxSatisfied(customers, grumpy, X));
	}

	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int sum = 0;
		for (int i = 0; i < customers.length; i++)
			if (grumpy[i] == 0)
				sum += customers[i];

		int j = 0, max = sum;

		while (j < customers.length) {
			if (grumpy[j] == 1)
				sum += customers[j];

			if (j >= X && grumpy[j - X] == 1)
				sum -= customers[j - X];
			max = Math.max(sum, max);
			j++;
		}

		return max;
	}
}
