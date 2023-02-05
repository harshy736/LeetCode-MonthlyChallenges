/*
438. Find All Anagrams in a String
Medium
10.3K
298
Companies
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 
Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length(), plen = p.length();
        List<Integer> list = new ArrayList<>();
        
        if(slen < plen)return list;
        
        int[] freq = new int[26];//requirement of characters

        for(int i = 0; i < plen; i++){
            freq[p.charAt(i) - 'a']--;
        }
        
        
        //use sliding window here
        
        for(int i = slen - 1; i >= 0; i--){
            if(slen - i > plen)
                freq[s.charAt(i + plen) - 'a']--;
            
            freq[s.charAt(i) - 'a']++;

            if(slen - i >= plen){
                if(isAnagram(freq)){
                    list.add(i);
                }
            }
        }
        
        return list;
    }
    
    public boolean isAnagram(int[] freq){
        for(int val : freq){
            if(val != 0)
                return false;
        }

        return true;
    }
}
