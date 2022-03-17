/*
856. Score of Parentheses
Medium

Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 
Example 1:

Input: s = "()"
Output: 1
Example 2:

Input: s = "(())"
Output: 2
Example 3:

Input: s = "()()"
Output: 2
 

Constraints:

2 <= s.length <= 50
s consists of only '(' and ')'.
s is a balanced parentheses string.
*/

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        
        //-1 -> means (
        for(char ch : s.toCharArray()){
            if(ch == '(')
                st.push(-1);
            else{
                int c = 0;
                while(st.peek() != -1)//(A)
                    c += st.pop();
                
                st.pop();//remove (
                if(c == 0)
                    st.push(1);
                else
                    st.push(2 * c);
            }
        }
        
        int score = 0;
        while(!st.isEmpty()){
            score += st.pop();
        }
        
        return score;
    }
}
