package algorithm2;

public class FindMinimumInRotatedSortedArray {

	static int findMinimum(int[] nums) {

		int low = 0;
		int high = nums.length - 1;

		// If array is completely sorted
		if (nums[low] <= nums[high]) {
			return nums[low];
		}
		while (low <= high) {
			int mid = low + (high - low) / 2;
			//if right of mid element is less than mid element then 
			//right element is min and return this
			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			//check the left element of mid element if it greater than mid element than mid element is min
			} else if (nums[mid] < nums[mid - 1]) {
				return nums[mid];
			//check first element and last element of first array
			} else if (nums[low] <= nums[mid]) {
				low = mid + 1;
			// check first element and last element of second array
			} else if (nums[mid] <= nums[high]) {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 4, 5, 1 };
		System.out.println(FindMinimumInRotatedSortedArray.findMinimum(nums));
	}

}
