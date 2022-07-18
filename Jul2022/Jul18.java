/*
1074. Number of Submatrices That Sum to Target
Hard
Given a matrix and a target, return the number of non-empty submatrices that sum to target.

A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.

Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.

Example 1:

Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
Output: 4
Explanation: The four 1x1 submatrices that only contain 0.
Example 2:

Input: matrix = [[1,-1],[-1,1]], target = 0
Output: 5
Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
Example 3:

Input: matrix = [[904]], target = 0
Output: 0

Constraints:

1 <= matrix.length <= 100
1 <= matrix[0].length <= 100
-1000 <= matrix[i] <= 1000
-10^8 <= target <= 10^8
*/
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {//not
        //intuition from 1D subarray sum egaual to k
        
        int m = matrix.length, n = matrix[0].length;
        int count = 0;
        
        //cummmulative sum row wise -> take row as single array
        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        
        //iterating by columnns
        //fix 1st then iterate all last columns
        for(int c1 = 0; c1 < n; c1++){
            for(int c2 = c1; c2 < n; c2++){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);//for empty array
                int sum = 0;
                
                //iterate row wise
                for(int i = 0; i < m; i++){
                    sum += matrix[i][c2] - (c1 > 0 ? matrix[i][c1 - 1] : 0);//sum [c1, c2]
                    
                    count += map.getOrDefault(sum - target, 0);//no of subarrays possible with sum k in [c1, c2]
                    map.put(sum, map.getOrDefault(sum , 0) + 1);
                }
            }
        }
        
        return count;
    }
}
