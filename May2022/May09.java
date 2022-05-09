/*
17. Letter Combinations of a Phone Number
Medium

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
Accepted
1,187,690
Submissions
2,202,027
*/
import java.util.*;

class Solution {
    private static String[] keys = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    List<String> ans = new ArrayList<>();
    
    public void getComb(String digits, int currIndex, String currString){//s ->  index on digit
        
        if(currIndex == digits.length()){
            ans.add(currString);
            return;
        }
        
        int dig = digits.charAt(currIndex) - '0';
        String code = keys[dig];
       

        for(char ch : code.toCharArray()){
            getComb(digits, currIndex + 1, currString + ch);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return ans;
        }
        
        getComb(digits, 0, "");
        
        return ans;
    }
}
