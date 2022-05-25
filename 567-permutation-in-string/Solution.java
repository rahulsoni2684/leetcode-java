class Solution {
    
    public boolean checkInclusion(String s1, String s2) {
        //check if s2 is small then return false 
        if(s1.length() > s2.length()){
            return false;
        }
        // frequency array for both words s1 and s2. 
        // Size of array is equal to total alphabets in english
        // Initial with zero values.
        int[] s1FrqArr = new int[26];
        int[] s2FrqArr = new int[26];
        
        for(int i=0; i < s1.length(); i++) 
        {
        // populate the frequency array for s1 and s1
        // if character repeats then increase count by 1 
        // and loop will iterate based on s1 length
            s1FrqArr[s1.charAt(i) - 'a']++;
            s2FrqArr[s2.charAt(i) - 'a']++;
        }
        
        int winStart = 0;
        int winEnd = s1.length();
        
        while(winEnd < s2.length())
        {
            //if anything match then return true
            if(matches(s1FrqArr, s2FrqArr)) {
                return true;
            }
            //slide window end pointer by 1 to right and increase frq count by 1
            s2FrqArr[s2.charAt(winEnd) - 'a']++;
            // slide window start pointer by 1 to right and decrease frq count by 1
            s2FrqArr[s2.charAt(winStart) - 'a']--;
            
            // move window start and end pointer to right by 1
            winStart++;
            winEnd++;
        }
        //if anything match then return true after loop ended
        if(matches(s1FrqArr, s2FrqArr)) {
                return true;
        }
        
        return false;
    }
    
    public boolean matches(int[] s1FrqArr, int[] s2FrqArr) 
    {
        for(int i = 0; i < 26; i++) 
        {
            if(s1FrqArr[i] != s2FrqArr[i])
            {
                return false;
            }
        }
        return true;
    }
}