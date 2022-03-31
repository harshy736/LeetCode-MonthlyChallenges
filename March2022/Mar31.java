/*
410. Split Array Largest Sum
Hard

Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.

Example 1:

Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], m = 2
Output: 9
Example 3:

Input: nums = [1,4,4], m = 3
Output: 4
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= m <= min(50, nums.length)
*/
class Solution {
    public int splitArray(int[] nums, int m) {//not
        //O(n * log(10^6))
        //minimum sum -> maximum number
        //maximum sum -> sum of whole array
        //using binary search find the minimum partition sum
        
        int lo = 0, hi = 0;//lo -> maximum number, hi -> sum of array
        
        for(int num : nums){
            lo = Math.max(lo, num);
            hi += num;
        }
        
        //now binary search
        int ans = helper(nums, lo, hi, m);
        return ans;
    }
    
    private int helper(int[] nums, int lo, int hi, int m){
        int ans = hi;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(isPartition(nums, mid, m)){//mid is possible ans
                ans = mid;
                hi = mid - 1;//try to get minumise the answer
            }else{//partition not possible if max part sum is mid -> work on > mid
                lo = mid + 1;
            }
        }
        
        return ans;
    }
    
    private boolean isPartition(int[] nums, int limit, int m){
        int par = 1, sum = 0;
        
        for(int num : nums){
            if(sum + num <= limit){//could be in this group
                sum += num;
            }else{//new group required -> limit crossed
                sum = num;
                par++;
            }
        }
        
        return par <= m;
    }
}
