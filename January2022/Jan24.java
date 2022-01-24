/*
520. Detect Capital

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

 

Example 1:

Input: word = "USA"
Output: true
Example 2:

Input: word = "FlaG"
Output: false
 

Constraints:

1 <= word.length <= 100
word consists of lowercase and uppercase English letters.
*/
class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length(), caps = 0;
        
        for(char ch : word.toCharArray()){
            if(ch <= 'Z')
                caps++;
        }
        
        if(caps == n || caps == 0)//uppercase and lowercase
            return true;
        if(caps == 1 && word.charAt(0) <= 'Z')
            return true;
        
        return false;
    }
    
}
