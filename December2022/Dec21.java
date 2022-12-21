/*
886. Possible Bipartition
Medium
We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.

Example 1:

Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4] and group2 [2,3].
Example 2:

Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false 

Constraints:

1 <= n <= 2000
0 <= dislikes.length <= 104
dislikes[i].length == 2
1 <= dislikes[i][j] <= n
ai < bi
All the pairs of dislikes are unique.
*/

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {//not -> 2nd solution
        par = new int[2 * n + 1];
        rank = new int[2 * n + 1];
        Arrays.fill(par, -1);
        
        //any person can go to either of any edge
        //explore all possibilties
        //2 indices for evry person
        //2 link means one indices in 1 set
        //2nd indices in diff set
        
        for(int[] d : dislikes){
            union(d[0], d[1] + n);//set 1
            union(d[0] + n, d[1]);//set 2
        }
        
        for(int i = 1; i <= n; i++){
            if(find(i) == find(i + n))//both indices in same set -> contradiction
                return false;
        }
        
        return true;
    }
    
    int[] par, rank;
    
    private int find(int x) {
        if(par[x] == -1)
            return x;
        
        return par[x] = find(par[x]);
    }
    
    private void union(int x, int y){
        int lx = find(x), ly = find(y);
        
        if(lx != ly){
            if(rank[lx] > rank[ly])
                par[ly] = lx;
            else if(rank[lx] < rank[ly])
                par[lx] = ly;
            else{
                rank[lx]++;
                par[ly] = lx;
            }
        }
    }
}
