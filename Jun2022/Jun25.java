/*
665. Non-decreasing Array
Medium

Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.
 

Constraints:

n == nums.length
1 <= n <= 104
-105 <= nums[i] <= 105
*/
class Solution {
    public int checkRecord(int n) {
        if(n == 1)
            return 3;
        
        int MOD = 1000000007;
        
        long[] dp = new long[n + 1];//stores number of valid attendece without any leave
        dp[0] = 1;
        dp[1] = 2;
        
        long p = 1, l = 1, ll = 0;//p -> ends with p, l -> ends eith l, ll -> ends with ll
        
        for(int len = 2; len <= n; len++){
            long np = (p + l + ll);
            long nl = p;
            long nll = l;
            
            dp[len] = (np + nl + nll) % MOD;
            //dp[len] %= MOD;
            
            p = np % MOD;
            l = nl % MOD;
            ll = nll % MOD;
        }
        
        //Now we also have to take 1 absent day into account
        //A is +nt on any position -> A _ _ _ _ _ _ , _ A _ _ _ _, _ _ A _ _ _  etc
        //we take evry possibilty of sequence
        
        long abs = 0;
        for(int pos = 0; pos < n; pos++){
            abs = (abs + (dp[pos] * dp[n - pos - 1]) % MOD) % MOD;//pos lenth str in left & (n - pos - 1) len str in right
        }
       
        dp[n] %= MOD;
        
        long ans = (dp[n] + abs) % MOD;
        
        //System.out.println(abs + " " + ans + " " + dp[n]);
        
        int count = (int)ans;
        return count;
    }
}
