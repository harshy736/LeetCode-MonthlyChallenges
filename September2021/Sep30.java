//Partition to K Equal Sum Subsets

/*
Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false
 

Constraints:

1 <= k <= nums.length <= 16
1 <= nums[i] <= 104
The frequency of each element is in the range [1, 4].
*/

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k == 1)
            return true;
        
        int sum = 0;
        for(int i : nums)
            sum += i;
        
        if(sum % k != 0)//equal sets not possible
            return false;
        
        int[] spaces = new int[k];
        Arrays.sort(nums);
        return helper(0, nums, 0, k, spaces, sum / k);
    }
    
    public boolean helper(int s, int[] nums, int e, int k, int[] spaces, int target){
        if(s == nums.length)//base
            return true;
        
        for(int i = 0; i < e; i++)
            if(spaces[i] + nums[s] <= target){//nums[s] -> possible member of ith parition
                spaces[i] += nums[s];
            if(helper(s + 1, nums, e, k, spaces,target))//if partition possible 
                return true;
            spaces[i] -= nums[s];//backtracking
        }
            
        if(e < k && nums[s] <= target){
            spaces[e] += nums[s];
            if(helper(s + 1, nums, e + 1, k, spaces, target))
                return true;
            
            spaces[e] -= nums[s];
        }
        
        return false;
    }
}
