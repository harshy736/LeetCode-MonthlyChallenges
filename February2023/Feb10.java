/*
1162. As Far from Land as Possible
Medium
Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

Example 1:

Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
Example 2:

Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
*/

class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        //Now without BFS

        int max = n * 2;

        int[][] dist = new int[n][n];

        //for top and left
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    dist[i][j] = 0;
                    continue;
                }

                //now for water
                dist[i][j] = max;
                int top = max, left = max;

                if(i > 0)
                    top = dist[i - 1][j];
                if(j > 0)
                    left = dist[i][j - 1];
                
                dist[i][j] = Math.min(dist[i][j], Math.min(top, left) + 1);
            }
        }

        //for bottom and right
        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(grid[i][j] == 1){
                    dist[i][j] = 0;
                    continue;
                }

                //now for water
                int bottom = max, right = max;

                if(i < n - 1)
                    bottom = dist[i + 1][j];
                if(j < n - 1)
                    right = dist[i][j + 1];
                
                dist[i][j] = Math.min(dist[i][j], Math.min(bottom, right) + 1);
            }
        }

        int ans = -1;
        //for top and left
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0 && dist[i][j] != max){
                    ans = Math.max(ans, dist[i][j]);
                }
            }
        }

        return ans;
    }
}
