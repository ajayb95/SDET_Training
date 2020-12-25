package sdet.assessment.week4;

import org.junit.Test;

public class FunWithVowels {

	@Test
	public void example1() {
		String str = "eouiuaaeiaoauaoaeauieeoiuiuiu";
		int vowelsFun = vowelsFun(str);
		System.out.println(vowelsFun);
	}

	private int vowelsFun(String str) {
		   char[] vowel = "aeiou".toCharArray();
	       int dp[] = new int[str.length()];
	       int max = 0;
	       for (int i = 0; i < 5; i++) {
	           char ch1 = vowel[i];
	           char ch2 = '!';
	           if (i > 0) {
	               ch2 = vowel[i - 1];
	           }
	           for (int j = 0; j < str.length(); j++) {
	               if (str.charAt(j) == ch1) {
	                   dp[j] = findMaxValue(str, ch1, ch2, j - 1, dp);
	                   if (dp[j] > max) {
	                       max = dp[j];
	                   }
	               }
	           }
	       }
	       return max;
	}

	private static int findMaxValue(String str, char ch1, char ch2, int j, int dp[]) {
		int num1 = 0;
		int num2 = 0;
		Boolean flag1 = true;
		Boolean flag2 = true;
		while (j >= 0) {
			if (!flag1 && !flag2) {
				break;
			}
			if (str.charAt(j) == ch1 && flag1) {
				num1 = dp[j] + 1;
				j--;
				flag1 = false;
			}
			if (ch2 != '!' && str.charAt(j) == ch2 && flag2) {
				num2 = dp[j] + 1;
				j--;
				flag2 = false;
			}
			if (j == 0 && num1 == 0 && num2 == 0) {
				num1 = 1;
			}
			j--;
		}
		return Math.max(num1, num2) > 0 ? Math.max(num1, num2) : 1;
	}
}
