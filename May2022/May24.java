/*
32. Longest Valid Parentheses
Hard

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.


Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
*/
class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] dp = new int[n];
        //dp[i] -> stores max length of valid substring which ends on it
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i  < n; i++){
            if(arr[i] == '('){
                st.push(i);
            }else if(st.size() > 0){//ch -> ')'
                //remove prev (
                int idx = st.pop();//index of closest ( in left -> valid pair
                //dp[idx - 1] -> stores len of substring which ends on idx - 1 
                //can be concatenate with curr vald pair easily
                
                dp[i] += (i - idx + 1);//length of this valid parenthesis string
                if(idx > 0){
                    dp[i] += dp[idx - 1];//previous valid -> concatenate
                }
                
                ans = Math.max(ans, dp[i]);
            }
        }
        
        return ans;
    }
}
