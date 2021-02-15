package sdet.assessment.dunzo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import org.junit.Test;

public class MeanderingOrder {

	@Test
	public void example1() {
		int[] nums= {5,2,7,8,-2,25,25};
		orderArray(nums);
	}
	
	private void orderArray(int[] nums) {
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		int[] output=new int[nums.length];
		for(int i:nums)
			pq.offer(i);
		int ind=0;
		
		while(!pq.isEmpty()) {
			if(pq.size()==1)
				output[ind++]=pq.poll();
			else {
			//	output[ind++]=pq.p
			}
		}
		
	}
	
	private void orderArray1(int[] nums) {
		int[] output=new int[nums.length];
		Arrays.sort(nums);
		int left=0,right=nums.length-1;
		int ind=0;
		while(left<=right) {
			if(left==right)
				output[ind++]=nums[left++];
			else
			{
				output[ind++]=nums[right--];
				output[ind++]=nums[left++];
			}
		}
		
		System.out.println(Arrays.toString(output));
	}
}
