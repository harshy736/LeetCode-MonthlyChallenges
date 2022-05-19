/*
1192. Critical Connections in a Network
Hard

There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

Example 1:

Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
Example 2:

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]
 
Constraints:

2 <= n <= 105
n - 1 <= connections.length <= 105
0 <= ai, bi <= n - 1
ai != bi
There are no repeated connections.
*/
class Solution {
    int t = 1;
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] id = new int[n];//id of every node usually given as the pointer goes there
        int[] low = new int[n];//minimum id node reachable from here by 2 or more paths
        Arrays.fill(id, -1);
        Arrays.fill(low, Integer.MAX_VALUE);
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        for(List<Integer> edge : connections){
            int u = edge.get(0), v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        dfs(graph, 0, -1, id, low);
        
        return list;
    }
    
    private void dfs(List<List<Integer>> graph, int v, int par, int[] id, int[] low){
        id[v] = t;
        low[v] = t;
        t++;
        
        for(int nbr : graph.get(v)){
            if(nbr == par)//parent edge
                continue;
            if(low[nbr] <= low[v])//already visited
                low[v] = low[nbr];
            else{//need to visit
                dfs(graph, nbr, v, id, low);
                low[v] = Math.min(low[v], low[nbr]);
                if(low[nbr] > id[v]){//nbr can not reach v by any other path -> only one path connecting them -> critical path
                    List<Integer> critical = new ArrayList<>();
                    critical.add(v);
                    critical.add(nbr);
                    list.add(critical);
                }
            }
        }
    }
}
