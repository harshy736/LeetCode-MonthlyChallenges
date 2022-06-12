/*
1695. Maximum Erasure Value
Medium

1564

25

Add to List

Share
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

 

Example 1:

Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].
Example 2:

Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
*/
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();//contains latest index for any value
        
        int[] csum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            csum[i] = csum[i - 1] + nums[i - 1];
        }
        
        int s = 0, ans = 0;
        for(int i = 1; i <= n; i++){//run according to csum index
            if(map.containsKey(nums[i - 1])){//
                s = Math.max(s, map.get(nums[i - 1]) + 1);
            }
            
            ans = Math.max(ans, csum[i] - csum[s]);
            map.put(nums[i - 1], i - 1);
        }
        
        return ans;
    }
}
