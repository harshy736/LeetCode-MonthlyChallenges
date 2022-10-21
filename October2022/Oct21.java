/*
219. Contains Duplicate II
Easy

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
*/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        boolean ans = false;
        
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(nums[i])){//same value exists twice
                int j = hm.get(nums[i]);//index of same value
                if(i - j <= k){
                    ans = true;
                    break;
                }
            }
            
            hm.put(nums[i], i);
        }
        
        return ans;
    }
}


