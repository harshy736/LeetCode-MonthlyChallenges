/*
334. Increasing Triplet Subsequence
Medium

Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 

Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
*/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n < 3)return false;
        
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            if(nums[i] > min2){//triplet complete - kth
                return true;
            }else if(nums[i] < min1){//ith
                min1 = nums[i];
            }else if(nums[i] > min1 && nums[i] < min2){//jth
                min2 = nums[i];
            }
        }
        
        return false;
    }
}

