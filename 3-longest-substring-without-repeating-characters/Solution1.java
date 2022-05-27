class Solution1 {
	
    public int lengthOfLongestSubstring(String s) 
    {
        // 
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		int left = 0;
		int right = 0;
		int len = 0;
		
		while (right < n) {
			String str = String.valueOf(s.charAt(right));
            // get index of this char in string
			int index = sb.indexOf(str, left);
            //check if this char found 
			if(index > -1) {
                // increase start index to 1 by left pointer
				left = index + 1;
			}
            // append string
			sb.append(str);
            // increase end index to 1 by right pointer
			right++;
			len = Math.max(len, right - left);
		}
		return len;        
    }
}