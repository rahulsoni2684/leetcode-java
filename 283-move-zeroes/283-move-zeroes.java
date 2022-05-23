class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            // check if number is zero then do nothing else swap it
            if(nums[i] != 0) {
                //swap items
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                
                j++;
            }
        }
        
    }
}