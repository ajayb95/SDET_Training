package sdet.week4.assesments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*
Given an array of positive integers, find the minimum length ascending
subsequence such that after removing this subsequence from the
array, the remaining array contains only unique integers. Only one
subsequence will have the minimum length (no ties). If there is no such
subsequence, return [-1].

Example
n = 7
arr = [2, 1, 3, 1, 4, 1, 3]

After removing the subsequence [1, 1, 3], the remaining array of
distinct integers is [2, 3, 4, 1]. The subsequence [1, 1, 3] is the shortest
ascending subsequence with this property, so it is returned.
*/

public class P4_SubsequenceRemoval {
	
	@Test
	public void example1() {
		int[] arr= {2, 1, 3, 1, 4, 1, 3};
		List<Integer> subseqRemoval = subseqRemoval(arr);
		System.out.println(subseqRemoval);
	}
	
	@Test
	public void example2() {
		int[] arr= {3,2,2,1,1};
		List<Integer> subseqRemoval = subseqRemoval(arr);
		System.out.println(subseqRemoval);
	}
	
	@Test
	public void example3() {
		int[] arr= {2,2};
		List<Integer> subseqRemoval = subseqRemoval(arr);
		System.out.println(subseqRemoval);
	}
	
	private List<Integer> subseqRemoval(int[] arr) {
		Set<Integer> set=new HashSet<Integer>();
        List<Integer> list=new ArrayList<Integer>();
        
        for (int i : arr) {
            if(!set.add(i))
                list.add(i);
        }
        
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)<list.get(i-1)){
                list.clear();
                list.add(-1);
                return list;
        }
        }
        return list;
		
		
	}
}
