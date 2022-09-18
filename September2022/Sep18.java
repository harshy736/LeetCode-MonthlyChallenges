/*
42. Trapping Rain Water
Hard

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 
Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
      
        int[] rge = new int[n];
        //rge[i] -> stores height of rightmost building +nt
        
        for(int i = n - 2; i >= 0; i--){
            rge[i] = Math.max(rge[i + 1], height[i + 1]);
        }
        
        int[] lge = new int[n];
        //lge[i] -> stores height of leftmost building +nt
        for(int i = 1; i < n; i++){
            lge[i] = Math.max(lge[i - 1], height[i - 1]);
        }
        
        //water should be kept only on those buildings which are having taller buildings on left and right side as well
        //water sholud be kepto upto max height of left anf right
        
        int ans = 0;
        for(int i = 0; i < n - 1; i++){
            int h = Math.min(lge[i], rge[i]);
            
            if(h > height[i]){//it stores some water
                ans += (h - height[i]);
            }
        }
        
        return ans;
    }
}
