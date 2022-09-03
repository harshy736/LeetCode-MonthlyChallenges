/*
967. Numbers With Same Consecutive Differences
Medium

Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.

Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.

You may return the answer in any order.

Example 1:

Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:

Input: n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 

Constraints:

2 <= n <= 9
0 <= k <= 9
*/

class Solution {
    HashSet<Integer> set;
    public int[] numsSameConsecDiff(int n, int k) {
        set = new HashSet<>();
        
        for(int i = 1; i <= 9; i++){
            helper(i, 1, n, k);  
            helper(i, 1, n, k);  
        }
        
        int size = set.size();
        int[] ans = new int[size];
        
        int idx = 0;
        for(int val : set){
            ans[idx++] = val;
        }
        
        return ans;
    }
    
    private void helper(int num,int len, int n, int k){
        if(len == n){
            set.add(num);
            return;
        }
        
        int prevDigit = num % 10;

        if(prevDigit  + k < 10){
            helper(num * 10 + prevDigit + k, len + 1, n, k);
        }

        if(prevDigit - k >= 0){
            helper(num * 10 + prevDigit - k, len + 1, n, k);
        }
    }
}
