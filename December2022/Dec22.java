/*
834. Sum of Distances in Tree
Hard
4.1K
91
Companies
There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.

 

Example 1:


Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: The tree is shown above.
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.
Hence, answer[0] = 8, and so on.
Example 2:


Input: n = 1, edges = []
Output: [0]
Example 3:


Input: n = 2, edges = [[1,0]]
Output: [1,1]
 

Constraints:

1 <= n <= 3 * 104
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
The given input represents a valid tree.
*/

class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        graph = new ArrayList[n];
        count = new int[n];//count of left subtree + right subtree + itself
        ans = new int[n];

        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        dfs1(0, visited);//store ans for root 0
        //and partial ans for other node -> only for their children distances

        //calculate distance to other nodes by parent value

        for(int nbr : graph[0]){
            dfs2(0, nbr);
        }

        return ans;
    }

    private void dfs1(int v, boolean[] visited){
        visited[v] = true;
        count[v] = 1;

        for(int nbr : graph[v]){
            if(!visited[nbr]){//nbr is child of v
                dfs1(nbr, visited);

                //get result
                count[v] += count[nbr];
                ans[v] += (ans[nbr] + count[nbr]);//chCount[nbr]-> for extra edge btw parent and child
            }
        }
    }

    private void dfs2(int par, int child){
        //correct its value first
        //add all distances from other nodes except their family

        ans[child] += (ans[par] - ans[child] - count[child]) + (n - count[child]);

        //call to children
        for(int nbr : graph[child]){
            if(nbr != par){
                dfs2(child, nbr);
            }
        }
    }

    int n;
    int[] count;
    int[] ans;
    List<Integer>[] graph;
}
