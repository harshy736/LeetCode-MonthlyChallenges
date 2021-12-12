/*
416. Partition Equal Subset Sum

Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return false;
        
        int sum = 0;
        for(int i = 0; i < n; i++)
            sum += nums[i];
        
        if(sum % 2 == 1)//odd sum -> partition not possible
            return false;
        
        int target = sum/2;//sum of 1 partition
        //if we make target sum from array -> partition is possible
        
        //we use 1D dp
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        
        for(int i = 0; i < n; i++){
            int val = nums[i];
            for(int j = target; j >= val; j--){
                //j - val -> true, By adding val into it jth target is also achieved
                if(dp[j - val] == true)
                    dp[j] = true;
            }
            
        }
        
        
        return dp[target];
    }
    
    
}
