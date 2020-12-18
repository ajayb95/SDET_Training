package sdet.week3.array_string;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FindPalindrome {

	@Test
	public void example1() {
		String inp = "abccba";
		findPalindrome(inp);
	}

	private void findPalindrome(String inp) {
		List<String> list = new ArrayList<>();
		for (int mid = 0; mid < inp.length() * 2; mid++) {
			int left = mid / 2;
			int right = left + mid % 2;

			while (left >= 0 && right < inp.length() && inp.charAt(left) == inp.charAt(right)) {
				list.add(inp.substring(left, right + 1));
				left--;
				right++;
			}
		}
		System.out.println(list);
	}
}
