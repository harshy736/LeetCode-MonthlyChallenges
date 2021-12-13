/*
1446. Consecutive Characters


The power of the string is the maximum length of a non-empty substring that contains only one unique character.

Given a string s, return the power of s.

 

Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
Example 3:

Input: s = "triplepillooooow"
Output: 5
Example 4:

Input: s = "hooraaaaaaaaaaay"
Output: 11
Example 5:

Input: s = "tourist"
Output: 1
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.
*/

class Solution {
    public int maxPower(String s) {
        int n = s.length();
        if(n == 1)return 1;
        
        int power = 0, len = 1;
        
        for(int i = 1; i < n; i++){
            char ch = s.charAt(i), prev = s.charAt(i - 1);
            
            if(ch == prev)
                len++;
            else{
                power = Math.max(power, len);
                len = 1;
            }
        }
        
        power = Math.max(power, len);
        
        return power;
    }
}
