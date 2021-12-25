/*
227. Basic Calculator IIGiven a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
*/

class Solution {
    public int calculate(String s) {
        Stack<Integer> val = new Stack<>();
        
        int i = 0, n = s.length(), num = 0, ans = 0;
        char ch = ' ', op = '+';
        
        while(i < n){
            ch = s.charAt(i);
            
            if(ch == ' '){
                i++;
                continue;
            }else if(Character.isDigit(ch))
                num = num * 10 + (ch - '0');
            else{//new operator comes
                //solve previous operator
                if(op == '+')
                    val.push(num);
                else if(op == '-')
                    val.push(num * -1);
                else if(op == '*')
                    val.push(val.pop() * num);
                else
                    val.push(val.pop() / num);
                
                num = 0;
                op = ch;
            }
            
            i++;
        }
        
        //for last num
        if(op == '+')
            val.push(num);
        else if(op == '-')
            val.push(num * -1);
        else if(op == '*')
            val.push(val.pop() * num);
        else
            val.push(val.pop() / num);
       
        //solve stack
        while(!val.isEmpty()){
            ans += val.pop();
        }
        
        return ans;
    }
}
