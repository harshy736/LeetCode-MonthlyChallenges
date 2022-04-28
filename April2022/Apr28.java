/*
1631. Path With Minimum Effort
Medium
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

Example 1:

Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
Example 2:

Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
Example 3:


Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
 

Constraints:

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
*/
class Solution {
    int[] dirx = {0, 1, 0, -1};
    int[] diry = {1, 0, -1, 0};
    
    public int minimumEffortPath(int[][] heights) {
        //Binary Search + DFS
        int r = heights.length, c = heights[0].length, max = 0, min = Integer.MAX_VALUE;
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                max = Math.max(max, heights[i][j]);
                min = Math.min(min, heights[i][j]);
            }
        }
        
        int s = 0, e = max - min, ans = 0;
        
        while(s <= e){
            int k = (s + e) / 2;
            
            if(traverse(heights, 0, 0, r, c, new boolean[r][c], k)){
                ans = k;
                e = k - 1;
            }else{
                s = k + 1;
            }
        }
        
        return ans;
    }
    
    private boolean traverse(int[][] heights, int i, int j, int r, int c, boolean[][] visited, int k){
        if(i == r - 1 && j == c - 1)
            return true;
        
        visited[i][j] = true;
        
        //4 directions
        for(int d = 0; d < 4; d++){
            int x = i + dirx[d], y = j + diry[d];
            
            if(x >= 0 && y >= 0 && x < r && y < c && !visited[x][y]){
                int e = Math.abs(heights[i][j] - heights[x][y]);
                
                //if effort is less than k for next step -> then dpends on next step
                if(e <= k && traverse(heights, x, y, r, c, visited, k))
                    return true;
            }
        }
        
        return false;
    }
}
