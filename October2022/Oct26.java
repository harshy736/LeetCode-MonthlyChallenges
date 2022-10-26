/*
523. Continuous Subarray Sum
Medium


Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.

An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

Example 1:

Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
Example 2:

Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
Example 3:

Input: nums = [23,2,6,4,7], k = 13
Output: false
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109
0 <= sum(nums[i]) <= 231 - 1
1 <= k <= 231 - 1
*/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //Concept
        //if rem == 0 then true
        
        //means work only on rem part, rem = sum % k
        //rem lies from 0 to k - 1
        
        //take csum array if rem repeates means if we subtract the first part then the subarray consist of sum which having rem 0 -> true
        //check on various example
        //for k = 6, 26 - 14, 92 - 8, 65 - 17 etc
        
        //means to store only rem portion if rem repeats -> return true
        
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        
        int csum = nums[0], n = nums.length;
        int psum = csum;//prev sum
        
        //take care of size 2 
        for(int i = 1; i < n; i++){
            csum += nums[i];
            
            if(set.contains(csum % k))
                return true;
            
            set.add(psum % k);
            psum = csum;
        }
        
        return false;
    }
}
