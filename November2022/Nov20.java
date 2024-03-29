/*
224. Basic Calculator
Hard
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 
Constraints:

1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer.
*/

class Solution {
    public int calculate(String s) {//NOT
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;//answer
        
        int num = 0;
        int sign = 1;//default +
        
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = 10 * num + (int)(c - '0');
            }else if(c == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);//previous result stored
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                result += sign * num;  
                num = 0;
                
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        
        if(num != 0)
            result += sign * num;
        
        return result;
    }
}class Solution {
    public int calculate(String s) {//NOT
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;//answer
        
        int num = 0;
        int sign = 1;//default +
        
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = 10 * num + (int)(c - '0');
            }else if(c == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);//previous result stored
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                result += sign * num;  
                num = 0;
                
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        
        if(num != 0)
            result += sign * num;
        
        return result;
    }
}class Solution {
    public int calculate(String s) {//NOT
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;//answer
        
        int num = 0;
        int sign = 1;//default +
        
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = 10 * num + (int)(c - '0');
            }else if(c == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);//previous result stored
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                result += sign * num;  
                num = 0;
                
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        
        if(num != 0)
            result += sign * num;
        
        return result;
    }
}class Solution {
    public int calculate(String s) {//NOT
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;//answer
        
        int num = 0;
        int sign = 1;//default +
        
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = 10 * num + (int)(c - '0');
            }else if(c == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);//previous result stored
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                result += sign * num;  
                num = 0;
                
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        
        if(num != 0)
            result += sign * num;
        
        return result;
    }
}class Solution {
    public int calculate(String s) {//NOT
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;//answer
        
        int num = 0;
        int sign = 1;//default +
        
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = 10 * num + (int)(c - '0');
            }else if(c == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);//previous result stored
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                result += sign * num;  
                num = 0;
                
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        
        if(num != 0)
            result += sign * num;
        
        return result;
    }
}class Solution {
    public int calculate(String s) {//NOT
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;//answer
        
        int num = 0;
        int sign = 1;//default +
        
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = 10 * num + (int)(c - '0');
            }else if(c == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);//previous result stored
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                result += sign * num;  
                num = 0;
                
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        
        if(num != 0)
            result += sign * num;
        
        return result;
    }
}class Solution {
    public int calculate(String s) {//NOT
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;//answer
        
        int num = 0;
        int sign = 1;//default +
        
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = 10 * num + (int)(c - '0');
            }else if(c == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);//previous result stored
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                result += sign * num;  
                num = 0;
                
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        
        if(num != 0)
            result += sign * num;
        
        return result;
    }
}class Solution {
    public int calculate(String s) {//NOT
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;//answer
        
        int num = 0;
        int sign = 1;//default +
        
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = 10 * num + (int)(c - '0');
            }else if(c == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);//previous result stored
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                result += sign * num;  
                num = 0;
                
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        
        if(num != 0)
            result += sign * num;
        
        return result;
    }
}
