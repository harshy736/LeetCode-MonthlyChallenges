/*
823. Binary Trees With Factors
Medium

1370

137

Add to List

Share
Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.

We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.

Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [2,4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]
Example 2:

Input: arr = [2,4,5,10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 

Constraints:

1 <= arr.length <= 1000
2 <= arr[i] <= 109
All the values of arr are unique.
*/
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        //like  dp -> storing count for smaller divisors -> if they bacome factor of bigger number than it can use
        
        int n = arr.length;
        long[] dp = new long[n];
        HashMap<Integer, Integer> index = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            index.put(arr[i], i);
        }
        
        int MOD = (int)(1e9 + 7);
        
        for(int i = 0; i < n; i++){
            dp[i] = 1;//for itself
            for(int j = 0; j < i; j++){
                if(arr[i] % arr[j] == 0){//divisor -> child
                    int o = arr[i] / arr[j];
                    
                    if(index.containsKey(o)){//both factors in arr
                        dp[i] = (dp[i] + dp[j] * dp[index.get(o)]) % MOD;
                    }
                }
            }
        }
        
        long ans = 0;
        for(long val : dp){
            ans += val;
        }
        ans %= MOD;
        
        
        return (int)ans;
    }
}
