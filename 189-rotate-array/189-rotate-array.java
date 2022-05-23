/**
Here, my approch to fix this

1. Reverse the enitre array
2. Reverse the first k number of items
3. Reverse remaining n-k items in array
*/

class Solution {
    public int[] rotate(int[] nums, int k) {
        int n=nums.length;
        if(k > n) 
            k=k%n;
        nums=reverse(nums, 0, n-1);
        nums=reverse(nums, 0, k-1);
        nums=reverse(nums, k, n-1);
        return nums;        
    }
    
    public int[] reverse(int[] nums, int start, int end) {
       while (start <= end ) {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
        return nums; 
    }
    
    public static void main(String[] args)
    {
        Solution obj= new Solution();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        obj.rotate(nums, k);
    }
}