class Solution2 {
   
    public String swap(String str, int i, int j)
    {
        StringBuilder sb =  new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        
        return sb.toString();
    }
    
    public String reverseWords(String str) 
    {
        //pointer to the first character of the first word        
        int start = 0;
        //loop entire string length
        for(int i = 0; i < str.length(); i++)
        {
            //if current word ended or string has reached to end
            if(str.charAt(i) == ' ' || i == str.length() - 1)
            {
                int end;
                if(i == str.length() - 1) {
                    end = i;
                } else {
                    end = i - 1;
                }
                // reverse the one word
                while(start < end) {
                    str = swap(str, start, end);
                    start++;
                    end--;
                }
                //pointer to first character of next word
                start = i + 1;
            }
        }
        return str;
    }
}