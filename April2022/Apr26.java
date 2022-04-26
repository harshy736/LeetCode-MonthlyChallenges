/*
1584. Min Cost to Connect All Points
Medium
You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Example 1:

Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation: 

We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.
Example 2:

Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18
 
Constraints:

1 <= points.length <= 1000
-106 <= xi, yi <= 106
All pairs (xi, yi) are distinct.
*/
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
                graph[i] = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph[i].add(new int[]{j, dist});
                graph[j].add(new int[]{i, dist});
            }
        }
        
        boolean[] vis = new boolean[n];
        int cost = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});
        while(!pq.isEmpty()){
            int[] rem = pq.remove();
            if(vis[rem[0]])
                continue;
            vis[rem[0]] = true;
            cost += rem[1];
            for(int[] nbr : graph[rem[0]])
                if(!vis[nbr[0]])
                    pq.add(nbr);
        }
        
        return cost;
    }
}
