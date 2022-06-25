package algorithm1;

/**
 * 136. Single Number
 */

public class SingleNumber {

	public int getSingleNumber(int[] nums) 
	{
		int result = nums[0];
		// loop through each element of array
		for (int i = 1; i < nums.length; i++) {
			// apply XOR operation on each elements with result.
			result = result ^ nums[i];
		}

		return result;
	}
	
	public static void main(String[] args) 
	{
		int[] nums = {2, 3, 5, 4, 5, 3, 4};
		SingleNumber obj = new SingleNumber();
		System.out.println(obj.getSingleNumber(nums));
	}

 
}
