/*
491. Non-decreasing Subsequences
Medium
3.1K
205
Companies
Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.

 

Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
Example 2:

Input: nums = [4,4,3,2,1]
Output: [[4,4]]
 

Constraints:

1 <= nums.length <= 15
-100 <= nums[i] <= 100
*/

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        set = new HashSet<>();

        helper(nums, -101, 0, new ArrayList<>());
        
        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> list : set){
            ans.add(list);
        }

        return ans;
    }

    Set<List<Integer>> set;

    public void helper(int[] nums, int prev, int idx, List<Integer> list){
        if(idx == nums.length){
            if(list.size() > 1){
                set.add(new ArrayList<>(list));
            }

            return;
        }

        if(nums[idx] >= prev){
            list.add(nums[idx]);
            helper(nums, nums[idx], idx + 1, list);
            list.remove(list.size() - 1);
        }

        //not participate
        helper(nums, prev, idx + 1, list);
    }    
}
