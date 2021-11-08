//96. Unique Binary Search Trees

/*
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

 

Example 1:


Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 19
*/

class Solution {
    public int numTrees(int n) {
        if(n == 1) return 1;
        
        //it is a type of catalan sequence 
        //1 1 2 5 14 42
        //catalan formula : C(n) = (2n)!/(n + 1)!(n)!
        //OR C(n)= C(0).C(n - 1) + C(1).C(n - 2) + C(2).C(n-3) + .... + C(n - 1).C(0)
        //we use 2nd
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        
        return dp[n];
    }
}
