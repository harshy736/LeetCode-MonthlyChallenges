/*
5. Longest Palindromic Substring
Medium

Share
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/
class Solution {
    public String longestPalindrome(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int s = 0, e = 0;
		int maxLen = 0;//by default : a char is always pallindromic
		//len = longest pallindromic substring 
		
		//vertically represents starting char
		//horizontally represents ending char
		//blocks below main diagonal can not form any string bcz start > end 
		//i.e value = 0 for blocks below principal diagonal
		
		//(i, j)block stores that the substring is pallindromic or not which starts from starting char and end at ending char
		
		
		//if we got vertically down , we lost 1 starting char
		//if we got horizontally down , we lost 1 ending char
		//if we got diagonally down , we lost 1 char from both starting and end of the string -> m 
		
		//we iterate diagonally form principle diagonal to thr right doagonals
		//bcz all the diagonal below principle stores 0
		
		
		for(int g = 0; g < n; g++){//all diagonals
	        //iterate over 1 diagonal in which g = row - col
		    for(int i = 0, j = g; j < n; i++, j++){
		        char c1 = str.charAt(i);
		        char c2 = str.charAt(j);
		        
		        if(g == 0){//principle diagonal -> stores str of length 1, always be pallindromic
		            dp[i][j] = true;
		        }else if(g == 1){//size = 2
		            if(c1 == c2){
		                dp[i][j] = true;
		            }else{
		                dp[i][j] = false;
		            }
		        }else if(c1 == c2){//depends on mid substring
		            dp[i][j] = dp[i + 1][j - 1];
		        }else{
		            dp[i][j] = false;
		        }
		        
		        if(dp[i][j]){// if substring  is pallindrmic
	                int len = g + 1;//length of this pallindromic string
	                //g = j - 1 = end - start
	                
	                if(len > maxLen){
	                    maxLen = len;
                        s = i;
                        e = j + 1;
	                }
	            }
		    }
		}
        return str.substring(s, e);
    }
}
