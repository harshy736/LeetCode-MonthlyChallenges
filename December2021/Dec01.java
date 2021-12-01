/*
198. House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        //using dp
        int[] dp = new int[n];
        //dp[i] -> stores maximum amount robbed if only i houses are there
        
        dp[0] = nums[0];//first house
        
        if(n >= 2)//2nd house exists
            dp[1] = Math.max(nums[0], nums[1]);
        
        //iterate for all houses
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            //if ith house is robbed -> dp[i - 2] + nums[i]
            //find maximum of if its neighbour is robbed or it is robbed
        }
        
        return dp[n - 1];
        
    }
}
