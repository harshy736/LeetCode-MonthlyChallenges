/*
1071. Greatest Common Divisor of Strings
Easy
2.4K
383
Companies
For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
 
Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.
*/

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str2.length() > str1.length()){
            return gcdOfStrings(str2, str1);
        }
        
        //x would be from str2 -> str2 = x + x + ..... + x
        //x must start from 0th index
        // x length must divide s1(len) && s2(len)

        //now check for x
        for(int e = str2.length(); e > 0; e--){
            if(isDivisor(str2, str2, e) && isDivisor(str1, str2, e)){
                return str2.substring(0, e);
            }
        }

        return "";
    }

    public boolean isDivisor(String s, String t, int e){
        if(s.length() % e != 0)//rem > 0
            return false;

        //now check concatenation

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i % e))//condition doesn't satisfy'
                return false;
        }

        return true;
    }
}
