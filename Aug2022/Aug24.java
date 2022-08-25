/*
326. Power of Three
Easy
Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

Example 1:

Input: n = 27
Output: true
Example 2:

Input: n = 0
Output: false
Example 3:

Input: n = 9
Output: true
 

Constraints:

-231 <= n <= 231 - 1
*/

class Solution {
    public boolean isPowerOfThree(int n) {
        double pow = Math.log10(n) / Math.log10(3);
        if(pow % 1 == 0)//power of three -> no decimal perfect power
            return true;
        
        return false;//decimal in power 
    }
}
