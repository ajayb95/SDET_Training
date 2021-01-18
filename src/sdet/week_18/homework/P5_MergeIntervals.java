package sdet.week_18.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*
https://leetcode.com/problems/merge-intervals/
*/

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 
Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/

public class P5_MergeIntervals {

	@Test
	public void example1() {
		int[][] intervals= {{1,3},{2,6},{8,10},{15,18}};
		mergeIntervals(intervals);
	}
	
	@Test
	public void example2() {
		int[][] intervals= {{1,4},{4,5}};
		mergeIntervals(intervals);
	}

	private void mergeIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a,b)->a[0]-b[0]);
		List<int[]> output=new ArrayList<>();
		
		for (int i = 0; i < intervals.length; i++) {
			
		}
	}
}
