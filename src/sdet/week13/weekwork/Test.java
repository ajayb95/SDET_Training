package sdet.week13.weekwork;

import java.util.ArrayList;
import java.util.List;

public class Test {

	@org.junit.Test
	public void example1() {
		String s = "aabaacccc";
		int k = 2;
		findLen(s, k);
	}

	private void findLen(String s, int k) {
		int start = 0;
		int maxLen = -1;
		List<Character> list = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			if (list.contains(s.charAt(i))) {
				list.remove((Character) s.charAt(i));
				start = i - 1;
			}

			list.add(s.charAt(i));

			if (list.size() > k) {
				list.remove(0);
				// start=i;
			} else
				maxLen = Math.max(maxLen, i - start);
		}

		System.out.println(maxLen);
	}
}
