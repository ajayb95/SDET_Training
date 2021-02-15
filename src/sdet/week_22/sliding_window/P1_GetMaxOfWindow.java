package sdet.week_22.sliding_window;

import java.util.Arrays;

import org.junit.Test;

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]

Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
*/

public class P1_GetMaxOfWindow {

	@Test
	public void example1() {
		int[] nums= {1,3,-1,-3,5,3,6,7};
		int k=3;
		System.out.println(Arrays.toString(getMaxOfWindow(nums, k)));
	}
	
	@Test
	public void example2() {
		int[] nums= {2,2,2,2,2,2};
		int k=2;
		System.out.println(Arrays.toString(getMaxOfWindow(nums, k)));
	}
	
	private int[] getMaxOfWindow(int[] nums,int k) {
		int len = nums.length - k + 1;
        int n = nums.length;
        int ans[] = new int[len];
        
        int left[] = new int[n];
        int right[] = new int[n];
        
        
        
        /*
            Calculate the left array
            which has maximum values from left for each window
        */
        for(int i=0;i<n;i++){
            if(i%k == 0 || i ==0)
                left[i] = nums[i];
            else
                left[i] = Math.max(left[i-1], nums[i]);
        }
        
        /*
            Calculate the right array
            which has maximum values from the right for each window
        */
        for(int i=n-1;i>=0;i--){
            if(i%k==k-1 || i==n-1)
                right[i] = nums[i];
            else
                right[i] = Math.max(right[i+1], nums[i]);
        }

        /*
            for each window the maximum of window is
            right max of first element of window and left
            max of last element of the window.
        */
        for(int i=k-1;i<n;i++){
            int j= i-k+1;
            
            ans[j] = Math.max(left[i], right[j]);
        }
        
        
        return ans;
	}
}
