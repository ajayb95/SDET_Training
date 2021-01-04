package sdet.assessment.week_16;

import org.junit.Test;

/*
Given a string, construct a new string by rearranging the original string and deleting characters as needed. 
Return the alphabetically largest string that can be constructed respecting a limit as to how many consecutive characters can be the same.
Example
s = 'baccc'
k = 2
The largest string, alphabetically, is 'cccba' but it is not allowed because it uses the character 'c' more than 2 times consecutively. Therefore, the answer is 'ccbca'.

Function Description
Complete the function getLargestString in the editor below.
getLargestString has the following parameters:
string s[n]: the original string
int k: the maximum number of identical consecutive characters the new string can have

Returns:
string: the alphabetically largest string that can be constructed that
has no more than k identical consecutive characters

Constraints
The string s contains only lowercase English letters.

Input Format For Custom Testing
The first line contains a string, s.
The second line contains an integer, k.

Sample Case 0
Sample Input
STDIN Function
----- -----
zzzazz → string s = 'zzzazz'
2 → k = 2
Sample Output
zzazz
Explanation
One 'z' must be removed so that no more than 2 consecutive
characters are the same.

Sample Case 1
Sample Input
STDIN Function
----- -----
axxzzx → s = 'axxzzx'
2 → k = 2
Sample Output
zzxxax
Explanation
The character 'a' must separate the 3 'x' characters so that no more
than 2 consecutive characters are the same.
*/

public class TheLargestString {

	@Test
	public void example1() {
		String s = "baccc";
		int k = 2;
		rearrangeString(s, k);
	}

	@Test
	public void example2() {
		String s = "zzzazz";
		int k = 2;
		rearrangeString(s, k);
	}

	@Test
	public void example3() {
		String s = "axxzzx";
		int k = 2;
		rearrangeString(s, k);
	}

	private void rearrangeString(String s, int k) {
		int[] sCnt = new int[26];
		char[] sArr = s.toCharArray();

		for (char each : sArr)
			sCnt[each - 'a']++;
		String output = "";
		for (int i = 25; i >= 0; i--) {
			int cnt=sCnt[i];
			int t=i;
			for (int j = 0; j < cnt; j++) {
				if(j>0 && j%k==0) {
					while(sCnt[--i]>0) {
						sCnt[i]--;
						j--;
						break;
					}
				}
				output+=(char)(i+'a');
				i=t;
				
			}
		}
		System.out.println(output);
	}
}
