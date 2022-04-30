/*
399. Evaluate Division
Medium
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 

Constraints:

1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.
*/
class Solution {
    class Pair{
        String nbr;
        double w;
        
        Pair(String nbr, double weight){
            this.nbr = nbr;
            this.w = weight;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair>> graph = new HashMap<>();
        int n = values.length;
        
        for(int i = 0; i < n; i++){
            String u = equations.get(i).get(0), v = equations.get(i).get(1);
            
            if(!graph.containsKey(u))
                graph.put(u, new ArrayList<>());
            if(!graph.containsKey(v))
                graph.put(v, new ArrayList<>());
            
            graph.get(u).add(new Pair(v, values[i]));
            graph.get(v).add(new Pair(u, 1 / values[i]));
        }
        
        int m = queries.size();
        double[] ans = new double[m];
        for(int i = 0; i < m; i++){
            String u = queries.get(i).get(0), v = queries.get(i).get(1);
            
            if(!graph.containsKey(u) || !graph.containsKey(v)){//atleast 1 vertex missing -> no path
                ans[i] = -1.0;
            }else if(u.equals(v)){
                ans[i] = 1.0;
            }else{
                double val = dfs(graph, u, v, new HashSet<>());
                ans[i] = val;
            }
        }
        
        return ans;
        
    }
    
    private double dfs(HashMap<String, List<Pair>> graph, String u, String tar, HashSet<String> visited){
        //base case
        if(u.equals(tar))
            return 1.0;
        
        visited.add(u);//visted vertex
        double ans = -1.0;
        
        for(Pair p : graph.get(u)){
            if(!visited.contains(p.nbr)){
                double val = dfs(graph, p.nbr, tar, visited);
                if(val != -1.0){
                    ans = p.w * val;
                    break;
                }
            }
        }
        
        return ans;
    }
}
