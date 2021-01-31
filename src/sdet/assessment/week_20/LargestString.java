package sdet.assessment.week_20;

import org.junit.Assert;
import org.junit.Test;

public class LargestString {

	@Test
	public void example1() {
		String input = "baccc";
		int k = 2;
		Assert.assertEquals("ccbca", findLargestString(input, k));
	}

	@Test
	public void example2() {
		String input = "zzzazz";
		int k = 2;
		Assert.assertEquals("zzazz", findLargestString(input, k));
	}

	@Test
	public void example3() {
		String input = "axxzzx";
		int k = 2;
		Assert.assertEquals("zzxxax", findLargestString(input, k));
	}

	@Test
	public void example4() {
		String input = "yuzzvuyzpv";
		int k = 1;
		Assert.assertEquals("zyzyzvuvup", findLargestString(input, k));
	}

	@Test
	public void example5() {
		String input = "zxzuvozyzvzywvxyqxzxzyywyxwyzxxwzwzyzzzzyxzvzxxywx";
		int k = 4;
		Assert.assertEquals("zzzzyzzzzyzzzzyzzzzyyyyxyyyxxxxwxxxxwxxwwwwvvvvuqo", findLargestString(input, k));
	}

	private String findLargestString(String input, int k) {
		int[] occ = new int[26];
		for (char ch : input.toCharArray()) {
			occ[ch - 'a']++;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 25; i >= 0; i--) {
			if (occ[i] == 0)
				continue;

			if (occ[i] <= k) {
				while (--occ[i] >= 0) {
					sb.append((char) (i + 'a'));
				}
			} else {
				int cnt = 0;
				int ind = i - 1;
				while (occ[i] > 0) {
					if (cnt >= k && ind >= 0) {
						while (ind >= 0 && occ[ind] == 0) {
							ind--;
						}
						if (ind < 0)
							break;
						sb.append((char) (ind + 'a'));
						occ[ind]--;
						cnt = 0;
					} else {
						sb.append((char) (i + 'a'));
						occ[i]--;
						cnt++;
					}
				}
				i = ind + 1;
			}
		}
		return sb.toString();
	}
}
