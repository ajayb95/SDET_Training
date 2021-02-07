package sdet.week_21.classwork;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {

	@Test
	public void example1() {
		String s = "12";
		Assert.assertEquals(2, usingRecursion(s));
		Assert.assertEquals(2, usingDP(s));
		Assert.assertEquals(2, usingDPEfficient(s));
	}

	@Test
	public void example2() {
		String s = "10";
		Assert.assertEquals(1, usingRecursion(s));
		Assert.assertEquals(1, usingDP(s));
		Assert.assertEquals(1, usingDPEfficient(s));
	}

	@Test
	public void example3() {
		String s = "226";
		Assert.assertEquals(3, usingRecursion(s));
		Assert.assertEquals(3, usingDP(s));
		Assert.assertEquals(3, usingDPEfficient(s));
	}

	@Test
	public void example4() {
		String s = "0";
		Assert.assertEquals(0, usingRecursion(s));
		Assert.assertEquals(0, usingDP(s));
		Assert.assertEquals(0, usingDPEfficient(s));
	}

	@Test
	public void example5() {
		String s = "06";
		Assert.assertEquals(0, usingRecursion(s));
		Assert.assertEquals(0, usingDP(s));
		Assert.assertEquals(0, usingDPEfficient(s));
	}

	Map<Integer, Integer> map = new HashMap<>();

	private int usingRecursion(String s) {
		if (s.charAt(0) == '0')
			return 0;

		return helperFunc(s, 0);
	}

	private int helperFunc(String s, int start) {
		if (start == s.length())
			return 1;
		if (s.charAt(start) == '0')
			return 0;
		if (start == s.length() - 1)
			return 1;
		if (map.containsKey(start))
			return map.get(start);

		int ans = helperFunc(s, start + 1);
		int twodig = (s.charAt(start) - '0') * 10 + (s.charAt(start + 1) - '0');

		if (twodig <= 26)
			ans += helperFunc(s, start + 2);

		map.put(start, ans);

		return ans;
	}

	private int usingDP(String s) {
		if (s.charAt(0) == '0')
			return 0;

		int len = s.length();
		int[] dp = new int[len + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 1; i < len; i++) {
			if (s.charAt(i) != '0')
				dp[i + 1] += dp[i];

			int twoDig = Integer.parseInt(s.substring(i - 1, i + 1));
			if (twoDig >= 10 && twoDig <= 26)
				dp[i + 1] += dp[i - 1];

		}

		return dp[len];
	}

	private int usingDPEfficient(String s) {
		if (s.charAt(0) == '0')
			return 0;

		int len = s.length();

		int twoback = 1;
		int oneback = 1;

		for (int i = 1; i < len; i++) {
			int cur = 0;
			if (s.charAt(i) != '0')
				cur += oneback;

			int twoDig = Integer.parseInt(s.substring(i - 1, i + 1));
			if (twoDig >= 10 && twoDig <= 26)
				cur += twoback;

			twoback = oneback;
			oneback = cur;
		}

		return oneback;
	}
}
