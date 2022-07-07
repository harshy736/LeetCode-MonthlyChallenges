/*
97. Interleaving String
Medium

4322

242

Add to List

Share
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true
 
Constraints:

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lowercase English letters.
 

Follow up: Could you solve it using only O(s2.length) additional memory space?
*/

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        if(s3.length() == 0)
            return true;
        
        int m = s1.length(), n = s2.length();
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        //dp[i][j] - stores that s3.substring(0, i + j - 1) is interleaving string of s1.ubstring(0, i - 1) and s2.substring(0, j - 1)
        //using tabulation
        //works on last character whereas meoization works on first character
        //if last character matches then possiblity depends on previous remaining strings inter;eaving
        //row -> s1, col -> s2
        //first row - blank of s1, first col - blank of s2
        
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 && j == 0)//blank strings
                    dp[i][j] = true;
                else if(i == 0){//only s2
                    dp[i][j] = s2.charAt(j - 1) == s3.charAt(j - 1) ? dp[i][j - 1] : false;
                }else if(j == 0){//only s1
                    dp[i][j] = s1.charAt(i - 1) == s3.charAt(i - 1) ? dp[i - 1][j] : false;
                }else{
                    //if s1 last char matches s3 last char
                    if(s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        dp[i][j] = dp[i - 1][j];//depneds on s1(0, i - 2) and s2(0, j - 1)
                    
                    //if false then check
                    if(!dp[i][j] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                        dp[i][j] = dp[i][j - 1];
                }
            }
        }
        
        return dp[m][n];
        
    }
}
