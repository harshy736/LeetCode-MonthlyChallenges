/*
363. Max Sum of Rectangle No Larger Than K
Hard

Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.

It is guaranteed that there will be a rectangle with a sum no larger than k.

 
Example 1:


Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
Example 2:

Input: matrix = [[2,2,-1]], k = 3
Output: 3
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-100 <= matrix[i][j] <= 100
-105 <= k <= 105
 

Follow up: What if the number of rows is much larger than the number of columns?
*/

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {//NOT
        //Naive approach - O(n2) * O(n2) -> O(n4) -> exploring all rectangles -> O(10^8) -> TL
        
        //Optimized approach -> O(R2) * O(ClogC)
        
        //take row as single array -> and now we have to find max subarray sum <= k
        //for sum == k
        //we solve in O(nlogn) using treeset -> storing subarray ssum
        //check if target - sum exists in treeset or not
        //+nt means there is a array from start whose deletion from currSum left the subarray sum with target sum
        //same for subarrays sum <= k
        //(sum - prev) <= k -> prev >= sum - k
        //search for ceil of (sum - k) - gives first prev which gives max sum but less than k
        
        //apply this approach in to handle columns case -> breadth/width
        //for length try every length possible from every row
        
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        
        
        //exploring all lengths from every row for rectangle
        for(int rowStart = 0; rowStart < m; rowStart++){
            int[] colSum = new int[n];
            //colSum[j] -> sum of all col elements of respective length
            
            for(int rowEnd = rowStart; rowEnd < m; rowEnd++){
                for(int col = 0; col < n; col++){
                    colSum[col] += matrix[rowEnd][col];
                } 
                
                //check sum of rectangle
                ans = Math.max(ans, find(colSum, k));
            }
        }
        
        return ans;
    }
    
    private int find(int[] arr, int k){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);//for whole subarray sum
        
        int sum = 0, res = Integer.MIN_VALUE;
        for(int val : arr){
            sum += val;
            
            int target = sum - k;//have to find prefsum >= target
            
            Integer prev = set.ceiling(target);
            
            if(prev != null){//if subarray by whose deletion subarry sum <= k
                res = Math.max(res, sum - prev);
            }
            
            set.add(sum);
        }
        
        return res;
    }
}
