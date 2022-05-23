/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n)
    {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int last = n;
        int minIdx = Integer.MAX_VALUE;
        
        while (first <= last) {
            int mid = first + (last - first) / 2;
            
            if (isBadVersion(mid)) {
                minIdx = Math.min(minIdx, mid);
                last = mid - 1;
            }
            else {
                first = mid + 1;
            }
        }
        return minIdx;
    }   
}