package sdet.assessment.others;

import org.junit.Assert;
import org.junit.Test;

/*
Determine the key which takes longest time to press

keyTimes=[[0,2],[1,5],[0,9],[2,15]]

Interpret each keyTimes[i][0]as an encoded character in the range ascii[a-z] where a=0,b=1,... 
The second element, keyTimes[i][1] represents the time the key is pressed since the start of the test. 
In the example keys pressed in order are 0102(encoded)=abac at times 2,5,9,15. 
From the start time, it took 2-0=2 to press first key,5-2=3 to press second key, and so on. 
The longest time it took to press a key was key 2, or 'c', at 15-9=6

Note: There will only be one key with worst time
*/

public class SlowestKeyPress {

	@Test
	public void example1() {
		int[][] keyTimes = { { 0, 2 }, { 1, 5 }, { 0, 9 }, { 2, 15 } };
		Assert.assertEquals('c', slowestKey(keyTimes));
	}

	@Test
	public void example2() {
		int[][] keyTimes = { { 0, 2 }, { 1, 3 }, { 0, 7 } };
		Assert.assertEquals('a', slowestKey(keyTimes));
	}

	@Test
	public void example3() {
		int[][] keyTimes = { { 0, 1 }, { 0, 3 }, { 4, 5 }, { 5, 6 }, { 4, 10 } };
		Assert.assertEquals('e', slowestKey(keyTimes));
	}

	private char slowestKey(int[][] keyTimes) {
		int maxPress = keyTimes[0][1];
		char key = (char) (keyTimes[0][0] + 'a');
		for (int i = 1, diff = 0; i < keyTimes.length; i++) {
			diff = keyTimes[i][1] - keyTimes[i - 1][1];
			if (diff > maxPress) {
				maxPress = diff;
				key = (char) (keyTimes[i][0] + 'a');
			}
		}

		return key;
	}
}
