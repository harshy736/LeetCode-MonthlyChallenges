/*
16. 3Sum Closest
Medium

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE, ans = 0;
        
        for(int i = 0; i < n - 2; i++){
            int s = i + 1, e = n - 1;
            
            while(s < e){
                int sum = nums[i] + nums[s] + nums[e];
                
                if(Math.abs(sum - target) < minDiff){
                    minDiff = Math.abs(sum - target);
                    ans = sum;
                }
                
                if(sum < target)
                    s++;
                else if(sum > target)
                    e--;
                else
                    return ans;
            }
        }
        
        return ans;
    }
}
