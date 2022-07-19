/*
118. Pascal's Triangle
Easy

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 
Constraints:

1 <= numRows <= 30
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int r = 0; r < numRows; r++){
            List<Integer> level = new ArrayList<>();
            for(int c = 0; c <= r; c++){
                if(c == 0 || c == r){
                    level.add(1);
                }else{
                    int val = ans.get(r - 1).get(c - 1) + ans.get(r - 1).get(c);
                    level.add(val);
                }
            }
            
            ans.add(level);
        }
        
        return ans;
    }
}
