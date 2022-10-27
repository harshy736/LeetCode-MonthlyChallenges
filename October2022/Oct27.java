/*
835. Image Overlap
Medium

713

226

Add to List

Share
You are given two images, img1 and img2, represented as binary, square matrices of size n x n. A binary matrix has only 0s and 1s as values.

We translate one image however we choose by sliding all the 1 bits left, right, up, and/or down any number of units. We then place it on top of the other image. We can then calculate the overlap by counting the number of positions that have a 1 in both images.

Note also that a translation does not include any kind of rotation. Any 1 bits that are translated outside of the matrix borders are erased.

Return the largest possible overlap.

 

Example 1:


Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
Output: 3
Explanation: We translate img1 to right by 1 unit and down by 1 unit.

The number of positions that have a 1 in both images is 3 (shown in red).

Example 2:

Input: img1 = [[1]], img2 = [[1]]
Output: 1
Example 3:

Input: img1 = [[0]], img2 = [[0]]
Output: 0
 

Constraints:

n == img1.length == img1[i].length
n == img2.length == img2[i].length
1 <= n <= 30
img1[i][j] is either 0 or 1.
img2[i][j] is either 0 or 1.
*/

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        
    //Different approach -> with help
        //horizontal shift -> -n to n, vertical shift -> -n to n
        //2n + 1 shifts in an directions
        //to store the results of all the shifts
        //we use 2d array of size 2n + 1
        
        //and take diff + n -> to take [-n, n] to [0, 2n]
        
        int[][] count = new int[2 * n + 1][2 * n + 1];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(img1[i][j] == 1){//can contribute 
                    //check for all contributions
                    //and store it for the shifts
                    
                    for(int r = 0; r < n; r++){
                        for(int c = 0; c < n; c++){
                            if(img2[r][c] == 1){//can match with it
                                count[i - r + n][j - c + n] += 1;
                                //[hor shift + n][ver shift + n]
                            }
                        }
                    }
                }
            }
        }
        
        int ans = 0;
        
        //take maximum count from all possible shifts
        for(int[] arr : count){
            for(int val : arr){
                ans = Math.max(ans, val);
            }
        }
        
        return ans;
    }
}
