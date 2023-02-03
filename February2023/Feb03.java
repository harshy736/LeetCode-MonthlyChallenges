/*
6. Zigzag Conversion
Medium
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 
Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
*/

class Solution {
    public String convert(String s, int numRows) {//new approach -> withoust using array
        int len = s.length();
        if(numRows == 1 || numRows >= len)
            return s;
        
        StringBuilder ans = new StringBuilder();
        int pos = 0;//in s
        int increment = 2 * numRows - 2;//analysed
        for(int r = 0; r < numRows; r++){
            if(r == 0 || r == numRows - 1){//for rows having chars in all columns -> step1 & step2 are same
                pos = r;//pos at first column for any row
                while(pos < len){
                    ans.append(s.charAt(pos));
                    pos += increment;
                }
            }else{
                int step1 = 2 * (numRows - r) - 2;//analysed
                //charcters in b/w 2 charcters in a row -> 2 * numRows - 3, +1 for next character -> 2*numRows - 2
                int step2 = increment - step1;//jump 2nd time; -> 2 * r + 2
                //step1 -> add -> step2 -> add -> step 1 ..
                //alternate steps are followed
                boolean evenJump = true;//step1
                
                pos = r;
                while(pos < len){
                    ans.append(s.charAt(pos));
                    
                    if(evenJump){
                        evenJump = false;
                        pos += step1;
                    }else{
                        evenJump = true;
                        pos += step2;
                    }
                }
             
            }
        }
        
        return String.valueOf(ans);
    }
}
