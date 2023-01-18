/*
918. Maximum Sum Circular Subarray
Medium
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2. 

Constraints:

n == nums.length
1 <= n <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
*/

class Solution {
    public int maxSubarraySumCircular(int[] nums) {//NOT
        //With -> O(1) space
        //for simple max subarray -> simple kadane's
        
        //for maximum circular subarray means some part from start some from end
        //whole array - (elemnts betweeen) = array - subarray
        //for maximize the circular subarray sum we have to minize the subarray sum
        //so for simplicity we change the sign of every nums[i]
        //then max subarray is actually minsubarray bcz sign is changes
        //i.e if sum is 5 -> then -5
        //so we remove this subarry from whole subarray -> we get the max ossible circular subarray
        
        int ans = kadanes(nums);//simple
        
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            nums[i] *= -1;
        }
        
        //circular sum
        int cir = sum + kadanes(nums);
        if(cir == 0)//if remove whole array
            return ans;
        
        ans = Math.max(ans, cir);
        return ans;
    }
    
    public int kadanes(int[] nums){
        int psum = 0;
        int max = Integer.MIN_VALUE;
        
        for(int num : nums){
            if(psum < 0)
                psum = 0;
            
            int curr = psum + num;
            psum = curr;
            max = Math.max(max, curr);
        }
        
        return max;
    }
}
