//260. Single Number III

/*
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

 

Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
Example 2:

Input: nums = [-1,0]
Output: [-1,0]
Example 3:

Input: nums = [0,1]
Output: [1,0]
 

Constraints:

2 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each integer in nums will appear twice, only two integers will appear once.

*/
class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2)
          return nums;
        
        int xor = 0;
        
        for(int i: nums)
            xor ^= i;
        
        int rmsb = xor & -xor ;
        int X=0, Y=0;
        for(int i=0; i<nums.length; i++){
            if((nums[i] & rmsb) == 0)
                X ^= nums[i];
            else
                Y ^= nums[i];
        }
        
        return new int[]{X, Y};
    }
}
