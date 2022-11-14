/*
947. Most Stones Removed with Same Row or Column
Medium

3684

564

Add to List

Share
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.

A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.

Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.

 

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Explanation: One way to remove 5 stones is as follows:
1. Remove stone [2,2] because it shares the same row as [2,1].
2. Remove stone [2,1] because it shares the same column as [0,1].
3. Remove stone [1,2] because it shares the same row as [1,0].
4. Remove stone [1,0] because it shares the same column as [0,0].
5. Remove stone [0,1] because it shares the same row as [0,0].
Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Explanation: One way to make 3 moves is as follows:
1. Remove stone [2,2] because it shares the same row as [2,0].
2. Remove stone [2,0] because it shares the same column as [0,0].
3. Remove stone [0,2] because it shares the same row as [0,0].
Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.
Example 3:

Input: stones = [[0,0]]
Output: 0
Explanation: [0,0] is the only stone on the plane, so you cannot remove it.
 

Constraints:

1 <= stones.length <= 1000
0 <= xi, yi <= 104
No two stones are at the same coordinate point.
*/

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        //every stone is a node
        //we can remove size - 1 nodes from connected set
        //we have to connect sets
        
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();
        //stores one node per row(in which stone exists)
        //same for col
        
        par = new int[n + 1];
        rank = new int[n + 1];
        Arrays.fill(par, -1);
        
        //connection -> same row or same col
        for(int i = 0; i < n; i++){
            int x = stones[i][0], y = stones[i][1];
            //i -> node number
            
            if(!row.containsKey(x)){//first stone in this row
                row.put(x, i);
            }else{
                union(row.get(x), i);
            }
            
            if(!col.containsKey(y)){//1st stone in this col
                col.put(y, i);
            }else{
                union(col.get(y), i);
            }
        }
        
        HashSet<Integer> sets = new HashSet<>();
        for(int i = 0; i < n; i++){
            int x = stones[i][0], y = stones[i][1];
            //i -> node  
            
            int p = find(i);
            sets.add(p);
        }
        
        int rem = n - sets.size();//one node was left in every union set
        
        return rem;
    }
    
    int[] par, rank;
    
    private int find(int x){
        if(par[x] == -1)
            return x;
        
        return par[x] = find(par[x]);
    }
    
    private void union(int x, int y){
        int lx = find(x), ly = find(y);
        
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                par[ly] = lx;
            }else if(rank[lx] < rank[ly]){
                par[lx] = ly;
            }else{
                rank[lx]++;
                par[ly] = lx;
            }
        }
    }
}
