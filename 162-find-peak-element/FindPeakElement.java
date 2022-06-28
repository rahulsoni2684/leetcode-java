package algorithm2;

public class FindPeakElement {

	static int findPeakElement(int[] nums) {
		// if there is only one element
		if (nums.length == 1) {
			return 0;
		}
		// if there are two elements in array
		if (nums.length == 2) {
			if (nums[0] > nums[1]) {
				return 0;
			} else {
				return 1;
			}
		}

		// if array has more than 2 elements
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;
			// case-1
			if (mid > 0 && mid < high) {
				if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
					return mid;
				} else if (nums[mid + 1] > nums[mid]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			// case-2
			else if (mid == 0) {
				if (nums[0] > nums[1]) {
					return 0;
				} else {
					return 1;
				}
			}
			// case-3
			else if (mid == high) {
				return high;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 3, 5, 6, 4 };
		System.out.println(FindPeakElement.findPeakElement(nums));
	}
}
