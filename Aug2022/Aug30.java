/*
48. Rotate Image
Medium
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 
Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
*/
class Solution {
    public void rotate(int[][] matrix) {
        //reverse every column -> then take transpose
        
        //reverse columns
        for(int j = 0; j < matrix[0].length; j++){
            //By 2 pointer
            int tr = 0, br = matrix.length - 1;//tr -> top row, br -> bottom
            
            while(tr < br){
                int temp = matrix[tr][j];
                matrix[tr][j] = matrix[br][j];
                matrix[br][j] = temp;
                
                tr++;
                br--;
            }
        }
        
        //transpose
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix.length; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
