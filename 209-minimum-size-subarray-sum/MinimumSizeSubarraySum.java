package algorithm2;

public class MinimumSizeSubarraySum {

	static int minSubArrayLen(int target, int[] nums) {
		int low = 0;
		int high = 0;
		int min = Integer.MAX_VALUE;
		int sum = 0;

		while (high < nums.length) {
			sum += nums[high];
			while (target <= sum) {
				min = Math.min(min, high - low + 1);
				sum -= nums[low];
				low++;
			}
			high++;
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
	}
}
