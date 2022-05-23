class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int low = 0;
        int high = nums.length-1;
        int i = nums.length-1;
        int[] result = new int[nums.length];
        
        
        while(low <= high)
        {
            if(Math.abs(nums[low]) < Math.abs(nums[high]))
            {
                result[i--] = nums[high] * nums[high];
                high--;
            }
            else {
                result[i--] = nums[low] * nums[low];
                low++;                
            }
        }
        return result;
    }    
    
    public static void main(String[] args) {
        Solution obj =  new Solution();
        int[] nums = {-4,-1,0,3,10};
        obj.sortedSquares(nums);
    }
}