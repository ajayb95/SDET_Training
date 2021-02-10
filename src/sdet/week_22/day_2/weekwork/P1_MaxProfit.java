package sdet.week_22.day_2.weekwork;

import org.junit.Assert;
import org.junit.Test;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Constraint: Solve using Single Pass with constant space
*/

public class P1_MaxProfit {

	@Test
	public void example1() {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		Assert.assertEquals(5, maxProfit(prices));
	}

	@Test
	public void example2() {
		int[] prices = { 7, 6, 5, 4, 3, 2, 1 };
		Assert.assertEquals(0, maxProfit(prices));
	}

	@Test
	public void example3() {
		int[] prices = { 1, 2, 3, 4, 5 };
		Assert.assertEquals(4, maxProfit(prices));
	}

	private int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min)
				min = prices[i];
			else if (prices[i] > min)
				maxProfit = Math.max(maxProfit, prices[i] - min);
		}
		return maxProfit;
	}
}
