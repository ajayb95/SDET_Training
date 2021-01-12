package sdet.week_18.weekwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
https://leetcode.com/problems/remove-palindromic-subsequences/
*/

public class RemovePalindromeSubseq {

	@Test
	public void example1() {
		String inp = "ababa";
		Assert.assertEquals(1, findMinRemoval(inp));
	}

	@Test
	public void example2() {
		String inp = "abb";
		Assert.assertEquals(2, findMinRemoval(inp));
	}

	@Test
	public void example3() {
		String inp = "baabb";
		Assert.assertEquals(2, findMinRemoval(inp));
	}

	@Test
	public void example4() {
		String inp = "";
		Assert.assertEquals(0, findMinRemoval(inp));
	}

	@Test
	public void example5() {
		String inp = "j";
		Assert.assertEquals(1, findMinRemoval(inp));
	}

	@Test
	public void example6() {
		String inp = "abbbbbbbba";
		Assert.assertEquals(1, findMinRemoval(inp));
	}

	private int findMinRemoval(String inp) {
		int len = inp.length();

		if (len < 2)
			return len;

		int left = 0, right = 0;

		for (int mid = 0; mid < 2 * len; mid++) {
			left = mid / 2;
			right = left + mid % 2;
			while (left >= 0 && right < len && inp.charAt(left--) == inp.charAt(right++))
				if(inp.substring(left+1, right).length()==len)
					return 1;
		}

		return 2;

	}
}
