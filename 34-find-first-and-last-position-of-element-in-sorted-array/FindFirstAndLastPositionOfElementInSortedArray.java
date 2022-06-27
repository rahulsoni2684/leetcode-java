package algorithm2;

public class FindFirstAndLastPositionOfElementInSortedArray {

	static int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };

		if (nums.length == 0) {
			return result;
		}
		if (nums.length == 1 && nums[0] == target) {
			return new int[] { 0, 0 };
		}

		result[0] = searchRangeIndex(nums, target, true);
		if (result[0] != -1) {
			result[1] = searchRangeIndex(nums, target, false);
		}

		return result;
	}

	static int searchRangeIndex(int[] nums, int target, boolean first) {

		int start = 0;
		int end = nums.length - 1;
		int index = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] < target) {
				start = mid + 1;

			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				index = mid;
				if (first) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
		int[] res = FindFirstAndLastPositionOfElementInSortedArray.searchRange(nums, 7);
		System.out.println("First position of target is: " + res[0]);
		System.out.println("Last position of target is: " + res[1]);
	}
}
