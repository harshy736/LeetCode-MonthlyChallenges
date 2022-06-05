/*
52. N-Queens II
Hard

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example 1:

Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 
Constraints:

1 <= n <= 9
*/
class Solution {
    int paths = 0;
    
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        
        fillBoard(board, 0);
        
        return paths;
    }
    
    private void fillBoard(boolean[][] board, int r){
        if(r == board.length){
            paths++;
            return;
        }
        
        for(int c = 0; c < board.length; c++){
            if(isSafe(board, r, c)){
                board[r][c] = true;
                fillBoard(board, r + 1);
                board[r][c] = false;//backtrack
            }
        }
    }
    
    private boolean isSafe(boolean[][] board, int row, int col){
        int r = row, c = col;
        
        //in col
        while(--r >= 0){
            if(board[r][col] == true)
                return false;
        }
        
        r = row;
        //in row
        while(--c >= 0){
            if(board[row][c] == true)
                return false;
        }
        c = col;
        
        //left diagonal
        while(--r >= 0 && --c >= 0){
            if(board[r][c])
                return false;
        }
        
        r = row;
        c = col;
        //right diagonal
        while(--r >= 0 && ++c < board.length){
            if(board[r][c])
                return false;
        }
        
        return true;
    }
}
