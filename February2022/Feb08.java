/*
258. Add Digits
Easy
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

 

Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.
Example 2:

Input: num = 0
Output: 0
 

Constraints:

0 <= num <= 231 - 1
 

Follow up: Could you do it without any loop/recursion in O(1) runtime?

*/

class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        
        //Digital Root -> wikipedia page also available
        //Possible roots - 0, 1 to 9
        //multiples of 9 -> root = 9;
        //e.g 18 , 27 , 900, 360 any multiple
        //cycle starts from 1 to 9
        //starts from next number to multiple of 9
        //n % 9 = rem , rem is also root
        int rem = num % 9;
    
        if(rem == 0)
            return 9;
        
        return rem;
    }
}
