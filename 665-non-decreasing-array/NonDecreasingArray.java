package daily;

public class NonDecreasingArray {

	public boolean checkPossibility(int[] nums) {
		boolean hasChanged = false;

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				if (hasChanged) {
					return false;
				}
				if (i == 0 || nums[i + 1] >= nums[i - 1]) {
					nums[i] = nums[i + 1];
				} else {
					nums[i + 1] = nums[i];
				}

				hasChanged = true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 2, 3 };
		NonDecreasingArray obj = new NonDecreasingArray();
		System.out.println(obj.checkPossibility(nums));
	}
}
