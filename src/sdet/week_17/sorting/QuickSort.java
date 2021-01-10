package sdet.week_17.sorting;

import java.util.Arrays;

import org.junit.Test;

public class QuickSort {

	@Test
	public void example1() {
		int[] nums = { 11, 4, 17, 18, 2, 21, 1, 8 };
		quickSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}
	
	@Test
	public void example2() {
		int[] nums = { 1, 9, 2, -1, -5, 2, 3 };
		quickSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	private int findPartitioning1(int[] nums, int left, int right) {
		int pivot = nums[left];
		while (left < right) {
			while(left<right && nums[right]>=pivot) right--;
			nums[left]=nums[right];
			while(left<right && nums[left]<=pivot) left++;
			nums[right]=nums[left];
		}
		nums[left]=pivot;
		return right;
	}
	
	private void quickSort1(int[] nums, int left, int right) {
		if(left>=right)
			return;
		int mid = findPartitioning(nums, left, right);
		quickSort(nums, left, mid);
		quickSort(nums, mid + 1, right);
	}
	
	private int findPartitioning(int[] nums, int left, int right) {
		int lp=left;
		int pivot = nums[left++];
		int temp = 0;
		while (left < right) {
			if (nums[left] >= pivot && nums[right] <= pivot) {
				temp = nums[left];
				nums[left++] = nums[right];
				nums[right--] = temp;
			}
			if (nums[left] < pivot)
				left++;
			if (nums[right] > pivot)
				right--;
		}
		
		nums[lp] = nums[right];
		nums[right] = pivot;
		
		return right;
	}
	
	private void quickSort(int[] nums, int left, int right) {
		if(right-left<=1)
			return;
		int mid = findPartitioning(nums, left, right);
		quickSort(nums, left, mid);
		quickSort(nums, mid + 1, right);
	}
}
