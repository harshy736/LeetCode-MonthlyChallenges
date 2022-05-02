/*
905. Sort Array By Parity
Easy

Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Example 2:

Input: nums = [0]
Output: [0]
 
Constraints:

1 <= nums.length <= 5000
0 <= nums[i] <= 5000
*/
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int s = 0, e = nums.length - 1;
        
        while(s < e){
            if(nums[s] % 2 == 0)
                s++;
            else{
                swap(nums, s, e);
                e--;
            }
        }
        
        return nums;
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
