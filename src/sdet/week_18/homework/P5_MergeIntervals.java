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
		System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
	}
	
	@Test
	public void example2() {
		int[][] intervals= {{1,4},{4,5}};
		System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
	}

	private int[][] mergeIntervals(int[][] intervals) {
		/*
        List<int[]> res = new ArrayList<>();
        int n = a.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < a.length; i++) {
            start[i] = a[i][0];
            end[i] = a[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        for(int i = 0, j = 0; i < n; i++) {
            if(i == n - 1 || start[i + 1] > end[i]) {
                res.add(new int[]{start[j], end[i]});
                j = i + 1;
            }
        }
        return res.toArray(new int[res.size()][2]);
        */
        
        int count = intervals.length;
        
        for (int i = 0; i < intervals.length ; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] <= intervals[i][1] 
                    && intervals[i][0] <= intervals[j][1]) { 
                    // have overlap
                    intervals[j][0] = Math.min(intervals[j][0], intervals[i][0]);
                    intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                    intervals[i][0] = -1;
                    count--;
                    break;
                }
                
            }
        }
        
        int[][] ans = new int[count][];
        int idx = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= 0 ){
                ans[idx] = intervals[i];
                idx++;
            }   
        }
        
        return ans;
	}
}
