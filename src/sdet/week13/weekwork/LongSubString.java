package sdet.week13.weekwork;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LongSubString {

	@Test
	public void example1() {
		String s = "ecebaaaaee"; // 6
		int k = 2;
		findLen(s, k);
	}

	@Test
	public void example2() {
		String s = "AAa"; // 2
		int k = 1;
		findLen(s, k);
	}

	@Test
	public void example3() {
		String s = "abcd"; // 4
		int k = 5;
		findLen(s, k);
	}

	@Test
	public void example4() {
		String s = "aabaacccc"; // 6
		int k = 2;
		findLen(s, k);
	}

	@Test
	public void example5() {
		String s = "Muraleedaaran"; // 5
		int k = 3;
		findLen(s, k);
	}

	@Test
	public void example6() {
		String s = "bacaaab"; // 5
		int k = 2;
		findLen(s, k);
	}

	private void findLen(String s, int k) {
		int[] ascii = new int[256];
		int max = 0;
		int right = 0, left = 0, count = 0;

		for (; right < s.length(); right++) {
			if (ascii[s.charAt(right)] == 0)
				count++;
			ascii[s.charAt(right)]++;
 
			if (count > k) {
				ascii[s.charAt(left)]--;

				if (ascii[s.charAt(left++)] == 0)
					count--;
			}else
				max = Math.max(max, right - left + 1);
		}
		System.out.println(max);
	}

	private void findLen1(String s, int k) {
		int start = 0;
		int maxLen = -1;
		List<Character> list = new ArrayList<>();

		for (int end = 0; end < s.length(); end++) {
			if (list.contains(s.charAt(end)))
				list.remove((Character) s.charAt(end));

			list.add(s.charAt(end));

			if (list.size() > k) {
				char remChar = list.remove(0);
				int tempInd = start;
				while (tempInd < end)
					if (s.charAt(tempInd++) == remChar)
						start = tempInd;
			}

			maxLen = Math.max(maxLen, end - start + 1);
		}

		if (maxLen == -1)
			throw new RuntimeException("No long substring available");

		System.out.println(maxLen);
	}
}
