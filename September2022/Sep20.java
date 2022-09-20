/*
718. Maximum Length of Repeated Subarray
Medium

Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

Example 1:

Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].
Example 2:

Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
Output: 5
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 100
*/
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        //same as str
        int n1 = nums1.length, n2 = nums2.length;
        
        int[][] dp = new int[n1 + 1][n2 + 1];
        //dp[i][j] -> stores length of repeation substring
        
        int ans = 0;
        
        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        
        return ans;
    }
}
