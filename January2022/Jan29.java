/*
84. Largest Rectangle in Histogram

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] lessFromLeft = new int[n];
        int[] lessFromRight = new int[n];
        int area = 0;
        
        for(int i = 0; i < n; i++){
            int p = i - 1;
            while(p >= 0 && heights[p] >= heights[i]){
                p = lessFromLeft[p];
                //bcz no need to jump on p which has more height than height[p] -> bcz it also have greater height than ith
            }
            
            lessFromLeft[i] = p;
        }
        
        for(int i = n - 1; i >= 0; i--){
            int p = i + 1;
            while(p < n && heights[p] >= heights[i])
                p = lessFromRight[p];//bcz no need to jump on p which has more height than height[p] -> bcz it also have greater height than ith
            
            lessFromRight[i] = p;
        }
        
        for(int i = 0; i < n; i++){
            area = Math.max(area, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        
        return area;
    }
}
