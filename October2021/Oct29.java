//Rotting oranges

/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;//no of fresh oranges
        
        //add rotten oranges to queue
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2)//rotten
                    q.add(new int[]{i, j});
                else if(grid[i][j] == 1)
                    fresh++;//coumt of fresh oranges
            }
        }
        
        if(fresh == 0) return 0;
        if(q.size() == 0) return -1;
        
        int[][] directions = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

        
        int level = -1;
        while(q.size() > 0){
            int size = q.size();
            
            while(size-- > 0){
                int[] rem = q.remove();
                
                for(int[] dir : directions){
                    int x = rem[0] + dir[0];
                    int y = rem[1] + dir[1];
                    
                    
                    if(x < 0 || y < 0 || x == grid.length || y == grid[0].length ||  grid[x][y] != 1)
                        continue;
                    
                    grid[x][y] = 2;//fresh converted to rotten -> like visited
                    q.add(new int[]{x, y});
                    fresh--;
                   
                }
            }
            
            level++;
        }
        
        if(fresh > 0)//fresh oranges left
            return -1;
        
        return level;
    }
}
