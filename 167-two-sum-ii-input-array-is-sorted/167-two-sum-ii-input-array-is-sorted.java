class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        if(numbers == null || numbers.length == 0) {
            return null;
        }
        
        int start = 0;
        int end = numbers.length - 1;
        
        while(start < end) {
            
            int x = numbers[start] + numbers[end];
            
            if(x < target) {
                ++start;
            }
            else if(x > target) {
                end--;
            }
            else {
                return new int[] {start + 1, end + 1};
            }
        }
        return null;
    }
}