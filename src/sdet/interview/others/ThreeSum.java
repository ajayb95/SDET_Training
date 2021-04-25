package sdet.interview.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ThreeSum {

	@Test
	public void example1() {
		int[] nums = { 1, 7, 3, 9, 2, 1, 2 };
		int target = 12;
		System.out.println(find3Sum(nums, target));
	}

	@Test
	public void example2() {
		int[] nums = { -5, -6, -1, 2, 1, -2, -3 };
		int target = -5;
		System.out.println(find3Sum(nums, target));
	}

	@Test
	public void example3() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		int target = 0;
		System.out.println(find3Sum(nums, target));
	}

	@Test
	public void example4() {
		int[] nums = { 1, 2 };
		int target = 0;
		System.out.println(find3Sum(nums, target));
	}

	private List<List<Integer>> find3Sum(int[] nums, int target) {
		int len = nums.length;
		List<List<Integer>> output = new ArrayList<>();

		if (len < 3)
			return output;

		Arrays.sort(nums);

		List<Integer> temp;
		for (int cur = 0, left = 0, right = 0; cur < len; cur++) {
			if (cur > 0 && nums[cur] == nums[cur - 1])
				continue;

			left = cur + 1;
			right = len - 1;

			while (left < right) {
				if (nums[left] + nums[right] + nums[cur] == target) {
					temp = new ArrayList<>();
					temp.add(nums[cur]);
					temp.add(nums[left++]);
					temp.add(nums[right--]);
					output.add(new ArrayList<>(temp));

					while (left < right && nums[left] == nums[left - 1])
						left++;
					while (right > left && nums[right] == nums[right + 1])
						right--;
				} else if (nums[left] + nums[right] + nums[cur] < target)
					left++;
				else
					right--;
			}
		}
		return output;
	}
}
