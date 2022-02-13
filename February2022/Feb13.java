/*
78. Subsets
Medium
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> list, List<List<Integer>> result){
        if(list.size() > nums.length)return;//not possible
        
        result.add(new ArrayList<>(list));
        
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            backtrack(nums, i + 1, list, result);
            list.remove(list.size() - 1);//backtracking
        }
    }
}
