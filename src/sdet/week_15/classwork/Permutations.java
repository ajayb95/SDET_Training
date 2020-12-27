package sdet.week_15.classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Permutations {

	@Test
	public void example1() {
		int[] nums = { 1, 2, 3 };
		findPermutations(nums);
	}

	@Test
	public void example2() {
		int[] nums = { 1, 2, 3, 4 };
		findPermutations(nums);
	}
	
	@Test
	public void example3() {
		int[] nums = { 0,1 };
		findPermutations(nums);
	}

	private void findPermutations(int[] nums) {
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> opt = new ArrayList<>();

		for (int i : nums)
			list.add(i);

		int len = nums.length;
		
		for (int i = 0; i < len; i++) {
			int rmv = list.remove(i);
			list.add(0, rmv);
			for (int j = 1; j < len; j++) {
				int secEl = list.get(1);
				boolean flag=false;
				for (int k = 2; k < len; k++) {
					list.remove(k - 1);
					list.add(k, secEl);
					opt.add(new ArrayList<>(list));
					flag=true;
				}
				
				if(!flag)
					opt.add(new ArrayList<>(list));
			}
		}
		System.out.println(opt);
	}

	private void findPermutations1(int[] nums) {
		int t = nums.length;

		Set<String> set = new HashSet<>();
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < t; i++) {
				int[] left = Arrays.copyOfRange(nums, 0, i);
				int l = left.length;
				int[] right = Arrays.copyOfRange(nums, i + 1, nums.length);
				int r = right.length;
				int[] combined = new int[nums.length];
				combined[0] = nums[i];
				System.arraycopy(left, 0, combined, 1, l);
				System.arraycopy(right, 0, combined, l + 1, r);
				set.add(Arrays.toString(combined));
				for (int j = 1; j < combined.length; j++) {
					combined[j - 1] = combined[j];
					combined[j] = nums[i];
					set.add(Arrays.toString(combined));
				}
			}
			int lp = 0, rp = nums.length - 1;
			while (lp < rp) {
				int temp = nums[lp];
				nums[lp++] = nums[rp];
				nums[rp--] = temp;
			}
		}
		System.out.println(set);
	}
}
