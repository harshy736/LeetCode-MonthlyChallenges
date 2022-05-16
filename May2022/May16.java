/*
1091. Shortest Path in Binary Matrix
Medium

Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

Example 1:

Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:

Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 
Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
*/
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {//help
        int n = grid.length, m = grid[0].length;
        if(grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return -1;
        
        //boolean[][] visited = new boolean[n][m];
        
        int[][] dir = new int[][]{{-1,-1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1,0}, {1, -1}, {0, -1}};
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        grid[0][0] = 1;
        
        //storing distance in grid
        while(!q.isEmpty()){
            int[] node = q.remove();
            int r = node[0], c = node[1];
            int dist = grid[r][c];
            
            if(r == n - 1 && c == m - 1)
                return dist;

            for(int i = 0; i < 8; i++){
                int x = r + dir[i][0], y = c + dir[i][1];

                if(x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 0){
                    grid[x][y] = dist + 1;
                    q.add(new int[]{x, y});
                }
            }
               
        }
        
        return -1;//bottom right cell not visited
    }
}
