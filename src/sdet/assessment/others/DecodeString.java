package sdet.assessment.others;

import org.junit.Test;

public class DecodeString {

	@Test
	public void example1() {
		String s = "a1b2c4";
		int ind = 3;
		decodeString(s, ind);
	}

	private void decodeString(String s, int ind) {
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		int num = 0, ptr = 0;

		while (ptr < s.length()) {
			if (Character.isDigit(s.charAt(ptr))) {
				while (ptr < s.length() && Character.isDigit(s.charAt(ptr))) {
					num = num * 10 + Character.getNumericValue(s.charAt(ptr++));
				}
				for (int i = 0; i < num; i++) {
					sb.append(temp);
				}
				temp = new StringBuilder("");
				num = 0;
			} else
				temp.append(s.charAt(ptr++));
		}

		System.out.println(sb.toString());
		System.out.println(sb.charAt(ind));
	}
}
