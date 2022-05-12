/*
47. Permutations II
Medium
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 
Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
*/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //same as permutaton -> only to handke duplicate eleements
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        Arrays.sort(nums);
        
        per(nums, used, new ArrayList<>(), ans);
        
        return ans;
    }
    
    private void per(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> ans){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        int n = nums.length;
        for(int i = 0; i < n; i++){
            //same element is not used more than once at a single pos
            //if previuos same element is used in previous positionn than no issue -> get diff perm
            //but if previous same element is not used -> obviously used in this position
            //so we csn not use the same element again at the same position
            if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])//remove duplicate permutations
                continue;
            
            used[i] = true;
            list.add(nums[i]);
            per(nums, used, list, ans);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
