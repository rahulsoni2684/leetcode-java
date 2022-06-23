package daily;

public class RunningSumOf1dArray {

	public int[] runningSum(int[] nums) {
		int[] result = new int[nums.length];
		result[0] = nums[0];
		int j = 0;

		for (int i = 1; i < nums.length; i++) {
			result[i] = result[j] + nums[i];
			j++;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		RunningSumOf1dArray obj = new RunningSumOf1dArray();
		int[] res = obj.runningSum(nums);

		for (int n : res) {
			System.out.println(n);
		}
	}
}
