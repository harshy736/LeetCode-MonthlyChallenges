/*
51. N-Queens
Hard

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]

Constraints:

1 <= n <= 9
*/
class Solution {
    List<List<String>> ans;
    StringBuilder emptyRow;
    
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        emptyRow = new StringBuilder();
        for(int i = 0; i < n; i++){
            emptyRow.append('.');
        }
        
        boolean[][] board = new boolean[n][n];
        
        find(board, 0, new ArrayList<>());
        
        return ans;
    }
    
    public void find(boolean[][] board, int r, List<String> list){
        if(r == board.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        int n = board.length;
        
        for(int c = 0; c < n; c++){
            if(isSafe(board, r, c)){
                board[r][c] = true;
                StringBuilder sb = new StringBuilder(emptyRow);
                sb.setCharAt(c, 'Q');
                list.add(sb.toString());
                
                find(board, r + 1, list);
                
                //backtracking
                list.remove(list.size() - 1);
                board[r][c] = false;
            }
        }
    }
    
    private boolean isSafe(boolean[][] board, int r, int c){
        
        //in column
        for(int i = 0; i < r; i++){
            if(board[i][c])
                return false;
        }
        
        int i = r, j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j])
                return false;
            
            i--;
            j--;
        }
        
        int n = board.length;
        
        i = r;
        j = c;
        while(i >= 0 && j < n){
            if(board[i][j])
                return false;
            
            i--;
            j++;
        }
        
        return true;
    }
}
