package algorithm2;

public class SubarrayProductLessThanK {

	static int numSubarrayProductLessThanK(int[] nums, int k) {

		if (k <= 1) {
			return 0;
		}
		int low = 0;
		int high = 0;
		int product = 1;
		int count = 0;

		while (high < nums.length) {
			product = product * nums[high];
			while (product >= k) {
				product = product / nums[low++];
			}
			count = count + (high - low) + 1;
			high++;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 5, 2, 6 };
		System.out.println(numSubarrayProductLessThanK(nums, 100));
	}
}
