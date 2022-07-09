/*
1696. Jump Game VI
Medium

You are given a 0-indexed integer array nums and an integer k.

You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.

You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.

Return the maximum score you can get.

Example 1:

Input: nums = [1,-1,-2,4,-7,3], k = 2
Output: 7
Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.
Example 2:

Input: nums = [10,-5,-2,4,0,3], k = 3
Output: 17
Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.
Example 3:

Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
Output: 0
 

Constraints:

1 <= nums.length, k <= 105
-104 <= nums[i] <= 104
*/
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        //dp[i] -> stores maximum score to reach ith
        
        LinkedList<Integer> list = new LinkedList<>();//monotonic queue -> sdecreasing queue
        
        dp[0] = nums[0];
        list.addLast(0);
        
        for(int i = 1; i < n; i++){
            if(i - list.getFirst() > k){//can not reach from first to ith -> remove
                list.removeFirst();
            }
            
            dp[i] = dp[list.getFirst()] + nums[i];//we have to choose maximum score pos where we can jump to ith
            //all the elemnts on the right of first must be smaller in value than it -> choose first as pos to jump to ith -> for maximum score
            
            while(!list.isEmpty() && dp[i] >= dp[list.getLast()]){
                list.removeLast();
            }
            
            list.addLast(i);
        }
        
        
        return dp[n - 1];
    }
}
