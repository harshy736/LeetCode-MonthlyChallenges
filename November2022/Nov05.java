/*
212. Word Search II

Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example 1:
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 
Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
*/

class Solution {
    HashSet<String> ans;
    Trie root;
    public List<String> findWords(char[][] board, String[] words) {
        ans = new HashSet<>();
        
        root = new Trie();
        
        for(String word : words){
            add(word);
        }
        
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(board, i, j, visited, root);
            }
        }
        
        List<String> res = new ArrayList<>();
        for(String str : ans)
            res.add(str);
        
        return res;
    }
    
    private void dfs(char[][] board, int r, int c, boolean[][] visited, Trie curr){
        if(curr.word != null)
            ans.add(curr.word);
        
        if(r < 0 || c < 0 || r == board.length || c == board[0].length || visited[r][c])
            return;
        
        if(curr.children[board[r][c] - 'a'] == null)//no word exists
            return;
        
        visited[r][c] = true;
        Trie next = curr.children[board[r][c] - 'a'];
        
        dfs(board, r - 1, c, visited, next);
        dfs(board, r, c + 1, visited, next);
        dfs(board, r + 1, c, visited, next);
        dfs(board, r, c - 1, visited, next);
        
        visited[r][c] = false;
    }
    
    public void add(String word){
        Trie curr = root;
        
        for(char ch : word.toCharArray()){
            if(curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new Trie();
            
            curr = curr.children[ch - 'a']; 
        }
        
        curr.word = word;
    }
}

class Trie{
    String word;
    Trie[] children;
    
    Trie(){
        word = null;
        children = new Trie[26];
    }
}
