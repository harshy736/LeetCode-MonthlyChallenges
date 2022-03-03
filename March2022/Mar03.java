/*
413. Arithmetic Slices
Medium
An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

Example 1:

Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
Example 2:

Input: nums = [1]
Output: 0
Constraints:

1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000
*/
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        //A.P sequence
        
        int n = A.length;
        if(n < 3) 
            return 0;
        
        int i = 2, count = 0, cn = 0;
        
        for( ; i < n; i++){
            if(2 * A[i - 1] == A[i] + A[i - 2]){//this index is last of an A.P sequence
                cn++;//A.P of length 3 -> 1, then if 4th elemnt comes in A.P it contributes 2 arrays
                //if 5th comes in seq it contributes 3 subarrays
                count += cn;//increasing subarrays count which ends with ith
            }else
                cn = 0;
        }
        
        return count;
    }
}
