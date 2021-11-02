//998. Unique Paths III

/*
You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

Example 1:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:


Input: grid = [[0,1],[2,0]]
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 20
1 <= m * n <= 20
-1 <= grid[i][j] <= 2
There is exactly one starting cell and one ending cell.
Accepted
89.9K
Submissions
114.9K
*/

class Solution {
    int path = 0;
    
    public int uniquePathsIII(int[][] grid) {
        int r = -1, c = -1, obstacles = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length;  j++){
                if(grid[i][j] == 1){
                    r = i; 
                    c = j;
                }else if(grid[i][j] == -1){
                    obstacles++;
                }
            }
        }    
        
        int target = grid.length * grid[0].length - obstacles;//nodes to cover
        
        helper(grid, r, c, new boolean[grid.length][grid[0].length] , 0, target);
        
        return path;
    }
    
    
    public void helper(int[][] grid, int r, int c, boolean[][] visited, int count, int target){
        //base
        if(r >= grid.length || r < 0 || c < 0 || c >= grid[0].length || grid[r][c] == -1 || visited[r][c] == true)
            return;
        
        if(grid[r][c] == 2){//end cell
            count++;
            //System.out.println('1');
            if(count == target)//every cell traversed
                path++;
            
            return;
        }
        
        //backtracking
        visited[r][c] = true;
        helper(grid, r - 1, c, visited, count + 1, target);
        helper(grid, r + 1, c, visited, count + 1, target);
        helper(grid, r, c - 1, visited, count + 1, target);
        helper(grid, r, c + 1, visited, count + 1, target);
        visited[r][c] = false;
    }
}
