package algorithm2;

public class SearchInRotatedSortedArray {

	static int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (target == nums[mid]) {
				return mid;
			}
			// check which array is sorted either low -> mid or mid -> high
			// check if low -> mid is sorted then search target in first array and discard
			// second array
			if (nums[low] <= nums[mid]) {
				// low to mid is sorted
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			// check if mid -> high is sorted then search target only in second array and
			// discard first array
			if (nums[mid] <= nums[high]) {
				if (target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(SearchInRotatedSortedArray.search(nums, 0));
	}

}
