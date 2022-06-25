package algorithm1;

public class HouserRobber {

	public int rob(int[] nums) {

		int prev = 0, cur = 0, ans = 0;
		for (int i = 0; i < nums.length; ++i) {
			ans = Math.max(cur, prev + nums[i]);
			prev = cur;
			cur = ans;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 9, 3, 1 };
		HouserRobber obj = new HouserRobber();
		System.out.println(obj.rob(nums));
	}
}
