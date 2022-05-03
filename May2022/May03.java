/*
581. Shortest Unsorted Continuous Subarray
Medium

5690

214

Add to List

Share
Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
 

Follow up: Can you solve it in O(n) time complexity?
*/
class Solution {
	public static int findUnsortedSubarray(int[] nums) {
    if (nums == null || nums.length == 0) {
                return 0;
            }

            int N = nums.length;

            int right = -1;//rightmost number to sort
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                if (max > nums[i]) {
                    right = i;
                }
                max = Math.max(max, nums[i]);
            }

            int left = N;//leftmost number to swap
            int min = Integer.MAX_VALUE;
            for (int i = N - 1; i >= 0; i--) {
                if (min < nums[i]) {
                    left = i;
                }
                min = Math.min(min, nums[i]);
            }

            return Math.max(0, right - left + 1);
    }
}
