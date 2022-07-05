/*
128. Longest Consecutive Sequence
Medium

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 
Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 0)
            return 0;
        
        int len = 1, ans = 0;
        
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1])
                continue;
            else if(nums[i] - nums[i - 1] == 1){
                len++;
            }else{
                ans = Math.max(ans, len);
                len = 1;
            }
        }
        
        ans = Math.max(ans, len);
        return ans;
    }
}
