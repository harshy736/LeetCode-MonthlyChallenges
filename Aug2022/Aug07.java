/*
1220. Count Vowels Permutation
Hard

1430

113

Add to List

Share
Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

 

Example 1:

Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
Example 2:

Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
Example 3: 

Input: n = 5
Output: 68
 

Constraints:

1 <= n <= 2 * 10^4
*/

class Solution {
    public int countVowelPermutation(int n) {
        int mod = (int)(1e9 + 7);
        //without dp array
        //same logic -> start filling characters in starting
        
        long ac = 1L, ec = 1L, ic = 1L, oc = 1L, uc = 1L;//count for n = 1
        
        //apply every condition
        for(int i = 1; i < n; i++){//run n - 1 times more for len n
            //fill for every char
            
            //a
            long acn = ec;//with e
            
            //e
            long ecn = (ac + ic) % mod;
            
            //i
            long icn = (ac + ec + oc + uc) % mod;
            
            //o
            long ocn = (ic + uc) % mod;
            
            //u
            long ucn = ac;
            
            //change
            ac = acn;
            ec = ecn;
            ic = icn;
            oc = ocn;
            uc = ucn;
        }
        
        long ans = (ac + ec + ic + oc + uc) % mod;
        
        int res = (int)ans;
        return res;
    }
}
