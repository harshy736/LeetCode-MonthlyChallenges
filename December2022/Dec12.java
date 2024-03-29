/*
70. Climbing Stairs
Easy
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:
*/

class Solution {
    public int climbStairs(int n) {
        //2 methods -> recusion or dp
        //using dp
        
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;//only new way
        
        //find ways from all other steps
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
            //dp[i - 1] -> gives ways if jumps 1 step
            //dp[i - 2] -> gives ways if jumps 2 step
        }
        
        return dp[n];//last pos
    }
}
