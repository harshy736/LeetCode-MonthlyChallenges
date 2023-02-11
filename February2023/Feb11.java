/*
1129. Shortest Path with Alternating Colors
Medium
You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1. Each edge is red or blue in this graph, and there could be self-edges and parallel edges.

You are given two arrays redEdges and blueEdges where:

redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x such that the edge colors alternate along the path, or -1 if such a path does not exist.

Example 1:

Input: n = 3, redEdges = [[0,1],[1,2]], blueEdges = []
Output: [0,1,-1]
Example 2:

Input: n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]
Output: [0,1,-1]
 
Constraints:

1 <= n <= 100
0 <= redEdges.length, blueEdges.length <= 400
redEdges[i].length == blueEdges[j].length == 2
0 <= ai, bi, uj, vj < n
*/

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> redGraph = new ArrayList<>();
        List<List<Integer>> blueGraph = new ArrayList<>();
        
        for(int i = 0; i <  n; i++){
            redGraph.add(new ArrayList<>());
            blueGraph.add(new ArrayList<>());
        }
        
        for(int[] edge : redEdges){
            redGraph.get(edge[0]).add(edge[1]);
        }
        for(int[] edge : blueEdges){
            blueGraph.get(edge[0]).add(edge[1]);
        }
        
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
        //true -> next edge is to be red
        bfs(redGraph, blueGraph, answer, true);
        bfs(redGraph, blueGraph, answer, false);
        
        return answer;
    }
    
    private void bfs(List<List<Integer>> redGraph, List<List<Integer>> blueGraph, int[] answer, boolean isRed){
        int n = answer.length;
        boolean[] rvis = new boolean[n], bvis = new boolean[n];
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();//nodes in this level
            
            //iterate full level
            while(size-- > 0){
                int node = q.remove();
                
                if(answer[node] == -1){
                    answer[node] = steps;
                }else{
                    answer[node] = Math.min(answer[node], steps);
                }

                if(isRed){
                    bvis[node] = true;
                    for(Integer nbr : redGraph.get(node)){
                        if(!rvis[nbr]){
                            q.add(nbr);
                        }
                    }
                }else{
                    rvis[node] = true;
                    for(Integer nbr : blueGraph.get(node)){
                        if(!bvis[nbr]){
                            q.add(nbr);
                        }
                    }
                }
            }
            
            steps++;//next level
            isRed = !isRed;//different color for next edge
        }
    }
}
