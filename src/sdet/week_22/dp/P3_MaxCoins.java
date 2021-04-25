package sdet.week_22.dp;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
*/

public class P3_MaxCoins {

	@Test
	public void example1() {
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		Assert.assertEquals(3, coinChange(coins, amount));
	}

	@Test
	public void example2() {
		int[] coins = { 2 };
		int amount = 3;
		Assert.assertEquals(-1, coinChange(coins, amount));
	}

	@Test
	public void example3() {
		int[] coins = { 1 };
		int amount = 0;
		Assert.assertEquals(0, coinChange(coins, amount));
	}

	@Test
	public void example4() {
		int[] coins = { 1 };
		int amount = 1;
		Assert.assertEquals(1, coinChange(coins, amount));
	}

	@Test
	public void example5() {
		int[] coins = { 1 };
		int amount = 2;
		Assert.assertEquals(2, coinChange(coins, amount));
	}

	private int coinChange(int[] coins, int amount) {
		int len = coins.length;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < len; j++) {
				if (i >= coins[j]) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				}
			}
		}

		return dp[amount] > amount ? -1 : dp[amount];
	}
}
