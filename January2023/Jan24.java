/*
909. Snakes and Ladders
Medium
You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.

Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.

Example 1:


Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation: 
In the beginning, you start at square 1 (at row 5, column 0).
You decide to move to square 2 and must take the ladder to square 15.
You then decide to move to square 17 and must take the snake to square 13.
You then decide to move to square 14 and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
This is the lowest possible number of moves to reach the last square, so return 4.
Example 2:

Input: board = [[-1,-1],[-1,3]]
Output: 1
 

Constraints:

n == board.length == board[i].length
2 <= n <= 20
grid[i][j] is either -1 or in the range [1, n2].
The squares labeled 1 and n2 do not have any ladders or snakes.
*/

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int n2 = n * n;

        //Using Breadth First Search
        boolean[] visited = new boolean[n2 + 1];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;

        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();

            //System.out.println(q);

            while(size-- > 0){
                int rem = q.remove();         

                for(int j = rem + 1; j <= rem + 6 && j <= n2; j++){
                    int r = (j - 1) / n, c = -1;
                    if(r % 2 == 0){
                        c = (j - 1) % n;
                    }else{
                        c = n - 1 - (j - 1) % n;
                    }

                    //now row
                    r = n - r - 1;
                    if(board[r][c] == -1 && !visited[j]){
                        visited[j] = true;
                        q.add(j);
                    }else if(board[r][c] != -1 && !visited[board[r][c]]){//if not visited snake or ladder dest
                        visited[board[r][c]] = true;
                        q.add(board[r][c]);
                    }
                    
                }
            }

            steps++;
            
            if(visited[n2])
                break;
        }

        return visited[n2] ? steps : -1;
    }
}
