/*
312. Burst Balloons

You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10
 

Constraints:

n == nums.length
1 <= n <= 500
0 <= nums[i] <= 100
*/

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        //adding 2 padding ballons
        //one at start , one at end
        for(int i = 0; i < n; i++){
            arr[i + 1] = nums[i];
        }
        arr[0] = 1;
        arr[n + 1] = 1;
        
        int[][] dp = new int[n + 2][n + 2];
        //dp[i][j] - stores max coims by bursting all ballons in range(i, j)
        //i - start, j = end
        
        //small array to large array
        for(int wlen = 1; wlen <= n; wlen++){
            for(int start = 1; start <= n - wlen + 1; start++){
                int end = start + wlen - 1;
                int maxCoins = 0;
                
                //give every ballon to burst last
                for(int k = start; k <= end; k++){
                    int coins = dp[start][k - 1] + dp[k + 1][end] + arr[start - 1] * arr[k] * arr[end + 1];
                    if(coins > maxCoins)
                        maxCoins = coins;
                }
                dp[start][end] = maxCoins;
            }
        }
        
        return dp[1][n];
        
    }
}
