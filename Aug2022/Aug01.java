/*
62. Unique Paths
Medium

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:

Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Constraints:

1 <= m, n <= 100
*/
class Solution {
    public int uniquePaths(int m, int n) {//Wihout DP -> Combinatorics
        //Striver
        //to reach bottom right
        //one has to go m - 1 down and n - 1 right
        //total of (m - 1) + (n - 1) -> moves  = (m + n - 2) moves
        //form which m - 1 are down and remainning are right
        //paths are permutations of this
        //for e.g m = 3, n = 2 -> total move = 3 + 2 - 2 = 3 moves
        //_ _ _ -> 2 D & 1R
        //paths -> DDR, DRD, RDD
        //if we can place only D then all the ramining are R
        //in how many ways we can place m - 1 D -> gives permuattion count
        //we have to select (m - 1) places from m + n - 2
        //(m + n - 2) C (m - 1) if we done by n - 1 it is also same
        //nCr = n! /(N - r)! * r! = n * (n - 1) * (n - 2) * (n - r + 1) / r!
        
        int T = m + n - 2;
        int r = m - 1;
        //ans is TCr
        double ans = 1;
        
        for(int i = 1; i <= r; i++){
            ans = ans * (T - r + i) / i;
        }
        
        return (int)ans;
    }
}
