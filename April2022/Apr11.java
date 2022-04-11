/*
1260. Shift 2D Grid
Easy
Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.

Example 1:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]
Example 2:

Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
Example 3:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]]
 
Constraints:

m == grid.length
n == grid[i].length
1 <= m <= 50
1 <= n <= 50
-1000 <= grid[i][j] <= 1000
0 <= k <= 100
*/
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {//not
        int m = grid.length, n = grid[0].length;
        
        k = k % (m * n);
        //on eeery shift bottommost right shifts to 0, 0 and all the remaining elements shift to one right
        //last col elements to start of next roe
        
        //find start(0, 0) for shifted grid
        int total = m * n;
        int start = total - k;//index of new start element in grid
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            res.add(new ArrayList<>());
        }
        int count = 0;
        
        for(int i = start; i < start + total; i++){//iterate over whole array
            int idx = i % total;//index in range of (0, total)
            
            int r = idx / n, c = idx % n;
            
            //count / n -> gives row of corresponding element in shifted grid
            res.get(count / n).add(grid[r][c]);
            count++;
        }
        
        return res;
    }
}
