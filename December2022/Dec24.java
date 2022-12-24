/*
790. Domino and Tromino Tiling
Medium
You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.

Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.

Example 1:

Input: n = 3
Output: 5
Explanation: The five different ways are show above.
Example 2:

Input: n = 1
Output: 1

Constraints:

1 <= n <= 1000
*/

class Solution {
    public int numTilings(int n) {
        int dp[] = new int[n+4];
        
        int mod = (int)(Math.pow(10,9)+7);
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        
        //By intution -> we get dp[n] = dp[n - 1] + dp[n - 2] + 2 X (dp[n - 3] + dp[n - 4] + .... + dp[0])
        //T(n) = T(n - 1) + T(n - 2) + 2 X (T(n - 3) + T(n - 4) + .... + T(1) + T(0))

        //So by solving by T(n) & T (n - 1)

        //we get T(n) = 2 X T(n - 1) + T(n - 3)

        for(int i = 4; i <= n; i++){
            dp[i] = ((2 * dp[i - 1]) % mod) + dp[i - 3];
            dp[i] %= mod;
        }
        
        return dp[n];
    }
}
