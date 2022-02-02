/*
438. Find All Anagrams in a String

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
        
        int[] freq1 = new int[26];//for p
        int[] freq2 = new int[26];//for s
        for(int i = 0; i < plen; i++){
            freq1[p.charAt(i) - 'a']++;
            freq2[s.charAt(i) - 'a']++;
        }
        
        if(Arrays.equals(freq1, freq2))
            list.add(0);
        
        int start = 0, end = plen;
        //word - s.substring(start, end)
        //use sliding window here
        
        while(end < slen){
            freq2[s.charAt(start) - 'a']--;//remove 1st
            freq2[s.charAt(end) - 'a']++;//add next char
            
            start++;
            end++;
            
            if(Arrays.equals(freq1, freq2))
                list.add(start);
        }
        
        return list;
    }
    
}
