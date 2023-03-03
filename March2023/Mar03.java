/*
28. Find the Index of the First Occurrence in a String
Medium
2.6K
134
Companies
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length(), n2 = needle.length();
        if(n2 == 0)
            return 0;
        if(n2 > n1)
            return -1;
        
        //USing Z algorithm
        String str = needle + "$" + haystack;
        char[] arr = str.toCharArray();
        int len = arr.length;
        int tarLen = needle.length();
        
        int[] z = new int[len];
        
        int l = 0, r = 0;
        for(int i = tarLen + 1; i < len; i++){
            if(i <= r){
                z[i] = Math.min(r - z[i] + 1, z[i - l]);
            }
            
            while(i + z[i] < len && arr[z[i]] == arr[i + z[i]]){
                z[i]++;
            }
            
            if(i + z[i] - 1 > r){
                r = i + z[i] - 1;
                l = i;
            }
            
            if(z[i] == tarLen)
                return i - tarLen - 1;
        }
        
        return -1;
    }
}
