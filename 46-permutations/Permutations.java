package algorithm1;

import java.util.ArrayList;
import java.util.List;

/**
 * 46- Permutations
 */
public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(nums, 0, result);
		return result;
	}

	public void backtrack(int[] nums, int start, List<List<Integer>> result) {
		if (nums.length == start) {
			result.add(toList(nums));
		} else {
			for (int i = start; i < nums.length; i++) {
				swap(i, start, nums);
				backtrack(nums, start + 1, result);
				swap(i, start, nums);
			}
		}
	}

	public List<Integer> toList(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i : nums) {
			list.add(i);
		}
		return list;
	}

	public void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		Permutations obj = new Permutations();
		List<List<Integer>> output = obj.permute(new int[] { 1, 2, 3 });
		System.out.println(output);
	}
}
