/*
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> sp = new ArrayList<>();
        
        int sr = 0, sc = 0, er = matrix.length - 1, ec = matrix[0].length - 1;
        
        while(sr <= er && sc <= ec){

            for(int j = sc; j <= ec; j++){
                sp.add(matrix[sr][j]);
            }
            sr++;

            for(int i = sr; i <= er; i++){
                sp.add(matrix[i][ec]);
            }
            ec--;
            
            if(sc <= ec && sr <= er){
                for(int j = ec; j >= sc; j--){
                    sp.add(matrix[er][j]);
                }
                er--;
            }
            
            if(sr <= er && sc <= ec){
                for(int i = er; i >= sr; i--){
                    sp.add(matrix[i][sc]);
                }
                sc++;
            }
            
        }
        
        return sp;
    }
}
