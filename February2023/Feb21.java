/*
540. Single Element in a Sorted Array
Medium
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        //BY bineray search
        int n = nums.length;
        int lo = 0, hi = n - 2;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            //mid -> even mid^1 -> next odd or vice versa -> adjacent pairs with even - > odd
            if(nums[mid] == nums[mid^1]){//left half
                lo = mid + 1;
            }else{//right
                hi = mid - 1;
            }
        }
        
        return nums[lo];
    }
}
