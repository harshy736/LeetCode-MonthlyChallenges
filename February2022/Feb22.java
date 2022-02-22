/*
171. Excel Sheet Column Number
Easy
Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701
 

Constraints:

1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"].
*/

class Solution {
    public int titleToNumber(String columnTitle) {
        //it is like a base 26 number
        //e.g ZY = Z * 26^1 + Y * 26^0 = 26*26 + 25*1 = 676 + 25 = 701
        //Given : Base 26 number
        //Convert it into base 10
        
        int ans = 0;
        int p = 1;
        
        for(int i = columnTitle.length() - 1; i >= 0; i--){
            int digit = columnTitle.charAt(i) - 'A' + 1;//digit corresponding to that character
            
            ans += digit * p;
            p *= 26;//increase p w.r.t base 26
        }
        
        return ans;
        
    }
}
