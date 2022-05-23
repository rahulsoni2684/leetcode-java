class Solution {
	
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid, pos= 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
                
            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target) {
                low = mid + 1;
                pos = mid + 1;
            }
            else {
                high = mid - 1;
                pos = mid;
            }
        }
        return pos;
    }
    
    
    public static void main(String args[]) {
        Solution obj = new Solution();
        int nums[] = {1,3,5,6};
        int target = 5;
        
        System.out.println(obj.searchInsert(nums, target));
    }
}