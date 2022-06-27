/*
1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
Medium

A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.

Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.

Example 1:

Input: n = "32"
Output: 3
Explanation: 10 + 11 + 11 = 32
Example 2:

Input: n = "82734"
Output: 8
Example 3:

Input: n = "27346209830709182346"
Output: 9
 
Constraints:

1 <= n.length <= 105
n consists of only digits.
n does not contain any leading zeros and represents a positive integer.
*/
class Solution {
    public int minPartitions(String n) {//self 2-> O(n)
        int ans = 0, len = n.length();
        
       //for every digit we need digit decibinary's 1 at that position
        //like 4, -> we need 1, 1, 1, 1
        //maximum steps -> max digit
        
        
        for(int i = 0; i < len; i++){
            ans = Math.max(ans, n.charAt(i) - '0');//steps required to make this digit
        }
        
        return ans;
    }
}
