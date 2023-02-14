/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
*/

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int ia = a.length() - 1, ib = b.length() - 1;
        
        while(ia >= 0 && ib >= 0){
            int va = a.charAt(ia) - '0';
            int vb = b.charAt(ib) - '0';
            
            int sum = va + vb + carry;
            carry = sum / 2;
            sum = sum % 2;
            
            sb.insert(0, sum);
            
            ia--;
            ib--;
        }
        
        while(ia >= 0){
            int va = a.charAt(ia) - '0';
            int sum = va + carry;
            carry = sum / 2;
            sum = sum % 2;
            
            sb.insert(0, sum);
            
            ia--;
        }
        
        while(ib >= 0){
            int vb = b.charAt(ib) - '0';
            int sum = vb + carry;
            carry = sum / 2;
            sum = sum % 2;
            
            sb.insert(0, sum);
            
            ib--;
        }
        
        if(carry == 1){
            sb.insert(0, '1');
        }
        
        
        return sb.toString();
    }
}
