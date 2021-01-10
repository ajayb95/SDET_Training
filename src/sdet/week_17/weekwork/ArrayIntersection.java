package sdet.week_17.weekwork;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ArrayIntersection {

	//Pseudo Code
	/*
	 Create 2 set in which one for output
	 add all the numbers from array 1 to first set
	 again add all numbers from second array
	 if number is already present in the set, add it to second set
	 finally return the set
	 */
	//Space: O[N]
	//Time: O[N]
	
	@Test
	public void example1() {
		int[] nums1= {2,3,4,4,1};
		int[] nums2= {4,1,1};
		arrayIntersection(nums1, nums2);
	}
	
	private void arrayIntersection(int[] nums1,int[] nums2) {
		Set<Integer> temp=new HashSet<>();
		Set<Integer> output=new HashSet<>();
		
		for (int each:nums1) 
			temp.add(each);
		
		for (int each:nums2)
			if(!temp.add(each))
				output.add(each);
		
		System.out.println(output);
	}
	
	//2 pointer
	//Space: O[N]
	//Time: O[N log N]
	/*
	 * create 2 pointer to traverse both array. both pointer starts at 0
	 * create a hashset to add intersection values
	 * sort both array
	 * check elements from both pointer,
	 	* if both equal, add it to set and increment both pointer
	 	* if pointer 1 value is greater than pointer 2 value increment pointer 2
	 	* else increment pointer 1 
	 */
	
	private void arrayIntersection2(int[] nums1,int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		Set<Integer> output=new HashSet<>();
		
	}
	
	//using binary search
	//retain all
}
