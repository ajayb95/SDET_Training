package sdet.week_18.weekwork;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/*https://www.geeksforgeeks.org/recamans-sequence/*/
public class RecamansSequence {
//Rule:
	/*
	 * a(0) = 0, 
	 * if n > 0 and the number is not already included in the sequence,
	 	* a(n) = a(n - 1) - n 
	 * else 
	 	* a(n) = a(n-1) + n.
	 */
	
public static void main(String[] args) {
	int n = 6;
	Set<Integer> set = new LinkedHashSet<Integer>();
	set.add(0);
	int cur = 0, prev = 0;
	for (int i = 1; i < n; i++) {
		cur = prev - i;
		if (cur < 0 || set.contains(cur))
			cur = prev + i;
		set.add(cur);
		prev = cur;
	}

	System.out.println(set);
}
}
