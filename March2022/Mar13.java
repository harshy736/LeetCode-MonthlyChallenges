/*
20. Valid Parentheses
Easy
Share
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        boolean check = true;
        
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else if(st.size() == 0){
                check = false;
            }else{
                if(ch == ')'){
                    if(st.peek() != '('){
                        check = false;
                    }else{//'(' -> pop
                        st.pop();
                    }
                }else if(ch == '}'){
                    if(st.peek() != '{'){
                        check = false;
                    }else{//'{' -> pop
                        st.pop();
                    }
                }else{//]
                    if(st.peek() != '['){
                        check = false;
                    }else{//'[' -> pop
                        st.pop();
                    }
                }
            }
            
            if(check == false){
                break;
            }
        }
        
        if(st.size() > 0){
            check = false;
        }
        
        
        return check;
    }
}
