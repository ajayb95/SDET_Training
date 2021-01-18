package sdet.week_18.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/*
https://leetcode.com/problems/k-closest-points-to-origin/
*/

/*
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the Euclidean distance.)
You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

Example 1:
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 
Note:
1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000
*/

public class P10_ClosestPoint {

	@Test
	public void example1() {
		int[][] points= {{1,3},{-2,2}};
		int k=1;
		findKClosestPoints(points,k);
	}

	@Test
	public void example2() {
		int[][] points= {{3,3},{5,-1},{-2,4}};
		int k=2;
		findKClosestPoints(points,k);
	}
	
	private void findKClosestPoints(int[][] points, int k) {
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->
		(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
		
		for (int i = 0; i < points.length; i++) {
			pq.add(points[i]);
			if(pq.size()>k)
				pq.poll();
		}
		
		int[][] array = pq.stream().toArray(int[][]::new);
		
		System.out.println(Arrays.deepToString(array));
	}
	
	private void findKClosestPoints2(int[][] points, int k) {
		Arrays.sort(points, (a,b)->
		(a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]));
		
		System.out.println(Arrays.deepToString(Arrays.copyOfRange(points, 0, k)));
	}
	
	private void findKClosestPoints1(int[][] points, int k) {
		Map<int[], Integer> map=new HashMap<>();
		for (int i = 0; i < points.length; i++) 
			map.put(points[i], (points[i][0]*points[i][0])+(points[i][1]*points[i][1]));
		
		//int[][] output = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(k).flatMap(fm->Stream.of(fm.getKey())).toArray(int[][]::new);
		
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>((entryA,entryB)->map.get(entryA)-map.get(entryB));
		pq.addAll(map.keySet());
		//System.out.println(Arrays.deepToString(pq.stream().limit(k).toArray(int[][]::new)));
		int[][] output=new int[k][2];
		int ind=0;
		while(--k>=0)
			output[ind++]=pq.poll();
		
		System.out.println(Arrays.deepToString(output));
	}
}
