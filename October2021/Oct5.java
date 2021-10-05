// Climbing Stairs

/*
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

1 <= n <= 45
*/

class Solution {
    public int climbStairs(int n) {
        //2 methods -> recusion or dp
        //using dp
        
        int[] dp = new int[n + 1];
        dp[n] = dp[n - 1] = 1;//final pos & last step -> only onew way
        
        //find ways from all other steps -> in reverse order
        for(int i = n - 2; i >= 0; i--){
            dp[i] = dp[i + 1] + dp[i + 2];
            //dp[i + 1] -> gives ways if jumsps 1 step
            //dp[i + 2] -> gives ways if jumsps 2 step
        }
        
        return dp[0];//ways from starting
    }
}
