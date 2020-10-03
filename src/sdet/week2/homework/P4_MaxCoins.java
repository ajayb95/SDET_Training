package sdet.week2.homework;
/*
4) Once upon time there was a cute princess called Farida living in a castle with her father, mother and uncle. 
On the way to the castle there lived many monsters. Each one of them had some gold coins. 
Although they are monsters they will not hurt. 
Instead they will give you the gold coins, but if and only if you didn't take any coins from the monster directly 
before the current one. 
To marry princess Farida you have to pass all the monsters and collect as many coins as possible. 
Given the number of gold coins each monster has, 
calculate the maximum number of coins you can collect on your way to the castle.
*/

import org.junit.Test;

public class P4_MaxCoins {

	//@Test
	public void example1() {
		int[] arr = { 5, 5, 10, 100, 10, 5 };
		int maxCoins = maxCoins(arr);
		System.out.println(maxCoins);
	}

	//@Test
	public void example2() {
		int[] arr = { 3, 2, 7, 10 };
		int maxCoins = maxCoins(arr);
		System.out.println(maxCoins);
	}
	
	@Test
	public void example3() {
		int[] arr = { 1,2,3,4,5 };
		int maxCoins = maxCoins(arr);
		System.out.println(maxCoins);
	}

	private int maxCoins(int[] arr) {
		int incl = arr[0];
		int excl = 0;
		int excl_new;

		for (int i = 1; i < arr.length; i++) {
			/* current max excluding i */
			excl_new = (incl > excl) ? incl : excl;

			/* current max including i */
			incl = excl + arr[i];
			excl = excl_new;
		}

		/* return max of incl and excl */
		return ((incl > excl) ? incl : excl);
	}
}
