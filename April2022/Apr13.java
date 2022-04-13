/*
59. Spiral Matrix II
Medium

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 
Constraints:

1 <= n <= 20
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int sr = 0, sc = 0, er = n - 1, ec = n - 1;
        int val = 1;
        
        while(sr <= er && sc <= ec){
            //filling sr
            for(int j = sc; j <= ec; j++){
                ans[sr][j] = val++;
            }
            sr++;
            
            //filling ec
            for(int i = sr; i <= er; i++){
                ans[i][ec] = val++;
            }
            ec--;
            
            //filling er
            for(int j = ec; j >= sc; j--){
                ans[er][j] = val++;
            }
            er--;
            
            //filling sc
            for(int i = er; i >= sr; i--){
                ans[i][sc] = val++;
            }
            sc++;
        }
        
        return ans;
    }
}
