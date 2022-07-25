/*
34. Find First and Last Position of Element in Sorted Array
Medium

12391

316

Add to List

Share
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        
        int n = nums.length;
        if(n == 0)return ans;
        
        //using binary search
        ans[0] = search(nums, target, true);
        
        if(ans[0] != -1)//found
         ans[1] = search(nums, target, false);
        
        return ans;
    }
    
    private int search(int[] nums, int target, boolean startIndex){
        int lo = 0, hi = nums.length - 1;
        int idx = -1;//not found
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            if(nums[mid] == target){//found
                idx = mid;
                
                if(startIndex)
                    hi = mid - 1;//to find start
                else
                    lo = mid + 1;//to find end
            }else if(nums[mid] > target){//find in left
               hi = mid - 1;
            }else{
                lo = mid + 1;           
            }
        }
        
        return idx;
    }
}
