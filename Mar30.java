/*
74. Search a 2D Matrix
Medium
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        
        while(r < matrix.length){
            if(matrix[r][0] > target) 
                return false;
            else if(r != matrix.length - 1 && matrix[r + 1][0] <= target){//belongs to next row
                r++;
            }else{
                for(int c = 0; c < matrix[0].length; c++){
                    if(matrix[r][c] == target) return true;
                    else if(matrix[r][c] > target) break;
                }
                break;
            }

        }
        
        return false;
    }
}
