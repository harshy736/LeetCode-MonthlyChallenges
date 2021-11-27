/*
238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        suffix[n - 1] = 1;
        
        //fill prefix product
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        
        for(int i = n - 2; i >= 0; i--){
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        
        int[] ans = new int[n];
        ans[0] = suffix[0];
        ans[n - 1] = prefix[n - 1];
        
        for(int i = 1; i < n - 1; i++){
            ans[i] = prefix[i] * suffix[i];
        }
        
        return ans;
    }
}

/*2nd Sol -> O(1) extra space*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        //O(1) extra space
        int[] ans = new int[n];
        
        //first filling every pos with prefix product
        ans[0] = 1;
        for(int i = 1; i < n; i++)
            ans[i] = ans[i - 1] * nums[i - 1];
        
        //now multiply prefix wrt suffix -> desired product
        int suffix = 1;
        for(int i = n - 1; i >= 0; i--){
            ans[i] = ans[i] * suffix;//preix * suffix
            suffix *= nums[i];
        }
        
        return ans;
    }
}

