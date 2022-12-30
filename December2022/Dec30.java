/*
797. All Paths From Source to Target
Medium
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

Example 1:

Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Example 2:

Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

Constraints:

n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i (i.e., there will be no self-loops).
All the elements of graph[i] are unique.
The input graph is guaranteed to be a DAG.
*/
class Solution {
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //directed acyclic graph -> no cycle +nt
        
        List<List<Integer>> ans = new ArrayList<>();
        move(graph, 0, new ArrayList<>(), ans);
        
        return ans;
    }
    
    public void move(int[][] graph, int node, List<Integer> path, List<List<Integer>> ans ){
        path.add(node);
        
        if(node == graph.length - 1)//last node
        {
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        
        //iterate next nodes
        for(int j = 0; j < graph[node].length; j++){
            move(graph, graph[node][j], path, ans);
        }
        
        
        //Backtracking
        path.remove(path.size() - 1);
        
    }
}
