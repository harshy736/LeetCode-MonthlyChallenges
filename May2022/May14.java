/*
743. Network Delay Time
Medium
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:

Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 
Constraints:

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
*/
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        
        for(int[] edge : times){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        //dfs
        int[] t = new int[n + 1];
        Arrays.fill(t, Integer.MAX_VALUE);
        
        bfs(graph, k, t);
        
        int minTime = -1;
        for(int i = 1; i <= n; i++){
            if(t[i] == Integer.MAX_VALUE    )
                return -1;
            
            minTime = Math.max(t[i], minTime);
        }
        
        return minTime;
    }
    
    private void bfs(List<List<int[]>> graph, int k, int[] t){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(k, 0));
        
        while(!q.isEmpty()){
            Pair rem = q.remove();
            
            t[rem.v] = Math.min(t[rem.v], rem.time);
            for(int[] nbr : graph.get(rem.v)){
                if(rem.time + nbr[1] < t[nbr[0]]){
                    q.add(new Pair(nbr[0], rem.time + nbr[1]));
                }
            }
        }
    }
    
    class Pair{
        int v,time;
        
        Pair(int v, int time){
            this.v = v;
            this.time = time;
        }
    }
}
