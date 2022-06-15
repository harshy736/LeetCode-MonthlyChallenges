/*
583. Delete Operation for Two Strings
Medium

Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4
 
Constraints:

1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters.
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        
        //By DP
        int[][] dp = new int[n1 + 1][n2 + 1];
        //every i, j stores minimum no of delete op to make 2 string equal sub1(0, i) & sub2(0, j);
        
        for(int i = 0; i <= n1; i++){
            for(int j = 0; j <= n2; j++){
                if(i == 0){//word2 is empty
                    dp[i][j] = j;//delete all the characters in word1
                }else if(j == 0){//word1 is empty
                    dp[i][j] = i;//delete all chars in word2
                }else{//non empty substrings
                    char c1 = word1.charAt(i - 1);
                    char c2 = word2.charAt(j - 1);
                    
                    if(c1 == c2){//no need to delete the c1 & c2 ans is same as prevoious rem substring
                        dp[i][j] = dp[i - 1][j - 1];
                    }else{//we can not contains both chars 
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    }
                }
            }
        }
        
        return dp[n1][n2];
    }
}
