/*
329. Longest Increasing Path in a Matrix
Hard

5646

96

Add to List

Share
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1
*/
class Solution {
    int m, n;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//4 directions
    
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] path = new int[m][n];//saves maximum length of maximum path starting with i, j
        for(int i = 0; i < m ; i++){
            Arrays.fill(path[i], -1);
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(path[i][j] == -1){
                    dfs(matrix, path, i, j);
                }
            }
        }
        
        int ans = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans = Math.max(ans, path[i][j]);
            }
        }
        
        return ans;
    }
    
    private void dfs(int[][] matrix, int[][] path, int r, int c){
        int len = 0;//longest increasing path by its neighbour & his nbr is greater than curr
        path[r][c] = 0;//for visited
        
        for(int i = 0; i < 4; i++){
            int x = r + dir[i][0], y = c + dir[i][1];
            if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[r][c]){
                if(path[x][y] == -1){//not calculated its longest increasing path
                    dfs(matrix, path, x, y);
                }
                
                len = Math.max(len, path[x][y]);
            }
        }
        
        path[r][c] = len + 1;//1 for this curr
    }
}
