/*
1288. Remove Covered Intervals
Medium
Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.

The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.

Return the number of remaining intervals.

 

Example 1:

Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
Example 2:

Input: intervals = [[1,4],[2,3]]
Output: 1
 

Constraints:

1 <= intervals.length <= 1000
intervals[i].length == 2
0 <= li <= ri <= 105
All the given intervals are unique.
*/
class Solution {
    public static int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        
        //sort by starting point -> increasing order
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] row1, int[] row2){
                if(row1[0] == row2[0])
                    return row2[1] - row1[1];//descending order of end point
                
                return row1[0] - row2[0];
            }
        });
        //eg. (1, 2), (1, 8), (2, 5)
        //sorting -> (1, 8), (1, 2), (2, 5)
        
        //c <= a -> always work only on b & d
        
        int prev = 0;//staring intervals
        int count = 1;//for first interval
        for(int i = 1; i < n; i++){
            //end point ith > end point prev -> need new interval 
            //only possible when starting points are different
            if(intervals[i][1] > intervals[prev][1]){//b > d --- new interval
                count++;//new interval
                prev = i;//for upcoming interval
            }
        }
        
        return count;
    }
}
