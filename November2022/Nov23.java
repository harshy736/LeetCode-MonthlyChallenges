/*
36. Valid Sudoku
Medium

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if(board[i][j] != '.' && !isValid(board, i, j))
                    return false;
        
        return true;
    }
    
    private boolean isValid(char[][] board, int r, int c){
        int i = r, j = c;
        while(--i >= 0)
            if(board[i][j] == board[r][c])
                return false;
        
        i = r;
        while(++i < 9)
            if(board[i][j] == board[r][c])
                return false;
        
        i = r;
        while(--j >= 0)
            if(board[i][j] == board[r][c])
                return false;
        
        j = c;
        while(++j < 9)
            if(board[i][j] == board[r][c])
                return false;
        
        //3 X 3 sub box
        int x = r / 3, y = c / 3;
        for(int p = 3 * x; p < 3 * x + 3; p++){
            for(int q = 3 * y; q < 3 * y + 3; q++){
                if(p == r && q == c)
                    continue;
                if(board[p][q] == board[r][c])
                    return false;
            }
        }
        
        return true;
    }
}
