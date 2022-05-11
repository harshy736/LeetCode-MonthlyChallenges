/*
1641. Count Sorted Vowel Strings
Medium

Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
Example 2:

Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
Example 3:

Input: n = 33
Output: 66045
 
Constraints:

1 <= n <= 50 
*/
class Solution {
    public int countVowelStrings(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        //a - represents no. of words that end with 'a'
        //e - represents no. of words that end with 'e'
        //i - represents no. of words that end with 'i'
        //o - represents no. of words that end with 'o'
        //u - represents no. of words that end with 'u'
        
        
        //simple approach is we we can place e on words ending with a or e only
        //for next round e' = e + a
        //and similar for every vowel
        
        //for eg - u' = a + e + i + o + u
        //insteady of doing it i simply write
        //u' = u + o', where e' = a + e + i + o
        for(int x = 2; x <= n; x++){
            e += a;//e' = e + a
            i += e;//i' = i + a + e = i + e'
            o += i;//o = o + i'
            u += o; //u = u + o'
        }
        
        int total = a + e + i + o + u;
        
        return total;
    }
}
