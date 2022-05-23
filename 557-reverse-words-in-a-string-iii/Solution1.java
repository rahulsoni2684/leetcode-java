class Solution1
{
	public String reverseWords(String str) 
    {
        String words[] = str.split("\\s");
        String reversedString = "";
 
        for (int i = 0; i < words.length; i++) 
        {
            String word = words[i];
            String reverseWord = "";
            for (int j = word.length() - 1; j >= 0; j--) 
            {
                reverseWord = reverseWord + word.charAt(j);
            }
            if(i == words.length -1){
                reversedString = reversedString + reverseWord;
            } else {
            reversedString = reversedString + reverseWord + " ";
            }
        }
        return reversedString;
    }
}