/*
149. Max Points on a Line
Hard
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

Example 1:

Input: points = [[1,1],[2,2],[3,3]]
Output: 3
Example 2:

Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
 
Constraints:

1 <= points.length <= 300
points[i].length == 2
-104 <= xi, yi <= 104
All the points are unique.
*/

class Solution {
    public int maxPoints(int[][] points) {
        //line direction -> slope
        //if slope is same then same line
        
        //naive approach -> take every elements as start element and check all the possible slops -> take maximum points on line
        //use sorting to avoid repeatative calculation
        
        int n = points.length;
        if(n <= 2)
            return n;
        
        
        Arrays.sort(points, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));//sort by x & y
        //all points are unique
        
        int ans = 0;
        
        for(int i = 0; i < n - 1; i++){
            //System.out.println(points[i][0] + " -> " + points[i][1]);
            ans = Math.max(ans, getMax(points, i));
        }
        
        return ans;
    }
    
    private int getMax(int[][] points, int start){
        //try only for next points
        //bcz prev points all taken slopes with this start -> if that gives me answer then it gives
        
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int n = points.length;
        
        
        for(int j = start + 1; j < n; j++){
            int x = points[j][0] - points[start][0];
            int y = points[j][1] - points[start][1];
            
            if(x == 0 || y == 0){
                if(x == 0)
                    y = 1;
                else
                    x = 1;
            }else{
                //reduce x & y to its minimal form
                int g = gcd(Math.abs(x), Math.abs(y));
                x /= g;
                y /= g;
            }
            
            String slope = x + "#" + y;
            map.put(slope, map.getOrDefault(slope, 0) + 1);
        }
        
        for(int val : map.values()){
            res = Math.max(res, val);
        }
        
        //System.out.println(start + " -> " + points[start][1] + " -> " + res);
        
        return res + 1;
    }
    
    private int gcd(int a, int b){
        if(b == 0)
            return a;
        
        return gcd(b, a % b);
    }
}

