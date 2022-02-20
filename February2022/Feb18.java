/*
402. Remove K Digits
Medium
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
*/
class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        int prev = 0;
    
        Stack<Character> st = new Stack<>();
        while(prev < num.length()){
            while(!st.isEmpty() && num.charAt(prev) - '0' < st.peek() - '0' && k > 0){
                k--;
                st.pop();
            }
            st.add(num.charAt(prev));
            prev++;
        }
        
        while(k > 0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());
        
        while(sb.length() > 0 && sb.charAt(sb.length() - 1) == '0'){
            sb.deleteCharAt(sb.length() - 1);
        }
        
        num = sb.reverse().toString();
        return num.length() == 0 ? "0" : num;
    }
}