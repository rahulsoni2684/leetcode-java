class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = (low + high)/2;
            
            if(target == nums[mid]) {
                return mid;
            }
            
            if(target > nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;                
            }
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        Solution obj = new Solution();
        int nums[] = {-1,0,3,5,9,12};
        int target = 9;
        
        int targetIndex  = obj.search(nums, target);
        if(targetIndex == -1) {
            System.out.println(target + " does not exist in numbs so return -1");
        }
        else {
            System.out.println(target + "exists in nums and its index is " + targetIndex);    
        }
    }
}