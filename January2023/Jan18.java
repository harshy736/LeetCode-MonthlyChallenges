/*
974. Subarray Sums Divisible by K
Medium
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.

Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Example 2:

Input: nums = [5], k = 9
Output: 0
 
Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
2 <= k <= 104
*/

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;

        int csum = 0;
        int [] count = new int[k];//count of subarrays starting from 0 which by remainder count

        for(int i = 0; i < n; i++){
            csum += nums[i];

            if(csum % k >= 0)
                count[csum % k]++;
            else
                count[csum % k + k]++;
        }

        int ans = 0;

        for(int i = 0; i < k; i++){
            if(count[i] == 0)
                continue;
            
            if(i == 0)
                ans += (count[i] * (count[i] + 1)) / 2;
            else
                ans += (count[i] * (count[i] - 1)) / 2;
        }

        return ans;
    }
}
