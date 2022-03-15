/*
1249. Minimum Remove to Make Valid Parentheses
Medium
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 
Constraints:

1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.
*/
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        
        int open = 0;
        //for extra close brackets
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '(')
                open++;
            else if(arr[i] == ')'){
                if(open == 0)
                    arr[i] = '#';//not includede
                else
                    open--;
            }
        }
        
        open = 0;
        //for extra open brackets
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] == ')')
                open--;
            else if(arr[i] == '('){
                if(open == 0)
                    arr[i] = '#';
                else
                    open++;
            }
        }
    
        for(char ch : arr){
            if(ch != '#')
                sb.append(ch);
        }
        
        return String.valueOf(sb);
    }
}
