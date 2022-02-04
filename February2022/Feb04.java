/*
525. Contiguous Array

Share
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
*/

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length, maxLen = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);//balanced subarray
        
        int currSum = 0;//like prefix sum
        //0 -> subtract 1, 1 -> add 1
        //if we found first index of that prefix sum, the diff betwwn the indices is length of the subarray
        //compare it with max len
        for(int i = 0; i < n; i++){
            currSum += (nums[i] == 0)? -1 : 1;
            
            if(map.containsKey(currSum)){
                int len = i - map.get(currSum);
                maxLen = Math.max(maxLen, len);//compare
            }else{
                map.put(currSum, i);
            }
        }
        
        return maxLen;
    }
}
