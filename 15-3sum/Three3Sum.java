package algorithm2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three3Sum {

	static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 3) {
			return result;
		}

		Arrays.sort(nums);
		int len = nums.length - 1;

		for (int i = 0; i < len; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int low = i + 1;
				int high = len;

				while (low < high) {
					int sum = nums[i] + nums[low] + nums[high];
					if (sum == 0) {
						result.add(Arrays.asList(nums[i], nums[low], nums[high]));
						low++;
						while (low < high && nums[low] == nums[low - 1])
							low++;

						while (low < high && nums[high] == nums[high - 1])
							high--;
					} else if (sum < 0) {
						low++;
					} else {
						high--;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// -1, 0, 1, 2, -1, -4
		// -2, 0, 0, 2, 2
		// List<List<Integer>> result = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
		List<List<Integer>> result = threeSum(new int[] { -2, 0, 0, 2, 2 });
		result.forEach(values -> {
			System.out.println(values);
		});
	}

}
