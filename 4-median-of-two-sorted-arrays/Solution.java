class Solution {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int m = nums1.length;
        int n = nums2.length;
        int mergeArr[] = new int[n+m];
        int i = 0, j = 0, k = 0;
        
        //compare and add numbers in merged array in asc order from both arrays
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                mergeArr[k++] = nums1[i++];
            }
            else {
                mergeArr[k++] = nums2[j++];
            }
        }
        
        // add the remaining numbers from first array into merged array
        if(i < m) {
            while(i < m) 
                mergeArr[k++] = nums1[i++];
        }
        //add remaining numbers from second array to merged array
        if(j < n) {
            while(j < n)
                mergeArr[k++] = nums2[j++];
        }
        //get total arrays length
        int total = n + m;
        // calcutate the median based on even and odd array length
        if(total % 2 == 1) {
            return mergeArr[((total + 1)/2) - 1];
        } else {
            return ((double)mergeArr[(total/2) - 1] + (double)mergeArr[(total/2)])/2.0;
        }
    }
}