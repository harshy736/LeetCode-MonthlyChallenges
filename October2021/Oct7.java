//79. Word Search

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solut
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        char fch = word.charAt(0);
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == fch){
                    boolean isFound = findWord(board, word, 0, i, j, visited);
                    if(isFound)
                        return true;
                }
            }
        }
        
        return false;
    }
    
    
    public boolean findWord(char[][] board,String word, int idx, int r, int c, boolean[][] visited)
    {
        if(idx == word.length())
            return true;
        if(r < 0 || c< 0 || r == board.length || c == board[0].length || visited[r][c])
            return false;
        
        char ch = word.charAt(idx);
        if(board[r][c] != ch)//character doesn't match
            return false;
        
        visited[r][c] = true;
        
        //left
        if(findWord(board, word, idx + 1, r, c - 1, visited))
            return true;
        //top
        if(findWord(board, word, idx + 1, r - 1, c, visited))
            return true;
        //right
        if(findWord(board, word, idx + 1, r, c + 1, visited))
            return true;
        //bottom
        if(findWord(board, word, idx + 1, r + 1, c, visited))
            return true;
        
        visited[r][c] = false;
        
        return false;
        
    }
    
}
