package sdet.week_18.homework;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

//253	Meeting Rooms II
/*
Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei), 
find the minimum number of conference rooms required.

Example 1:
Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Explanation:
We need two meeting rooms
room1: (0,30)
room2: (5,10),(15,20)

Example 2:
Input: [[7,10],[2,4]]
Output:1

Example 3:
Input: intervals = [(2,7)]
Output: 1
Explanation: 
Only need one meeting room
*/

public class P9_MeetingRooms {

	@Test
	public void example1() {
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		Assert.assertEquals(2, findRequiredRooms(intervals));
	}

	@Test
	public void example2() {
		int[][] intervals = { { 7, 10 }, { 2, 4 } };
		Assert.assertEquals(1, findRequiredRooms(intervals));
	}

	@Test
	public void example3() {
		int[][] intervals = { { 2, 7 } };
		Assert.assertEquals(1, findRequiredRooms(intervals));
	}

	@Test
	public void example4() {
		int[][] intervals = { { 1, 3 }, { 9, 18 }, { 3, 7 }, { 6, 12 }, { 4, 9 } };
		Assert.assertEquals(3, findRequiredRooms(intervals));
	}

	private int findRequiredRooms(int[][] intervals) {
		int len = intervals.length;
		int[] start = new int[len];
		int[] end = new int[len];

		for (int i = 0; i < len; i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}

		Arrays.sort(start);
		Arrays.sort(end);

		int sp = 0, ep = 0, res = 0;

		while (sp < len) {
			if (start[sp] < end[ep])
				sp++;
			else if (start[sp] > end[ep])
				ep++;
			else {
				sp++;
				ep++;
			}

			res = Math.max(sp - ep, res);
		}

		return res;

	}

	private int findRequiredRooms1(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < intervals.length; i++) {
			if (i > 0 && intervals[i][0] >= pq.peek())
				pq.poll();
			pq.add(intervals[i][1]);
		}

		return pq.size();
	}
}
