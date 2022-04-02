/*
680. Valid Palindrome II
Easy

Given a string s, return true if the s can be palindrome after deleting at most one character from it. 

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 
Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
*/
class Solution {
    public boolean validPalindrome(String s) {
        int lo = 0, hi = s.length() - 1;
            
        while(lo < hi){
            if(s.charAt(lo) != s.charAt(hi)){
                if(isValid(s.substring(lo + 1, hi + 1)) || isValid(s.substring(lo, hi)))
                    return true;
                else
                    return false;
            }else{//same char
                lo++;
                hi--;
            }
        }
        
        return true;
    }
    
    private boolean isValid(String s){
        int lo = 0, hi = s.length() - 1;
            
        while(lo < hi){
            if(s.charAt(lo) != s.charAt(hi)){
                return false;
            }else{//same char
                lo++;
                hi--;
            }
        }
        
        return true;
    }
}
